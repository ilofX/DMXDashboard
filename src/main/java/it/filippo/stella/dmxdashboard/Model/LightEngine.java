/*
 * Copyright 2018 Filippo Stella.
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

import it.filippo.stella.dmxdashboard.Model.Utils.GiochiPsichedelici;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Stella
 * @version 2.0
 */
public class LightEngine {

    private final GiochiPsichedelici giochi;
    private Thread t;
    private String effect;
    private ModbusConnection mc;
    
    public LightEngine() {
        this.giochi = new GiochiPsichedelici();
    }
    
    public final void setEffect(String effect, ModbusConnection mc, Integer R, Integer G, Integer B, Integer delay){
        this.effect = effect;
        if(this.t!=null && this.t.isAlive()){
            try {
                this.t.interrupt();
                this.t.join();
                this.setNewThread(R, G, B, delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    private final Thread setNewThread(Integer R, Integer G, Integer B, Integer delay){
        switch (this.effect){
            case "Solid Color":
                break;
            case "Rainbow Effect":
                break;
            case "Random Colors":
                break;
            case "Jump Effect":
                break;
            case "Running Lights":
                break;
            case "Fading Lights":
                break;
            case "Rainbow Jump":
                break;
            case "Supercar Visor":
                break;
            case "Aitomatic Mode":
                break;
            default:
                break;
        }
        
        return null;
    }
    
    
    
    
    
}

