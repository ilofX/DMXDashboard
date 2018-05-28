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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Stella Filippo
 * @version 1.0
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        this.initComponents();
        this.initializeMenu();
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
    }
    
    public final void handleMenu(boolean toClose){
        new menuHandler(this.jPanelMenu, this.jButtonMenu, toClose).start();
    }
    
    public final boolean isMenuOpen(){
        return this.jPanelMenu.getWidth()>=200;
    }

    public final void addLayer(Component component,Integer Layer){
        this.jLayeredPane1.setLayer(component, Layer);
        this.jLayeredPane1.revalidate();
        this.jLayeredPane1.repaint();
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
        jPanelMenu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DMXDashboard");
        setBackground(new java.awt.Color(21, 21, 21));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jLayeredPane1.setBackground(new java.awt.Color(21, 21, 21));
        jLayeredPane1.setForeground(new java.awt.Color(248, 248, 255));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(800, 600));
        jLayeredPane1.setOpaque(true);

        jPanelHead.setBackground(new java.awt.Color(58, 140, 200));
        jPanelHead.setMinimumSize(new java.awt.Dimension(800, 30));

        jButtonMenu.setBackground(new java.awt.Color(58, 140, 200));
        jButtonMenu.setForeground(new java.awt.Color(248, 248, 255));
        jButtonMenu.setText("Menu");
        jButtonMenu.setBorder(null);
        jButtonMenu.setBorderPainted(false);
        jButtonMenu.setFocusPainted(false);

        javax.swing.GroupLayout jPanelHeadLayout = new javax.swing.GroupLayout(jPanelHead);
        jPanelHead.setLayout(jPanelHeadLayout);
        jPanelHeadLayout.setHorizontalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeadLayout.setVerticalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanelMenu.setBackground(new java.awt.Color(58, 140, 200));
        jPanelMenu.setForeground(new java.awt.Color(248, 248, 255));
        jPanelMenu.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanelMenu.setMinimumSize(new java.awt.Dimension(0, 570));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(200, 570));

        jButton1.setBackground(new java.awt.Color(58, 140, 200));
        jButton1.setForeground(new java.awt.Color(248, 248, 255));
        jButton1.setText("Main");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
        );

        jPanelMain.setBackground(new java.awt.Color(21, 21, 21));
        jPanelMain.setForeground(new java.awt.Color(248, 248, 255));
        jPanelMain.setMinimumSize(new java.awt.Dimension(800, 570));
        jPanelMain.setPreferredSize(new java.awt.Dimension(800, 570));

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(jPanelHead, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelMenu, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(jPanelMain, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 600, Short.MAX_VALUE))
            .addComponent(jPanelHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanelMenu.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelHead;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMenu;
    // End of variables declaration//GEN-END:variables

    public JButton getJButtonMenu() {
        return this.jButtonMenu;
    }
    
    
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
                        this.sleep(5);
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
                        this.sleep(5);
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
