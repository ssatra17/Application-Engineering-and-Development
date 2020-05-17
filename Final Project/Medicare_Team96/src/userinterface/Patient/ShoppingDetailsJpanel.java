/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Patient;

import Business.DB4O.DB4O;
import Business.EcoSystem;
import Business.Enterprise.HospitalType;
import Business.Enterprise.HospitalType.departmenttype;
import Business.Enterprise.Product;
import Business.Hospital.Doctor.Appointments;
import Business.Hospital.Doctor.Doctor;
import Business.Hospital.Lab.Lab;
import Business.Hospital.Lab.Test;
import Business.Hospital.Pharmacy.Medicines;
import Business.Hospital.Pharmacy.Pharmacy;
import Business.Hospital.SocialEvents.Events;
import Business.Hospital.SocialEvents.SocialEvents;
import Business.Network.Network;
import Business.Patient.AppointmentOrder;
import Business.Patient.EventOrder;
import Business.Patient.MedicineOrder;
import Business.Patient.ProductOrder;
import Business.Patient.TestOrder;
import Business.UserAccount.PatientAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



 
/**
 *
 * @author DAVE
 */
public class ShoppingDetailsJpanel extends javax.swing.JPanel {

     private EcoSystem system;
    private HospitalType Dept;
    private PatientAccount account;
    private Network net;
    private departmenttype departmenttype;
    /**
     * Creates new form ShoppingDetailsJpanel
     */
    public ShoppingDetailsJpanel(EcoSystem system, HospitalType Dept, PatientAccount account, Network net, departmenttype departmenttype) {
        initComponents();
        this.system = system;
        this.Dept = Dept;
        this.account = account;
        this.net = net;
        this.departmenttype = departmenttype;

        if (!departmenttype.equals(departmenttype.Doctor)) {
            this.jTabbedPane1.setTitleAt(1, "Product");
        }

        populateTable();

    
        addressTextArea.setText(Dept.getAddress());
        addressTextArea.setEnabled(false);
        descriptionTextArea.setText(Dept.getDescription());
        descriptionTextArea.setEnabled(false);
        phoneLabel.setText(Dept.getPhone());

    }

    private void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) menuTable.getModel();
        dtm.setRowCount(0);
        if (departmenttype.equals(departmenttype.Lab)) {
            Lab lab = (Lab) Dept;
            if (lab.getType() != null) {
                categoryLabel.setText(lab.getType().name());
            }
            
            for (Test test : lab.getGoods()) {
                Object row[] = new Object[2];
                row[0] = test;
                row[1] = test.getPrice();
                dtm.addRow(row);
            }
        }
        if (departmenttype.equals(departmenttype.Pharmacy)) {
            Pharmacy medicines = (Pharmacy) Dept;
            if (medicines.getType() != null) {
                categoryLabel.setText(medicines.getType().name());
            }
           for (Medicines p : medicines.getGoods()) {
                Object row[] = new Object[2];
                row[0] = p;
                row[1] = p.getPrice();
                dtm.addRow(row);
//            }
        }
    }
        if (departmenttype.equals(departmenttype.Doctor)) {
            Doctor doc = (Doctor) Dept;
            if (doc.getType() != null) {
                categoryLabel.setText(doc.getType().name());
            }
            
            for (Appointments app : doc.getGoods()) {
                Object row[] = new Object[2];
                row[0] = app;
                row[1] = app.getPrice();
                dtm.addRow(row);
            }
        }
        if (departmenttype.equals(departmenttype.Events)) {
            SocialEvents doc = (SocialEvents) Dept;
            if (doc.getType() != null) {
                categoryLabel.setText(doc.getType().name());
            }
            
            for (Events app : doc.getGoods()) {
                Object row[] = new Object[2];
                row[0] = app;
                row[1] = app.getPrice();
                dtm.addRow(row);
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 153));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Phone:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Category: ");

        categoryLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        categoryLabel.setText("N/A");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Description: ");

        addressTextArea.setBackground(new java.awt.Color(238, 238, 238));
        addressTextArea.setColumns(20);
        addressTextArea.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        addressTextArea.setLineWrap(true);
        addressTextArea.setBorder(null);
        addressTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(addressTextArea);

        descriptionTextArea.setBackground(new java.awt.Color(238, 238, 238));
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        descriptionTextArea.setForeground(new java.awt.Color(238, 238, 238));
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setBorder(null);
        descriptionTextArea.setCaretColor(new java.awt.Color(238, 238, 238));
        descriptionTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(descriptionTextArea);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Address: ");

        phoneLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        phoneLabel.setText("<Phone>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 70, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneLabel)
                        .addGap(40, 40, 40)))
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(categoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Details", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(menuTable);

        addButton.setText("Add to Cart");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addButton)
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Catalog", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int selectedRow = menuTable.getSelectedRow();

        if (selectedRow >= 0) {
            Product item = (Product) menuTable.getValueAt(selectedRow, 0);
            int quantity = (int) quantitySpinner.getValue();

            ProductOrder line = null;
            if (this.departmenttype.equals(departmenttype.Pharmacy)) {
                line = new MedicineOrder(Dept, item, quantity);
            }
            if (this.departmenttype.equals(departmenttype.Lab)) {
                line = new TestOrder(Dept, item, quantity);
            }
            if (this.departmenttype.equals(departmenttype.Doctor)) {
                line = new AppointmentOrder(Dept, item, quantity);
            }
            if (this.departmenttype.equals(departmenttype.Events)) {
                line = new EventOrder(Dept, item, quantity);
            }

            if (!this.account.getCart().isCartEmpty()) {
                for (ProductOrder or : this.account.getCart().getProductList()) {
                    if (!or.getdepartmentModel().equals(this.Dept)) {
                        int choice = JOptionPane.showConfirmDialog(null, "You alreay have added products from other shop in shopping cart. \n"
                            + "Adding this product will remove all previous products in the shopping cart.\n" + "Do you want to continue?",
                            "Shop Conflicts", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            this.account.getCart().clearCart();
                            break;
                        } else {
                            return;
                        }
                    }
                    if (or.getdepartmentModel().equals(this.Dept) && or.getProduct().equals(item)) {
                        line.setQuantity(or.getQuantity() + quantity);
                        this.account.getCart().getProductList().remove(or);
                        break;
                    }
                }
            }
            this.account.getCart().addToCart(line);

            JOptionPane.showMessageDialog(null, "Product has been successfully added to Shopping Cart");
            DB4O.getInstance().storeSystem(system);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Product.");
        }

    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable menuTable;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JSpinner quantitySpinner;
    // End of variables declaration//GEN-END:variables
}
