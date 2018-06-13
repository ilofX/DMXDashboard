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
import it.filippo.stella.dmxdashboard.Model.Utils.LightThread;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Stella
 * @version 2.0
 */
public class LightEngine {

    private final GiochiPsichedelici giochi;
    private LightThread t;
    private String effect;
    private ModbusConnection mc;
    private ApplicationCore ac;
    private final Random RAND;
    
    public LightEngine() {
        this.giochi = new GiochiPsichedelici();
        this.RAND = new Random();
    }
    
    public void setApplicationCore(ApplicationCore ac){
        this.ac = ac;
    }
    
    public final void setEffect(String effect, ModbusConnection mc, Integer R, Integer G, Integer B, Integer delay){
        this.effect = effect;
        this.mc = mc;
        if(this.t!=null && this.t.isAlive()){
            try {
                this.t.terminate();
                this.t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setNewThread(R, G, B, delay);
    }
        
    private final Thread setNewThread(Integer R, Integer G, Integer B, Integer delay){
        switch (this.effect){
            case "Solid Color":
                this.t = new LightThread(this.effect, delay, this.mc, this) {
                    @Override
                    public void run() {
                        this.send(GiochiPsichedelici.Set_every_led_at_Color(ac.getLightList(), new byte[512], R, G, B));
                    }
                };
                this.t.start();
                break;
            case "Rainbow Effect":
                this.t = new LightThread(this.effect, delay, this.mc, this) {
                    @Override
                    public void run() {
                        this.send(GiochiPsichedelici.Set_every_led_at_Color(ac.getLightList(), new byte[512], 0, 0, 0));
                        while(!this.terminate){
                            try {
                                this.send(GiochiPsichedelici.over_the_rainbow(ac.getLightList(), new byte[512]));
                                this.sleep(delay);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
                this.t.start();
                break;
            case "Random Colors":
                this.t = new LightThread(this.effect, delay, this.mc, this) {
                    @Override
                    public void run() {
                        this.send(GiochiPsichedelici.Set_every_led_at_Color(ac.getLightList(), new byte[512], 0, 0, 0));
                        while(!this.terminate){
                            try {
                                this.send(GiochiPsichedelici.random_psichedelico(ac.getLightList(), new byte[512]));
                                this.sleep(delay);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
                this.t.start();
                break;
            case "Jump Effect":
                this.t = new LightThread(this.effect, delay, this.mc, this) {
                    @Override
                    public void run() {
                        this.send(GiochiPsichedelici.Set_every_led_at_Color(ac.getLightList(), new byte[512], 0, 0, 0));
                        this.send(GiochiPsichedelici.set_only_one_lamp_at_color(ac.getLightList(), new byte[512], R, G, B, 0));
                        try {
                            this.sleep(20);
                            while(!this.terminate){
                                    this.send(GiochiPsichedelici.jump(ac.getLightList(), new byte[512], R, G, B));
                                    this.sleep(delay);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                this.t.start();
                break;
            case "Fading Lights":
                this.t = new LightThread(this.effect, delay, this.mc, this) {
                    @Override
                    public void run() {
                        this.send(GiochiPsichedelici.Set_every_led_at_Color(ac.getLightList(), new byte[512], 0, 0, 0));
                        try {
                            this.sleep(20);
                            while(!this.terminate){
                                    this.send(GiochiPsichedelici.aumento1(ac.getLightList(), new byte[512]));
                                    this.sleep(delay);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                this.t.start();
                break;
            case "Rainbow Jump":
                this.t = new LightThread(this.effect, delay, this.mc, this) {
                    @Override
                    public void run() {
                        this.send(GiochiPsichedelici.Set_every_led_at_Color(ac.getLightList(), new byte[512], 0, 0, 0));
                        try {
                            this.sleep(20);
                            int[] vet = new int[3];
                            vet[0]=255;
                            vet[1]=0;
                            vet[2]=0;
                            while(!this.terminate){
                                    vet = GiochiPsichedelici.jump_over_the_rainbow(ac.getLightList(), new byte[512], vet[0], vet[1], vet[2]);
                                    this.send(GiochiPsichedelici.jump(ac.getLightList(), new byte[512], vet[0], vet[1], vet[2]));
                                    this.sleep(delay);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                this.t.start();
                break;
            case "Supercar Visor":
                this.t = new LightThread(this.effect, delay, this.mc, this) {
                    @Override
                    public void run() {
                        this.send(GiochiPsichedelici.Set_every_led_at_Color(ac.getLightList(), new byte[512], 0, 0, 0));
                        try {
                            this.sleep(20);
                            while(!this.terminate){
                                    this.send(GiochiPsichedelici.psycho_delico_double_line(ac.getLightList(), new byte[512]));
                                    this.sleep(delay);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LightEngine.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                this.t.start();
                break;
            case "Automatic Mode":
                Integer rand = RAND.nextInt(6);
                String effetto;
                switch(rand){
                    case 0:
                        effetto = "Rainbow Effect";
                        break;
                    case 1:
                        effetto = "Random Colors";
                        break;
                    case 2:
                        effetto = "Jump Effect";
                        break;
                    case 3:
                        effetto = "Fading Lights";
                        break;
                    case 4:
                        effetto = "Rainbow Jump";
                        break;
                    case 5:
                        effetto = "Supercar Visor";
                        break;
                    default:
                        effetto = "Solid Color";
                        break;
                }
                this.setEffect(effetto, this.mc, RAND.nextInt(256), RAND.nextInt(256), RAND.nextInt(256), RAND.nextInt(101));
        }
        return null;
    }

    
}

