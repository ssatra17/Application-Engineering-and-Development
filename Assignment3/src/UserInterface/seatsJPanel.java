/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Car;
import Business.CarInformation;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saura
 */
public class seatsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form seatsJPanel
     */
   private CarInformation carInfo;
   private JPanel rightPanel;
   private int count;
   double defaultMax =6;
   double defaultMin =1;

    seatsJPanel(CarInformation carInfo, JPanel rightPanel) {
        initComponents();
        this.carInfo=carInfo;
        this.rightPanel=rightPanel;
        populate(carInfo);
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void populate(CarInformation carInfo){
        DefaultTableModel dtm = (DefaultTableModel)tblCar.getModel();
        dtm.setRowCount(0);
        
        for(Car a : carInfo.getCarDirectory()){
            
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]=a.getBrand();
            row[1]=a.getSerial_num();
            row[2]=a.getModel_num();
            row[3]=a.getManufactured_year();
            row[4]=a.getAvailble_city();
            row[5]=a.getMin_seats();
            row[6]=a.getMax_seats();
            row[7]=a.isAvailable();
            row[8]=a.getManufacturer();
            row[9]=a.isMaintenance_certificate();
            dtm.addRow(row);
        }
        count= tblCar.getRowCount();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        maxTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        minTxt = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 255));

        tblCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Brand", "Serial Number", "Model Number", "Man. Year", "City", "Min Seats", "Max Seats", "Availibility", "Manufacturer", "Maintainance Certificate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCar);

        jLabel1.setText("Maximum Seats:");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Minimum Seats:");

        minTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minTxtActionPerformed(evt);
            }
        });

        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search Based On Seats");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(maxTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(47, 47, 47)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(93, 93, 93))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(169, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm =(DefaultTableModel)tblCar.getModel();
        dtm.setRowCount(0);
        int c = 0;
        int mini= Integer.parseInt(minTxt.getText());
        int maxi=Integer.parseInt(maxTxt.getText());
        
        try{
            Integer.parseInt(minTxt.getText());
        } catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Please enter a number for Serial Number");
        return;
        }
        
        try{
            Integer.parseInt(maxTxt.getText());
        } catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Please enter a number for Serial Number");
        return;
        }
        
        for(int i=0;i<count;i++)
        {
            int seat1=carInfo.getCarDirectory().get(i).getMin_seats();
            int seat2=carInfo.getCarDirectory().get(i).getMax_seats();
            if((seat1 >= mini)&&(seat2 <= maxi))
            {
                Car a = carInfo.addCar();
               if(a.isAvailable()== true){       
                Object[] row = new Object[dtm.getColumnCount()];
                row[0]=carInfo.getCarDirectory().get(i).getBrand();
                row[1]=carInfo.getCarDirectory().get(i).getSerial_num();
                row[2]=carInfo.getCarDirectory().get(i).getModel_num();
                row[3]=carInfo.getCarDirectory().get(i).getManufactured_year();
                row[4]=carInfo.getCarDirectory().get(i).getAvailble_city();
                row[5]=carInfo.getCarDirectory().get(i).getMin_seats();
                row[6]=carInfo.getCarDirectory().get(i).getMax_seats();
                row[7]=carInfo.getCarDirectory().get(i).isAvailable();
                row[8]=carInfo.getCarDirectory().get(i).getManufacturer();
                row[9]=carInfo.getCarDirectory().get(i).isMaintenance_certificate();
                dtm.addRow(row);
                c= c+i;
               }
            }
            
        }
        if(c==0){
        JOptionPane.showMessageDialog(null, "No Car found with entered Brand");
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void minTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minTxtActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        rightPanel.remove(this);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.previous(rightPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maxTxt;
    private javax.swing.JTextField minTxt;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable tblCar;
    // End of variables declaration//GEN-END:variables
}