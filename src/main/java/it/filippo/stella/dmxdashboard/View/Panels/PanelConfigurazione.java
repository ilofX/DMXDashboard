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
package it.filippo.stella.dmxdashboard.View.Panels;

import it.filippo.stella.dmxdashboard.View.Dialogs.DevicesDialog;
import it.filippo.stella.dmxdashboard.View.MainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import org.apache.commons.validator.routines.InetAddressValidator;

/**
 *
 * @author Filippo
 * @version 1.0
 */
public class PanelConfigurazione extends javax.swing.JPanel implements MouseListener,ActionListener,FocusListener {
    
    private Color c;
    //private final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    //private final Pattern p = Pattern.compile( "^(?:" + this._255 + "\\.){3}" + this._255 + "$");
    private final InetAddressValidator IPValidator;
    private final DevicesDialog dd;
    private final MainFrame mf;

    
    public PanelConfigurazione(MainFrame mf, DevicesDialog dd) {
        this.initComponents();
        this.dd = dd;
        this.mf = mf;
        this.IPValidator = new InetAddressValidator();
        this.jTextFieldFile.addMouseListener(this);
        this.jButtonDispositivi.addActionListener(this);
        this.jTextFieldIP.addFocusListener(this);
    }

    private void changeConfiguration(){
        this.jFileChooser1.showSaveDialog(this);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerPortaScheda = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFile = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerPorta = new javax.swing.JSpinner();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButtonDispositivi = new javax.swing.JButton();
        jTextFieldIP = new javax.swing.JTextField();

        setBackground(new java.awt.Color(37, 50, 55));
        setForeground(new java.awt.Color(248, 248, 255));
        setMinimumSize(new java.awt.Dimension(800, 570));
        setPreferredSize(new java.awt.Dimension(800, 570));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 248, 255));
        jLabel1.setText("Indirizzo IP");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 248, 255));
        jLabel2.setText("Porta ModbusTCP");

        jSpinnerPortaScheda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jSpinnerPortaScheda.setModel(new javax.swing.SpinnerNumberModel(502, 1, 65535, 1));
        jSpinnerPortaScheda.setBorder(null);
        jSpinnerPortaScheda.setPreferredSize(new java.awt.Dimension(150, 25));

        jSeparator1.setBackground(new java.awt.Color(92, 107, 99));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 248, 255));
        jLabel3.setText("File di configurazione");
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 17));

        jTextFieldFile.setEditable(false);
        jTextFieldFile.setBackground(new java.awt.Color(248, 248, 255));
        jTextFieldFile.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jTextFieldFile.setForeground(new java.awt.Color(21, 21, 21));
        jTextFieldFile.setBorder(null);

        jSeparator2.setBackground(new java.awt.Color(92, 107, 99));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(248, 248, 255));
        jLabel4.setText("Porta Remote");

        jSpinnerPorta.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jSpinnerPorta.setModel(new javax.swing.SpinnerNumberModel(1, 1, 65535, 1));
        jSpinnerPorta.setBorder(null);

        jCheckBox1.setBackground(new java.awt.Color(37, 50, 55));
        jCheckBox1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(248, 248, 255));
        jCheckBox1.setText("Utilizza connessione sicura (SSL/TLS)");
        jCheckBox1.setBorder(null);

        jCheckBox2.setBackground(new java.awt.Color(37, 50, 55));
        jCheckBox2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(248, 248, 255));
        jCheckBox2.setText("Utilizza connessione sicura (SSL/TLS)");
        jCheckBox2.setBorder(null);

        jCheckBox3.setBackground(new java.awt.Color(37, 50, 55));
        jCheckBox3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(248, 248, 255));
        jCheckBox3.setText("Connetti automaticamente all'apertura del programma");
        jCheckBox3.setBorder(null);

        jCheckBox4.setBackground(new java.awt.Color(37, 50, 55));
        jCheckBox4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(248, 248, 255));
        jCheckBox4.setText("Avvia automaticamente all'apertura del programma");
        jCheckBox4.setBorder(null);

        jButtonDispositivi.setBackground(new java.awt.Color(37, 50, 55));
        jButtonDispositivi.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jButtonDispositivi.setForeground(new java.awt.Color(248, 248, 255));
        jButtonDispositivi.setText("Gestisci dispositivi accoppiati");
        jButtonDispositivi.setBorder(null);

        jTextFieldIP.setBackground(new java.awt.Color(248, 248, 255));
        jTextFieldIP.setForeground(new java.awt.Color(21, 21, 21));
        jTextFieldIP.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinnerPortaScheda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldFile, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonDispositivi, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerPortaScheda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox4)
                .addGap(18, 18, 18)
                .addComponent(jButtonDispositivi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Variables declaration"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDispositivi;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinnerPorta;
    private javax.swing.JSpinner jSpinnerPortaScheda;
    private javax.swing.JTextField jTextFieldFile;
    private javax.swing.JTextField jTextFieldIP;
    // End of variables declaration//GEN-END:variables
    // </editor-fold> 
    
    public JButton getjButtonDispositivi() {
        return this.jButtonDispositivi;
    }

    public JCheckBox getjCheckBox1() {
        return this.jCheckBox1;
    }

    public JCheckBox getjCheckBox2() {
        return this.jCheckBox2;
    }

    public JCheckBox getjCheckBox3() {
        return this.jCheckBox3;
    }

    public JCheckBox getjCheckBox4() {
        return this.jCheckBox4;
    }

    public JSpinner getjSpinnerPorta() {
        return this.jSpinnerPorta;
    }

    public JTextField getjTextFieldFile() {
        return this.jTextFieldFile;
    }
        
    public InetAddress getIPAddress() throws UnknownHostException {
        return InetAddress.getByName(this.jTextFieldIP.getText().trim());
    }
    
    public Integer getPort(){
        return (Integer) this.jSpinnerPortaScheda.getValue();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Mouse Listener">   
    //Implementation of mouse listener for JColorChooser
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==this.jTextFieldFile){
            this.changeConfiguration();
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
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Action Listener">
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jButtonDispositivi){
            this.dd.setLocationRelativeTo(this.mf);
            this.dd.setVisible(true);
        }
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Focus Listener">
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==this.jTextFieldIP && this.jTextFieldIP.getText().equals("INDIRIZZO IP NON VALIDO")){
            this.jTextFieldIP.setForeground(new Color(21, 21, 21));
            this.jTextFieldIP.setText("");
            this.jTextFieldIP.requestFocus();
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource()==this.jTextFieldIP && !this.jTextFieldIP.getText().equals("")){
            if(!this.IPValidator.isValidInet4Address(this.jTextFieldIP.getText().trim())){
                this.jTextFieldIP.setForeground(Color.RED);
                this.jTextFieldIP.setText("INDIRIZZO IP NON VALIDO");
            }
        }
    }
    // </editor-fold>

}
