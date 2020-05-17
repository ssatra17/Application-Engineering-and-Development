/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Airlines;


import Business.AirlineDirectory;
import Business.Airlines;
import Business.Customer;
import javax.swing.JPanel;
import Business.Flight;
import Business.FlightDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DAVE
 */
public class ManageAirlinesCatalog extends javax.swing.JPanel {

    private JPanel bottomPanel;
private Airlines airlines;
private FlightDirectory FlightDir;
private Airlines airl;
      
    public ManageAirlinesCatalog(JPanel bottomPanel, Airlines airl,Airlines airlines, FlightDirectory FlightDir) {
        initComponents();
        this.bottomPanel = bottomPanel;
        this.airlines=airlines;
        this.FlightDir = FlightDir;
        this.airl =airl;
        AirlinenameTextField.setText(airl.getAirplaneName());
        populate1();
    }

        
    public void populate1(){
        int rowCount = FlightsJTable.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)FlightsJTable.getModel();
     dtm.setRowCount(0);
        for(Flight f : airlines.getFlightDirectory().getFlightDir()){
            if(f.getCompany().equalsIgnoreCase(AirlinenameTextField.getText())){
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]=f;
            row[1]=f.getFlightNum();
            row[2]=f.getSource();
            row[3]=f.getDest();
            
            row[4]=f.getPrice(); 
            row[5]=f.getdate();
            row[6]=f.getTime();
            row[7]=f.getAdate();
            row[8]=f.getAtime();
            dtm.addRow(row);
        
    }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        AirlinenameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ViewJButton = new javax.swing.JButton();
        CreateJButton = new javax.swing.JButton();
        BackJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FlightsJTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 153, 240));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Airlines :");

        AirlinenameTextField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Manage Airlines Catalog");

        ViewJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ViewJButton.setText("View");
        ViewJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewJButtonActionPerformed(evt);
            }
        });

        CreateJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CreateJButton.setText("Create");
        CreateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateJButtonActionPerformed(evt);
            }
        });

        BackJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BackJButton.setText("Back");
        BackJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackJButtonActionPerformed(evt);
            }
        });

        FlightsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Company", "Flight Number", "Departure", "Arrival", "Price", "Departure Date", "Departure Time", "Arrival Date", "Arrival Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(FlightsJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateJButton)
                        .addGap(52, 52, 52)
                        .addComponent(ViewJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackJButton)
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AirlinenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addContainerGap(505, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BackJButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AirlinenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewJButton)
                    .addComponent(CreateJButton))
                .addContainerGap(108, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ViewJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewJButtonActionPerformed
        // TODO add your handling code here:
        int row = FlightsJTable.getSelectedRow();
        if(row>=0) {
            Flight f = (Flight)FlightsJTable.getValueAt(row, 0);
            ViewSchedules vs = new ViewSchedules(bottomPanel,f);
            bottomPanel.add("View Schedules", vs);
            CardLayout layout = (CardLayout)bottomPanel.getLayout();
            layout.next(bottomPanel);

        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row from the table first");
        }

    }//GEN-LAST:event_ViewJButtonActionPerformed

    private void CreateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateJButtonActionPerformed
        // TODO add your handling code here:


        CreateSchedule cs = new CreateSchedule(bottomPanel, airlines, FlightDir,airl);
        bottomPanel.add("CreateSchedule",cs);
        CardLayout layout = (CardLayout)bottomPanel.getLayout();
        layout.next(bottomPanel);
    }//GEN-LAST:event_CreateJButtonActionPerformed

    private void BackJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackJButtonActionPerformed
        // TODO add your handling code here:
        bottomPanel.remove(this);
        CardLayout layout = (CardLayout)bottomPanel.getLayout();
        layout.previous(bottomPanel);
    }//GEN-LAST:event_BackJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AirlinenameTextField;
    private javax.swing.JButton BackJButton;
    private javax.swing.JButton CreateJButton;
    private javax.swing.JTable FlightsJTable;
    private javax.swing.JButton ViewJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
