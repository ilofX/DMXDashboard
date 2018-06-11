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

import org.json.JSONObject;

/**
 *
 * @author Filippo
 * @version 1.0
 */
public class Luce {
    
    private String tipo;
    private Integer nCanali;
    private Integer start;
    private Integer canaleR,canaleG,canaleB;
    private Integer valoreR,valoreG,valoreB;
    
    
     public Luce(Integer start, Integer nCanali, String tipo, Integer canaleR, Integer canaleG, Integer canaleB) {
        this.tipo=tipo;
        this.start=start;
        this.nCanali=nCanali;
        this.canaleR=canaleR;
        this.canaleG=canaleG;
        this.canaleB=canaleB;
        this.valoreR=0;
        this.valoreG=0;
        this.valoreB=0;
    }

    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Integer getnCanali() {
        return this.nCanali;
    }
    public void setnCanali(Integer nCanali) {
        this.nCanali = nCanali;
    }
    public Integer getStart() {
        return this.start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
    public Integer getCanaleR() {
        return this.canaleR;
    }
    public void setCanaleR(Integer canaleR) {
        this.canaleR = canaleR;
    }
    public Integer getCanaleG() {
        return this.canaleG;
    }
    public void setCanaleG(Integer canaleG) {
        this.canaleG = canaleG;
    }
    public Integer getCanaleB() {
        return this.canaleB;
    }
    public void setCanaleB(Integer canaleB) {
        this.canaleB = canaleB;
    }
    public Integer getValoreR() {
        return this.valoreR;
    }
    public void setValoreR(Integer valoreR) {
        this.valoreR = valoreR;
    }
    public Integer getValoreG() {
        return this.valoreG;
    }
    public void setValoreG(Integer valoreG) {
        this.valoreG = valoreG;
    }
    public Integer getValoreB() {
        return this.valoreB;
    }
    public void setValoreB(Integer valoreB) {
        this.valoreB = valoreB;
    }
    
    public JSONObject createJSONObject(){
        JSONObject ris = new JSONObject();
        ris.put("Tipo", this.tipo);
        ris.put("Start", this.start);             
        ris.put("nCanali", this.nCanali);
        ris.put("CanaleR", this.canaleR);
        ris.put("CanaleG", this.canaleG);
        ris.put("CanaleB", this.canaleB);
        return ris;
    }

}
