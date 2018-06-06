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
package it.filippo.stella.dmxdashboard.Control;

import it.filippo.stella.dmxdashboard.Model.ApplicationCore;
import it.filippo.stella.dmxdashboard.View.MainFrame;
import it.filippo.stella.dmxdashboard.View.Panels.PanelConfigurazione;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo
 * @version 1.0
 */
public class ServicesController implements MouseListener{

    private final MainFrame mf;
    private final PanelConfigurazione pc;
    private final ApplicationCore ac;

    public ServicesController(MainFrame mf, PanelConfigurazione pc, ApplicationCore ac) {
        this.mf = mf;
        this.pc = pc;
        this.ac = ac;
        this.mf.getjLabelConnessione().addMouseListener(this);
        this.mf.getjLabelServer().addMouseListener(this);
    }
            
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==this.mf.getjLabelConnessione()){
            if(this.ac.getMc()==null || !this.ac.getMc().isConnected()){
                this.mf.getjLabelConnessione().setBackground(Color.YELLOW);
                try {
                    this.ac.setMc(this.pc.getIPAddress().getHostAddress(),this.pc.getPort());
                } catch (UnknownHostException ex) {
                    Logger.getLogger(ServicesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                this.ac.getMc().close();
            }
        }
        else if(e.getSource()==this.mf.getjLabelServer()){
        
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    
}
