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

import it.filippo.stella.dmxdashboard.View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Stella Filippo
 */
public class MenuController implements ActionListener{

    private final MainFrame mf;

    public MenuController(MainFrame mf) {
        this.mf = mf;
        this.mf.setMenuListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getJButtonMenu()){
            if(mf.isMenuOpen()){
                this.mf.handleMenu(true);
            }
            else{
                this.mf.handleMenu(false);
            }
        }
    }
    
}
