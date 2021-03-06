/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
 
import Business.VitalSignHistory;
import Business.VitalSigns;
import javax.swing.JOptionPane;
/**
 *
 * @author saura
 */
public class CreateVitalJpanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVitalJpanel
     */
    private VitalSignHistory vsh;
    public CreateVitalJpanel(VitalSignHistory vsh) {
        initComponents();
        this.vsh= vsh;
        
       //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tempJlabel = new javax.swing.JLabel();
        bpJlabel = new javax.swing.JLabel();
        pulseJlabel = new javax.swing.JLabel();
        dateJlabel = new javax.swing.JLabel();
        tempText = new javax.swing.JTextField();
        bpText = new javax.swing.JTextField();
        pulseText = new javax.swing.JTextField();
        dateText = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        jLabel1.setText("Create Your Vital Signs");

        tempJlabel.setText("Temperature");

        bpJlabel.setText("Blood Pressure");

        pulseJlabel.setText("Pulse");

        dateJlabel.setText("Date");

        tempText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempTextActionPerformed(evt);
            }
        });

        bpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpTextActionPerformed(evt);
            }
        });

        pulseText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulseTextActionPerformed(evt);
            }
        });

        dateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateJlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pulseJlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pulseText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bpJlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bpText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tempJlabel)
                                .addGap(131, 131, 131)
                                .addComponent(tempText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(saveButton)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempJlabel)
                    .addComponent(tempText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bpJlabel)
                    .addComponent(bpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pulseJlabel)
                    .addComponent(pulseText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateJlabel)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(saveButton)
                .addContainerGap(186, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tempTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempTextActionPerformed

    private void bpTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bpTextActionPerformed

    private void pulseTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulseTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pulseTextActionPerformed

    private void dateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTextActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        double temperature = Double.parseDouble(tempText.getText());
        double bp = Double.parseDouble(bpText.getText());
        int pulse = Integer.parseInt(pulseText.getText());
        String date = dateText.getText();
        VitalSigns v = vsh.addVitals();
        v.setTemperature(temperature);
        v.setBloodPressure(bp);
        v.setDate(date);
        v.setPulse(pulse);
        JOptionPane.showMessageDialog(null,"VitalSigns added successfully");
        
        tempText.setText("");
        bpText.setText("");
        pulseText.setText("");
        dateText.setText("");
          
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bpJlabel;
    private javax.swing.JTextField bpText;
    private javax.swing.JLabel dateJlabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pulseJlabel;
    private javax.swing.JTextField pulseText;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel tempJlabel;
    private javax.swing.JTextField tempText;
    // End of variables declaration//GEN-END:variables
}
