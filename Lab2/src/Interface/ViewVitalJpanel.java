/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.VitalSignHistory;
import Business.VitalSigns;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saura
 */
public class ViewVitalJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewVitalJpanel
     */
    private VitalSignHistory vsh;
    public ViewVitalJpanel(VitalSignHistory vsh) {
        initComponents();
        this.vsh = vsh;
        populateTable();
        
    }
public void populateTable()
{
    DefaultTableModel dtm = (DefaultTableModel)tableVs.getModel();
    dtm.setRowCount(0);
    
    for(VitalSigns vs : vsh.getVitalSignHistory())
    {
        Object row[] = new Object[2];
        row[0] = vs;
        row[1] = vs.getBloodPressure();
        dtm.addRow(row);
    }
}
 
private void setFieldEnabled(boolean b){
    tempText.setEnabled(b);
    bpText.setEnabled(b);
    pulseText.setEnabled(b);
    dateText.setEnabled(b);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVs = new javax.swing.JTable();
        detailsButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();

        jLabel1.setText("View Your Vital Signs");

        tempJlabel.setText("Temperature");

        bpJlabel.setText("Blood Pressure");

        pulseJlabel.setText("Pulse");

        dateJlabel.setText("Date");

        tempText.setEnabled(false);
        tempText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempTextActionPerformed(evt);
            }
        });

        bpText.setEnabled(false);
        bpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpTextActionPerformed(evt);
            }
        });

        pulseText.setEnabled(false);
        pulseText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulseTextActionPerformed(evt);
            }
        });

        dateText.setEnabled(false);
        dateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextActionPerformed(evt);
            }
        });

        tableVs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Blood Pressure"
            }
        ));
        jScrollPane1.setViewportView(tableVs);

        detailsButton.setText("View Details");
        detailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confirmButton)
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(tempJlabel)
                                    .addGap(131, 131, 131)
                                    .addComponent(tempText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(detailsButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(updateButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(deleteButton))))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailsButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(confirmButton))
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

    private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
        int selectedRow = tableVs.getSelectedRow();

        if(selectedRow >=0)
        {
            VitalSigns vs = (VitalSigns)tableVs.getValueAt(selectedRow, 0);
            bpText.setText(String.valueOf(vs.getBloodPressure()));
            tempText.setText(String.valueOf(vs.getTemperature()));
            pulseText.setText(String.valueOf(vs.getPulse()));
            dateText.setText(String.valueOf(vs.getDate()));
        }
        else 
            JOptionPane.showMessageDialog(null,"Please select a row.");
    
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = tableVs.getSelectedRow();

        if(selectedRow >=0)
        {
          VitalSigns vs = (VitalSigns)tableVs.getValueAt(selectedRow, 0);
          vsh.deleteVitals(vs);
          JOptionPane.showMessageDialog(null,  "VitalSign has been deleted.");
          populateTable();
        }
        else 
            JOptionPane.showMessageDialog(null,"Please select a row.");// TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        setFieldEnabled(true);
        confirmButton.setEnabled(true);
        
        int selectRow = tableVs.getSelectedRow();
        
        if(selectRow>=0)
        {
            VitalSigns vs = (VitalSigns) tableVs.getValueAt(selectRow, 0);
            tempText.setText(vs.getTemperature()+"");
            bpText.setText(vs.getBloodPressure()+"");
            pulseText.setText(vs.getPulse()+"");
            dateText.setText(vs.getDate()+"");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        confirmButton.setEnabled(true);
        int selectRow = tableVs.getSelectedRow();
        
        if(selectRow>=0)
        {
            VitalSigns vs = (VitalSigns) tableVs.getValueAt(selectRow, 0);
            vs.setTemperature(Double.parseDouble(tempText.getText()));
            vs.setBloodPressure(Double.parseDouble(bpText.getText()));
            vs.setDate(dateText.getText());
            vs.setPulse(Integer.parseInt(pulseText.getText()));
            
            JOptionPane.showMessageDialog(null, "VitalSign Updated Successfully");
            populateTable();
            setFieldEnabled(false);
            confirmButton.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row");
        }
        
    }//GEN-LAST:event_confirmButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bpJlabel;
    private javax.swing.JTextField bpText;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel dateJlabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton detailsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pulseJlabel;
    private javax.swing.JTextField pulseText;
    private javax.swing.JTable tableVs;
    private javax.swing.JLabel tempJlabel;
    private javax.swing.JTextField tempText;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}