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

import com.digitalpetri.modbus.codec.Modbus;
import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;
import com.digitalpetri.modbus.requests.WriteMultipleRegistersRequest;
import com.digitalpetri.modbus.responses.WriteMultipleRegistersResponse;
import io.netty.util.ReferenceCountUtil;
import it.filippo.stella.dmxdashboard.View.MainFrame;
import it.filippo.stella.dmxdashboard.View.Panels.PanelEffetti;
import java.awt.Color;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Filippo Stella
 * @version 1.0
 */
public class ModbusConnection {
    
    private final MainFrame mf;
    private final PanelEffetti pe;
    private final ApplicationCore ac;
    private final LightEngine le;
    private final ModbusTcpMaster master;
    private boolean isConnected=false;

    public ModbusConnection(MainFrame mf, PanelEffetti pe, LightEngine le, ApplicationCore ac, String IP, Integer PORT) {
        this.mf = mf;
        this.le = le;
        this.ac = ac;
        this.pe = pe;
        ModbusTcpMasterConfig config = new ModbusTcpMasterConfig.Builder(IP).setPort(PORT).setTimeout(Duration.ofSeconds(1)).build();
        this.master = new ModbusTcpMaster(config);
        CompletableFuture future = this.master.connect();
        future.whenCompleteAsync((response, ex) -> {
            if (response != null) {
                ReferenceCountUtil.release(response);
            }
        },Modbus.sharedExecutor());
        if(future.isCompletedExceptionally()){
            this.close();
        }
        this.mf.getjPanelConnection().setBackground(new Color(0, 255, 0));
        this.pe.getjButton1().setEnabled(true);
        this.isConnected=true;
    }
    
    public void writeMultipleRegisters(byte v[]) {
        CompletableFuture<WriteMultipleRegistersResponse> future;
        WriteMultipleRegistersRequest request = new WriteMultipleRegistersRequest(0, v.length/2, v);
        future = this.master.sendRequest(request, 1);
        
        future.whenCompleteAsync((response,ex) -> {
            if (response != null) {
                ReferenceCountUtil.release(response);
                System.out.println("query OK");
            } else {
                Logger.getLogger(ModbusConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), "Completed exceptionally, message={}" + ex);
            }
        },Modbus.sharedExecutor());
    }
    
    public final void close(){
       CompletableFuture future = this.master.disconnect();
        future.whenCompleteAsync((response, ex) -> {
            if (response != null) {
                ReferenceCountUtil.release(response);
            }
        },Modbus.sharedExecutor());
        this.mf.getjPanelConnection().setBackground(new Color(144, 0, 0));
        this.pe.getjButton1().setEnabled(false);
        this.isConnected=false;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

}
