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
import it.filippo.stella.dmxdashboard.Control.ServicesController;
import it.filippo.stella.dmxdashboard.Model.ApplicationCore;
import it.filippo.stella.dmxdashboard.Model.LightEngine;
import it.filippo.stella.dmxdashboard.View.Dialogs.DevicesDialog;
import it.filippo.stella.dmxdashboard.View.Dialogs.LightDialog;
import it.filippo.stella.dmxdashboard.View.Dialogs.WizardDialog;
import it.filippo.stella.dmxdashboard.View.MainFrame;
import it.filippo.stella.dmxdashboard.View.Panels.PanelConfigurazione;
import it.filippo.stella.dmxdashboard.View.Panels.PanelEffetti;
import it.filippo.stella.dmxdashboard.View.Panels.PanelLuci;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Stella Filippo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Main.setColors();
        //Model Classes
        LightEngine le = new LightEngine();
        ApplicationCore ac = new ApplicationCore(le);
        
        //View Classes
        MainFrame mf = new MainFrame(ac);
        LightDialog ld = new LightDialog(mf, ac, true);
        WizardDialog wd = new WizardDialog(mf, true);
        DevicesDialog dd = new DevicesDialog(mf, true);
        PanelEffetti mp = new PanelEffetti();
        PanelLuci pl = new PanelLuci(ac, ld);
        PanelConfigurazione pc = new PanelConfigurazione(mf, dd, ac);
        
        //Controller Classes
        MenuController mc = new MenuController(mf, mp, pl, pc, ld, wd, ac);
        ServicesController sc = new ServicesController(mf, pc, ac);
        
        //Initialization
        
        //MainFrame Visible
        mf.setVisible(true);
    }
    
    public static void setColors(){
        UIManager.put("ComboBox.background", new Color(248, 248, 255));
        UIManager.put("JTextField.background", new Color(248, 248, 255));
        UIManager.put("ComboBox.selectionBackground", new Color(248, 248, 255));
        UIManager.put("ComboBox.selectionForeground", new Color(37, 50, 55));
        UIManager.put("ComboBox.foreground", new Color(37, 50, 55));
        UIManager.put("Spinner.background", new Color(248, 248, 255));
        UIManager.put("Spinner.foreground", new Color(37, 50, 55));
    }
    
}
