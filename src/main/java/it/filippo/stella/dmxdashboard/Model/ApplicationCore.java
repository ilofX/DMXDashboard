/*
 * Copyright 2018 Filippo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.filippo.stella.dmxdashboard.Model;

import it.filippo.stella.dmxdashboard.Model.Utils.StartChannelComparator;
import it.filippo.stella.dmxdashboard.View.MainFrame;
import it.filippo.stella.dmxdashboard.View.Panels.PanelEffetti;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Filippo
 * @version 1.0
 */

public class ApplicationCore {
    
    private MainFrame mf;
    private PanelEffetti pe;
    private final LightEngine le;
    private ModbusConnection mc;
    private File saveFile;
    private String IP;
    private Integer Port=502;
    private Integer ServerPort=0;
    private ArrayList<Luce> al;
    private FileInputStream fis=null;
    private PrintWriter pr=null;
    private boolean SecureConnection,AutostartConnection,SecureServer,AutostartServer;
    private boolean firstOpen=false;   
    private boolean isDefaultLocation=true;
    
    public ApplicationCore(LightEngine le) {
        this.le = le;
        this.mc=null;
        this.le.setApplicationCore(this);
        this.al=new ArrayList<>(); 
        try { 
            if((System.getProperty("os.name").toLowerCase()).contains("windows")){
                if(!(this.saveFile=new File(System.getenv("APPDATA")+"/ADF-DMXDashboard")).exists()){
                    this.saveFile.mkdir();
                    this.firstOpen=true;
                }
                if(!(this.saveFile=new File(System.getenv("APPDATA")+"/ADF-DMXDashboard/Save.json")).exists()){
                    this.saveFile.createNewFile();
                    this.firstOpen=true;
                }
            }
            else if((System.getProperty("os.name").toLowerCase()).contains("mac")){
                if(!(this.saveFile=new File(System.getenv("HOME")+"/Library/Preferences/ADF-DMXDashboard")).exists()){
                    this.saveFile.mkdir();
                    this.firstOpen=true;
                }
                if(!(this.saveFile=new File(System.getenv("HOME")+"/Library/Preferences/ADF-DMXDashboard/Save.json")).exists()){
                    this.saveFile.createNewFile();
                    this.firstOpen=true;
                }
            }
            else if((System.getProperty("os.name").toLowerCase()).contains("linux")){
                if(!(this.saveFile=new File(System.getenv("HOME")+"/.ADF-DMXDashboard")).exists()){
                    this.saveFile.mkdir();
                    this.firstOpen=true;
                }
                if(!(this.saveFile=new File(System.getenv("HOME")+"/.ADF-DMXDashboard/Save.json")).exists()){
                    this.saveFile.createNewFile();
                    this.firstOpen=true;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Operating System NOT Supported", "Errore", JOptionPane.ERROR_MESSAGE);
                System.err.println("Operating System NOT Supported");
                exit(6);
            }
        } catch (IOException ex) {
            Logger.getLogger(ApplicationCore.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!this.firstOpen){
            this.doRestore();
        } 
    }    
    public void changeLocation(String location){
        this.saveFile=new File(location);
    }
    
    public void doInit(){
        if(this.AutostartConnection){
            this.setMc(this.IP, this.Port);
        }
        if(this.AutostartServer){
        
        }
    }
    
    public void doClose(){
        if(this.mc!=null && this.mc.isConnected()){
            this.mc.close();
        }
        this.doSave();
    }
    
    public ArrayList getLightList(){
        return this.al;
    }
    
    public void setPe(PanelEffetti pe){
        this.pe = pe;
    }
    
    public final boolean doSave(){
        boolean ris=true;
        try {
            this.pr = new PrintWriter(this.saveFile);
            if(!this.saveFile.canWrite()){
                return false;
            }
            this.pr.println(this.createSave().toString());
            this.pr.flush();
            this.pr.close();
        } catch (FileNotFoundException ex) {
            ris=false;
            Logger.getLogger(ApplicationCore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ris;
    }
    
    private JSONObject createSave(){
        JSONObject ris = new JSONObject();
        ris.put("IP", this.IP);
        ris.put("Port", this.Port);
        ris.put("ServerPort", this.ServerPort);
        ris.put("AutostartServer", this.AutostartServer);
        ris.put("AutostartConnection", this.AutostartConnection);
        ris.put("SecureConnection", this.SecureConnection);
        ris.put("SecureServer", this.SecureServer);
        ris.put("Lights", this.createLightArray());
        return ris;
    }
    
    private JSONArray createLightArray(){
        JSONArray ris = new JSONArray();
        Iterator<Luce> i = this.al.iterator();
        while(i.hasNext()){
            Luce l = i.next();
            ris.put(l.createJSONObject());
        }
        return ris;
    }
    
    private void restoreLightArray(JSONArray lights){
        for(int i=0;i<lights.length();i++){
            JSONObject obj = lights.getJSONObject(i);
            Luce l = new Luce(obj.getInt("Start"), obj.getInt("nCanali"), obj.getString("Tipo"), obj.getInt("CanaleR"), obj.getInt("CanaleG"), obj.getInt("CanaleB"));
            this.al.add(l);
        }
    }
    
    public final boolean doRestore(){
        boolean ris = true;
        JSONObject save;
        try {
            this.fis = new FileInputStream(this.saveFile);
            if(!this.saveFile.canRead()){
                return false;
            }
            byte data[] = new byte[(int)this.saveFile.length()];
            this.fis.read(data);
            save = new JSONObject(new String(data));
            this.IP = save.getString("IP");
            this.Port = save.getInt("Port");
            this.ServerPort = save.getInt("ServerPort");
            this.AutostartConnection = save.getBoolean("AutostartConnection");
            this.AutostartServer = save.getBoolean("AutostartServer");
            this.SecureConnection = save.getBoolean("SecureConnection");
            this.SecureServer = save.getBoolean("SecureServer");
            this.restoreLightArray(save.getJSONArray("Lights"));
        } catch (FileNotFoundException ex) {
            ris = false;
            Logger.getLogger(ApplicationCore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ris = false;
            Logger.getLogger(ApplicationCore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ris;
    }

    public String getIP() {
        return this.IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Integer getPort() {
        return this.Port;
    }

    public void setPort(Integer Port) {
        this.Port = Port;
    }

    public void addLuce(Luce l){
        this.al.add(l);
        Collections.sort(this.al, new StartChannelComparator());
    }
    
    public Luce getLuce(Integer i){
        return this.al.get(i);
    }
    
    public void removeLuce(Integer i){
        this.al.remove(i.intValue());
        Collections.sort(this.al, new StartChannelComparator());
    }
    
    public void sortArray(){
        Collections.sort(this.al, new StartChannelComparator());
    }

    public Integer getServerPort() {
        return this.ServerPort;
    }

    public void setServerPort(Integer ServerPort) {
        this.ServerPort = ServerPort;
    }

    public boolean isSecureConnection() {
        return this.SecureConnection;
    }

    public void setSecureConnection(boolean SecureConnection) {
        this.SecureConnection = SecureConnection;
    }

    public boolean isAutostartConnection() {
        return this.AutostartConnection;
    }

    public void setAutostartConnection(boolean AutostartConnection) {
        this.AutostartConnection = AutostartConnection;
    }

    public boolean isSecureServer() {
        return this.SecureServer;
    }

    public void setSecureServer(boolean SecureServer) {
        this.SecureServer = SecureServer;
    }

    public boolean isAutostartServer() {
        return this.AutostartServer;
    }

    public void setAutostartServer(boolean AutostartServer) {
        this.AutostartServer = AutostartServer;
    }

    public ModbusConnection getMc() {
        return this.mc;
    }

    public void setMc(ModbusConnection mc) {
        this.mc = mc;
    }
    public void setMc(String IP, Integer PORT) {
        this.mc = new ModbusConnection(this.mf, this.pe, this.le, this, IP, PORT);
    }

    public MainFrame getMf() {
        return this.mf;
    }

    public void setMf(MainFrame mf) {
        this.mf = mf;
    }
        
    public Integer getLastChannel(){
        Integer ris=0;
        if(this.al.size()>0){
            if((this.al.get(0).getStart())>1){
                ris=1;
            }
            else{
                ris=(this.al.get(this.al.size()-1)).getStart()+(this.al.get(this.al.size()-1)).getnCanali();
            }   
        }
        return ris;
    }
    
    public Integer getFirstChannel(){
        Integer ris = 0;
        if(this.al.size()>0){
            ris=this.al.get(0).getStart();
        }
        return ris;
    }
    
    public void editLuce(Integer i, Integer start, Integer nCanali, String tipo, Integer canaleR, Integer canaleG, Integer canaleB){
        this.al.get(i).setTipo(tipo);
        this.al.get(i).setStart(start);
        this.al.get(i).setnCanali(nCanali);
        this.al.get(i).setCanaleR(canaleR);
        this.al.get(i).setCanaleG(canaleG);
        this.al.get(i).setCanaleB(canaleB);
    }
    
    public Integer getLightNumber(){
        return this.al.size();
    }
     
}
