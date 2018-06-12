/*
 * Copyright 2018 Stella Filippo.
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
package it.filippo.stella.dmxdashboard.Model.Utils;

import it.filippo.stella.dmxdashboard.Model.LightEngine;
import it.filippo.stella.dmxdashboard.Model.ModbusConnection;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Stella Filippo
 * @version 2.0
 */
public abstract class LightThread extends Thread {
    
    private final String effect;
    private final Integer delay;
    private final ModbusConnection conn;
    private final LightEngine le;
    private final Random RAND;

    public LightThread(String effect, Integer delay, ModbusConnection conn, LightEngine le) {
        super("LightTread"); 
        this.setPriority(MAX_PRIORITY);
        this.effect = effect;
        this.delay = delay;
        this.conn = conn;
        this.le = le;
        this.RAND = new Random();
    }
    
    private Color requestRandomColor(){
        return new Color(this.RAND.nextInt(256), this.RAND.nextInt(256), this.RAND.nextInt(256));    
    }
    
    private Integer requestRandomInteger(Integer bound){
        if(bound>0){
            return this.RAND.nextInt(bound);
        }
        else{
            return this.RAND.nextInt();
        }
    }
    
    private void send(byte[] ris){
        this.conn.writeMultipleRegisters(ris);
    }
    
    protected void splitArray(byte[] v, Integer first, Integer last){
        Integer length=last-first;
        if(length<200 && length>0){
            byte[] v1 = new byte[length];
            System.arraycopy(v, first, v1, length, length);
            this.send(v1);
        }
        else if(length>200 && length <400){
            byte[] v1 = new byte[200];
            byte[] v2 = new byte[length-200];
            System.arraycopy(v, first, v1, 0, 200);
            this.send(v1);
            System.arraycopy(v, first+200, v2, 0, length-200);
            this.send(v2);
        }
        else if(length>400 && length<=521){
            byte[] v1 = new byte[200];
            byte[] v2 = new byte[200];
            byte[] v3 = new byte[length-400];
            System.arraycopy(v, first, v1, 0, 200);
            this.send(v1);
            System.arraycopy(v, first+200, v2, 0, 200);
            this.send(v2);
            System.arraycopy(v, first+400, v3, 0, length-400);
            this.send(v3);
        }
    }

    @Override
    public abstract void run();
    
}
