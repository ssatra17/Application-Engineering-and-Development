/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Airlines;

import Business.Airlines;
import Business.AirlineDirectory;
import Business.FlightDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author DAVE
 */
public class AirlineBooking extends javax.swing.JPanel {

     private JPanel bottomPanel;
    private AirlineDirectory airlinesDict;
    private FlightDirectory FlightDir;
    private Airlines airlines;
    public AirlineBooking(JPanel bottomPanel, AirlineDirectory airlinesDict, FlightDirectory FlightDir,Airlines airlines) {
        initComponents();
        this.bottomPanel= bottomPanel;
        this.airlinesDict = airlinesDict;
        this.FlightDir=FlightDir;
        this.airlines = airlines;
        AirlinesNames.removeAllItems();
        for(Airlines airline : airlinesDict.getAirlinedirectory()) {
           AirlinesNames.addItem(airline);
       }
         }

    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AirlinesNames = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(102, 153, 255));

        GoButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        GoButton.setText("Go");
        GoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Airlines Login ");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Airlines Name : ");

        AirlinesNames.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AirlinesNames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(GoButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(AirlinesNames, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel2)))
                .addContainerGap(407, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AirlinesNames, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(GoButton)
                .addContainerGap(319, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoButtonActionPerformed

        Airlines airl = (Airlines)AirlinesNames.getSelectedItem();
        ManageAirlinesCatalog mac = new ManageAirlinesCatalog(bottomPanel,airl, airlines,FlightDir);
        bottomPanel.add("ManageAirlinesCatalog",mac);
        CardLayout layout = (CardLayout)bottomPanel.getLayout();
        layout.next(bottomPanel);
    }//GEN-LAST:event_GoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AirlinesNames;
    private javax.swing.JButton GoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
