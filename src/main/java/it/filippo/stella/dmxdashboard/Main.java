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
package it.filippo.stella.dmxdashboard;

import it.filippo.stella.dmxdashboard.Control.MenuController;
import it.filippo.stella.dmxdashboard.View.MainFrame;
import it.filippo.stella.dmxdashboard.View.Panels.MainPanel;
import javax.swing.JLayeredPane;

/**
 *
 * @author Stella Filippo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        //Model Classes
        
        //View Classes
        MainFrame mf = new MainFrame();
        MainPanel mp = new MainPanel();
        
        //Controller Classes
        MenuController mc = new MenuController(mf);
        
        //MainFrame Visible
        mf.addLayer(mp, JLayeredPane.DRAG_LAYER);
        mp.setBounds(0, 20, 800, 570);
        mf.setVisible(true);
    }
    
}
