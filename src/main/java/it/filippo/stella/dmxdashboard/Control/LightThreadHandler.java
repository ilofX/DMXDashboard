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
package it.filippo.stella.dmxdashboard.Control;

import it.filippo.stella.dmxdashboard.Model.ApplicationCore;
import it.filippo.stella.dmxdashboard.Model.LightEngine;
import it.filippo.stella.dmxdashboard.View.Panels.PanelEffetti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Stella Filippo
 * @version 1.0
 */
public class LightThreadHandler implements ActionListener{

    private final LightEngine le;
    private final ApplicationCore ac;
    private final PanelEffetti pe;

    public LightThreadHandler(LightEngine le, ApplicationCore ac, PanelEffetti pe) {
        this.le = le;
        this.ac = ac;
        this.pe = pe;
        this.pe.getjButton1().addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.pe.getjButton1()){
            this.le.setEffect(this.pe.getjComboBox1().getSelectedItem().toString(), this.ac.getMc(), this.pe.getColor().getRed(), this.pe.getColor().getGreen(), this.pe.getColor().getBlue(), (Integer)this.pe.getjSpinner1().getValue());
        }
    }

}
