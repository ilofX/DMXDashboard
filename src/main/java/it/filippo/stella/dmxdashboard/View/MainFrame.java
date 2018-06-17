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
package it.filippo.stella.dmxdashboard.View;

import it.filippo.stella.dmxdashboard.Model.ApplicationCore;
import it.filippo.stella.dmxdashboard.View.Dialogs.ExitDialog;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Stella Filippo
 * @version 1.0
 */
public class MainFrame extends javax.swing.JFrame implements WindowListener {

    private final ApplicationCore ac;
    
    public MainFrame(ApplicationCore ac) {
        this.ac = ac;
        this.ac.setMf(this);
        this.initComponents();
        this.initializeMenu();
        this.pack();
        this.addWindowListener(this);
        this.setLocationRelativeTo(null);
    }
    
    private void initializeMenu(){
        this.jLayeredPane1.setLayer(this.jPanelMenu, JLayeredPane.DRAG_LAYER);
        this.jPanelMenu.setBounds(0, 20, 0, 200);
        this.jPanelMenu.setPreferredSize(new Dimension(0, this.jPanelMenu.getHeight()));
        this.jPanelMenu.revalidate();
        this.jPanelMenu.repaint();
    }
    
    public final void setMenuListener(ActionListener al){
        this.jButtonMenu.addActionListener(al);
        this.jButtonEffetti.addActionListener(al);
        this.jButtonAppConfig.addActionListener(al);
        this.jButtonConfLight.addActionListener(al);
        this.jButtonExit.addActionListener(al);
        this.jButtonWizard.addActionListener(al);
    }
    
    public final void handleMenu(boolean toClose){
        new menuHandler(this.jPanelMenu, this.jButtonMenu, toClose).start();
    }
    
    public final boolean isMenuOpen(){
        return this.jPanelMenu.getWidth()>=200;
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelHead = new javax.swing.JPanel();
        jButtonMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jButtonEffetti = new javax.swing.JButton();
        jButtonAppConfig = new javax.swing.JButton();
        jButtonWizard = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonConfLight = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jPanelServer = new javax.swing.JPanel();
        jLabelServer = new javax.swing.JLabel();
        jPanelConnection = new javax.swing.JPanel();
        jLabelConnessione = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DMX Dashboard");
        setBackground(new java.awt.Color(21, 21, 21));
        setMinimumSize(new java.awt.Dimension(823, 660));
        setPreferredSize(new java.awt.Dimension(823, 660));

        jLayeredPane1.setForeground(new java.awt.Color(248, 248, 255));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(800, 600));
        jLayeredPane1.setOpaque(true);

        jPanelHead.setBackground(new java.awt.Color(92, 107, 115));
        jPanelHead.setMinimumSize(new java.awt.Dimension(800, 30));
        jPanelHead.setPreferredSize(new java.awt.Dimension(800, 30));

        jButtonMenu.setBackground(new java.awt.Color(92, 107, 115));
        jButtonMenu.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jButtonMenu.setForeground(new java.awt.Color(248, 248, 255));
        jButtonMenu.setText("Menu");
        jButtonMenu.setBorder(null);
        jButtonMenu.setBorderPainted(false);
        jButtonMenu.setFocusPainted(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 248, 255));
        jLabel2.setText("DMX Dashboard");

        javax.swing.GroupLayout jPanelHeadLayout = new javax.swing.GroupLayout(jPanelHead);
        jPanelHead.setLayout(jPanelHeadLayout);
        jPanelHeadLayout.setHorizontalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 578, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelHeadLayout.setVerticalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelMenu.setBackground(new java.awt.Color(92, 107, 115));
        jPanelMenu.setForeground(new java.awt.Color(248, 248, 255));
        jPanelMenu.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanelMenu.setMinimumSize(new java.awt.Dimension(0, 570));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(200, 550));

        jButtonEffetti.setBackground(new java.awt.Color(58, 140, 200));
        jButtonEffetti.setForeground(new java.awt.Color(248, 248, 255));
        jButtonEffetti.setText("Selezione Effetti");
        jButtonEffetti.setBorder(null);
        jButtonEffetti.setBorderPainted(false);
        jButtonEffetti.setContentAreaFilled(false);
        jButtonEffetti.setFocusPainted(false);
        jButtonEffetti.setMaximumSize(new java.awt.Dimension(200, 40));
        jButtonEffetti.setMinimumSize(new java.awt.Dimension(200, 40));

        jButtonAppConfig.setBackground(new java.awt.Color(58, 140, 200));
        jButtonAppConfig.setForeground(new java.awt.Color(248, 248, 255));
        jButtonAppConfig.setText("Configurazione Applicazione");
        jButtonAppConfig.setBorder(null);
        jButtonAppConfig.setBorderPainted(false);
        jButtonAppConfig.setContentAreaFilled(false);
        jButtonAppConfig.setFocusPainted(false);
        jButtonAppConfig.setMaximumSize(new java.awt.Dimension(200, 40));
        jButtonAppConfig.setMinimumSize(new java.awt.Dimension(200, 40));

        jButtonWizard.setBackground(new java.awt.Color(58, 140, 200));
        jButtonWizard.setForeground(new java.awt.Color(248, 248, 255));
        jButtonWizard.setText("Wizard Accoppiamento");
        jButtonWizard.setBorder(null);
        jButtonWizard.setBorderPainted(false);
        jButtonWizard.setContentAreaFilled(false);
        jButtonWizard.setFocusPainted(false);
        jButtonWizard.setMaximumSize(new java.awt.Dimension(200, 40));
        jButtonWizard.setMinimumSize(new java.awt.Dimension(200, 40));

        jLabel1.setBackground(new java.awt.Color(248, 248, 255));
        jLabel1.setForeground(new java.awt.Color(248, 248, 255));
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 2));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 2));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 2));

        jButtonConfLight.setBackground(new java.awt.Color(58, 140, 200));
        jButtonConfLight.setForeground(new java.awt.Color(248, 248, 255));
        jButtonConfLight.setText("Configurazione Luci");
        jButtonConfLight.setBorder(null);
        jButtonConfLight.setBorderPainted(false);
        jButtonConfLight.setContentAreaFilled(false);
        jButtonConfLight.setFocusPainted(false);
        jButtonConfLight.setMaximumSize(new java.awt.Dimension(200, 40));
        jButtonConfLight.setMinimumSize(new java.awt.Dimension(200, 40));

        jButtonExit.setBackground(new java.awt.Color(58, 140, 200));
        jButtonExit.setForeground(new java.awt.Color(248, 248, 255));
        jButtonExit.setText("Uscita");
        jButtonExit.setBorder(null);
        jButtonExit.setBorderPainted(false);
        jButtonExit.setContentAreaFilled(false);
        jButtonExit.setFocusPainted(false);
        jButtonExit.setMaximumSize(new java.awt.Dimension(200, 40));
        jButtonExit.setMinimumSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonWizard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEffetti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButtonAppConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonConfLight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonEffetti, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfLight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAppConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonWizard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMain.setBackground(new java.awt.Color(37, 50, 55));
        jPanelMain.setForeground(new java.awt.Color(248, 248, 255));
        jPanelMain.setMinimumSize(new java.awt.Dimension(800, 570));
        jPanelMain.setPreferredSize(new java.awt.Dimension(800, 570));

        jPanelServer.setBackground(new java.awt.Color(144, 0, 0));
        jPanelServer.setForeground(new java.awt.Color(248, 248, 255));
        jPanelServer.setMinimumSize(new java.awt.Dimension(400, 20));
        jPanelServer.setPreferredSize(new java.awt.Dimension(400, 20));

        jLabelServer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(92, 107, 115), 2));

        javax.swing.GroupLayout jPanelServerLayout = new javax.swing.GroupLayout(jPanelServer);
        jPanelServer.setLayout(jPanelServerLayout);
        jPanelServerLayout.setHorizontalGroup(
            jPanelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelServer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelServerLayout.setVerticalGroup(
            jPanelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelServer, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        jPanelConnection.setBackground(new java.awt.Color(144, 0, 0));
        jPanelConnection.setForeground(new java.awt.Color(248, 248, 255));
        jPanelConnection.setMinimumSize(new java.awt.Dimension(400, 20));

        jLabelConnessione.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(92, 107, 115), 2));

        javax.swing.GroupLayout jPanelConnectionLayout = new javax.swing.GroupLayout(jPanelConnection);
        jPanelConnection.setLayout(jPanelConnectionLayout);
        jPanelConnectionLayout.setHorizontalGroup(
            jPanelConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelConnessione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelConnectionLayout.setVerticalGroup(
            jPanelConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConnectionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelConnessione, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane1.setLayer(jPanelHead, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelMenu, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(jPanelMain, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelServer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelConnection, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanelConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanelServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 550, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );

        jPanelMenu.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Variables declaration
    // <editor-fold defaultstate="collapsed" desc="Variables declaration">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAppConfig;
    private javax.swing.JButton jButtonConfLight;
    private javax.swing.JButton jButtonEffetti;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonWizard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelConnessione;
    private javax.swing.JLabel jLabelServer;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelConnection;
    private javax.swing.JPanel jPanelHead;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelServer;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
    
    public JButton getJButtonMenu() {
        return this.jButtonMenu;
    }
    
    public JButton getJButtonMain(){
        return this.jButtonEffetti;
    }
    
    public JPanel getJPanelMain(){
        return this.jPanelMain;
    }

    public JButton getjButtonAppConfig() {
        return this.jButtonAppConfig;
    }

    public JButton getjButtonConfLight() {
        return this.jButtonConfLight;
    }

    public JButton getjButtonEffetti() {
        return this.jButtonEffetti;
    }

    public JButton getjButtonExit() {
        return this.jButtonExit;
    }

    public JButton getjButtonMenu() {
        return this.jButtonMenu;
    }

    public JButton getjButtonWizard() {
        return this.jButtonWizard;
    }

    public JPanel getjPanelHead() {
        return this.jPanelHead;
    }

    public JPanel getjPanelMenu() {
        return this.jPanelMenu;
    }

    public JLabel getjLabelConnessione() {
        return this.jLabelConnessione;
    }

    public JLabel getjLabelServer() {
        return this.jLabelServer;
    }

    public JPanel getjPanelConnection() {
        return this.jPanelConnection;
    }

    public JPanel getjPanelServer() {
        return this.jPanelServer;
    }
    
    //Window listener Methods
    // <editor-fold defaultstate="collapsed" desc="Window Listener Methods">   
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        new ExitDialog(this, true, this.ac);
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    // </editor-fold>
    
    class menuHandler extends Thread{
        
        private final JPanel jPanelMenu;
        private final JButton jButtonMenu;
        private final boolean toClose;

        public menuHandler(JPanel jPanelMenu, JButton jButtonMenu, boolean toClose) {
            super("MenuHandler");
            this.jButtonMenu = jButtonMenu;
            this.jButtonMenu.setEnabled(false);
            this.jPanelMenu = jPanelMenu;
            this.toClose = toClose;
        }

        @Override
        public void run() {
            if(this.toClose){
                do{
                    try {
                        this.jPanelMenu.setPreferredSize(new Dimension(this.jPanelMenu.getWidth()-2, this.jPanelMenu.getHeight()));
                        this.jPanelMenu.revalidate();
                        this.jPanelMenu.repaint();
                        this.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }while(this.jPanelMenu.getWidth()>=0);
            }
            else{
                do{
                    try {
                        this.jPanelMenu.setPreferredSize(new Dimension(this.jPanelMenu.getWidth()+2, this.jPanelMenu.getHeight()));
                        this.jPanelMenu.revalidate();
                        this.jPanelMenu.repaint();
                        this.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }while(this.jPanelMenu.getWidth()<=200);
            
            }
        this.jPanelMenu.revalidate();
        this.jPanelMenu.repaint();
        this.jButtonMenu.setEnabled(true);
        }
    
    }
    
}
