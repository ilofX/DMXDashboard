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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.util.ArrayList;
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

public class SaveManager {
    
    private File saveFile;
    private String IP="0/0/0/0";
    private Integer Port=0;
    private ArrayList<Luce> al;
    private FileInputStream fis=null;
    private PrintWriter pr=null;
    private boolean firstOpen=false;   
    private boolean isDefaultLocation=true;
    
    public SaveManager() {
        this.al=new ArrayList<>(); 
        try { 
            if((System.getProperty("os.name").toLowerCase()).contains("windows")){
                if(!(this.saveFile=new File(System.getenv("APPDATA")+"/ADF-ModBusConnector")).exists()){
                    this.saveFile.mkdir();
                    this.firstOpen=true;
                }
                if(!(this.saveFile=new File(System.getenv("APPDATA")+"/ADF-ModBusConnector/Save.json")).exists()){
                    this.saveFile.createNewFile();
                    this.firstOpen=true;
                }
            }
            else if((System.getProperty("os.name").toLowerCase()).contains("mac")){
                if(!(this.saveFile=new File(System.getenv("HOME")+"/Library/Preferences/ADF-ModBusConnector")).exists()){
                    this.saveFile.mkdir();
                    this.firstOpen=true;
                }
                if(!(this.saveFile=new File(System.getenv("HOME")+"/Library/Preferences/ADF-ModBusConnector/Save.json")).exists()){
                    this.saveFile.createNewFile();
                    this.firstOpen=true;
                }
            }
            else if((System.getProperty("os.name").toLowerCase()).contains("linux")){
                if(!(this.saveFile=new File(System.getenv("HOME")+"/.ADF-ModBusConnector")).exists()){
                    this.saveFile.mkdir();
                    this.firstOpen=true;
                }
                if(!(this.saveFile=new File(System.getenv("HOME")+"/.ADF-ModBusConnector/Save.json")).exists()){
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
            Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void changeLocation(String location){
        this.saveFile=new File(location);
    }
    
    public boolean doSave(){
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
            Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ris;
    }
    
    private JSONObject createSave(){
        JSONObject ris = new JSONObject();
        ris.put("IP", this.IP);
        ris.put("Port", this.Port);
        ris.put("Lights", this.createLightArray());
        return ris;
    }
    
    private JSONArray createLightArray(){
        return new JSONArray(this.al);
    }
    
    private void restoreLightArray(JSONArray lights){
        
    }
    
    public boolean doRestore(){
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
            this.restoreLightArray(save.getJSONArray("Lights"));
        } catch (FileNotFoundException ex) {
            ris = false;
            Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ris = false;
            Logger.getLogger(SaveManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ris;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Integer getPort() {
        return Port;
    }

    public void setPort(Integer Port) {
        this.Port = Port;
    }
    
}
