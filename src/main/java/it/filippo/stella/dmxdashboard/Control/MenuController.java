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

import it.filippo.stella.dmxdashboard.View.Dialogs.ExitDialog;
import it.filippo.stella.dmxdashboard.View.Dialogs.LightDialog;
import it.filippo.stella.dmxdashboard.View.Dialogs.WizardDialog;
import it.filippo.stella.dmxdashboard.View.MainFrame;
import it.filippo.stella.dmxdashboard.View.Panels.PanelConfigurazione;
import it.filippo.stella.dmxdashboard.View.Panels.PanelEffetti;
import it.filippo.stella.dmxdashboard.View.Panels.PanelLuci;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Stella Filippo
 */
public class MenuController implements ActionListener{

    private final MainFrame mf;
    private final PanelEffetti mp;
    private final PanelLuci pl;
    private final PanelConfigurazione pc;
    private final LightDialog ld;
    private final WizardDialog wd;

    public MenuController(MainFrame mf, PanelEffetti mp, PanelLuci pl, PanelConfigurazione pc, LightDialog ld, WizardDialog wd) {
        this.mf = mf;
        this.mp = mp;
        this.pl = pl;
        this.pc = pc;
        this.ld = ld;
        this.wd = wd;
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
        else if(e.getSource()==this.mf.getJButtonMain()){
            this.mf.getJPanelMain().removeAll();
            this.mf.getJPanelMain().add(this.mp);
            this.mf.revalidate();
            this.mf.repaint();    
            this.mf.handleMenu(true);
        }
        else if(e.getSource()==this.mf.getjButtonConfLight()){
            this.mf.getJPanelMain().removeAll();
            this.mf.getJPanelMain().add(this.pl);
            this.mf.revalidate();
            this.mf.repaint();    
            this.mf.handleMenu(true);
        }
        else if(e.getSource()==this.mf.getjButtonAppConfig()){
            this.mf.getJPanelMain().removeAll();
            this.mf.getJPanelMain().add(this.pc);
            this.mf.revalidate();
            this.mf.repaint();    
            this.mf.handleMenu(true);
        }
        else if(e.getSource()==this.mf.getjButtonWizard()){
            this.mf.handleMenu(true);  
            this.wd.setLocationRelativeTo(this.mf);
            this.wd.setVisible(true);
        }
        else if(e.getSource()==this.mf.getjButtonExit()){
            this.mf.handleMenu(true);
            new ExitDialog(this.mf, true);
        }
    }
    
}
