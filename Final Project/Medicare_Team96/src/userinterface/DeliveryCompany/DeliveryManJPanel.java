/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DeliveryCompany;

import Business.DB4O.DB4O;
import Business.Enterprise.Enterprise;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Delivery.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalType;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.EmployeeAccount;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DeliveryRequest;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequest.StatusEnum;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author parth
 */
public class DeliveryManJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryManJPanel
     */
    private EcoSystem system;
    private JPanel container;
    private Network net;
    private Enterprise en;
    private EmployeeAccount employeeAccount;
    private DeliveryCompany company;
    private JFrame frame;
    private Role accessRole;
    private String path;
    private String originPath;
    private DeliveryRequest selectedRequest = null;
    private Employee employee;
    private Organization organization;
    
    public DeliveryManJPanel(EcoSystem system, JPanel container, UserAccount userAccount, Enterprise en, Organization organization) {
        initComponents();
        this.system = system;
        this.container=container;
        //this.net=net;
        this.en=en;
        this.organization=organization;
        this.employeeAccount = (EmployeeAccount) userAccount;
        this.employee = this.employeeAccount.getEmployee();
        this.company=(DeliveryCompany) en;
        
        
        
        //profile
        setInfo();
        btnProfileEdit.setEnabled(true);
        btnProfileSave.setEnabled(false);
        btnProfileCancel.setEnabled(false);
        setFieldsEditable(false);
        
        // Task Tab
        btnInitailize.setEnabled(false);
        btnPickedUp.setEnabled(false);
        btnDelivered.setEnabled(false);
        populateOrderTable(getAllDeliveryRequest());
        txtUsername.setEnabled(false);
        txtRole.setEnabled(false);
        txtoldPword.setText("");
        txtNewPword.setText("");
        txtConfirmPWord.setText("");
        

    }
    
    private void setInfo(){
       nameLabel1.setText(employee.getFirstName()+ "  " + employee.getLastName());
        txtFirstName.setText(employee.getFirstName());
        txtLastName.setText(employee.getLastName());
        txtProfilePhone.setText(employee.getContactNum());
        txtEmail.setText(employee.getEmailID());
        txtUsername.setText(employeeAccount.getUserName());
        txtRole.setText(this.employeeAccount.getRole().getRoleType().getValue());
    }   
    private ArrayList<WorkRequest> getAllDeliveryRequest() {
        ArrayList<WorkRequest> list = new ArrayList<>();
        list.addAll(this.en.getWorkQueue().getWorkRequestList());
        list.addAll(this.employeeAccount.getWork().getWorkRequestList());
        return list;
    }

    private void populateOrderTable(ArrayList<WorkRequest> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblOrder.getModel();
        dtm.setRowCount(0);
        for (WorkRequest wr : list) {
            DeliveryRequest dr = (DeliveryRequest) wr;
            Object row[] = new Object[4];
            row[0] = dr.getOrder().getId();
            row[1] = dr;
            row[2]= (HospitalType) dr.getOrder().getEnterprise();
            row[3] = dr.getStatus();
            dtm.addRow(row);
        }
    }
     private void populateDetails() {
        HospitalType d = (HospitalType) selectedRequest.getOrder().getEnterprise();
        txtPickupAddress.setText(d.getAddress());
        txtPickupName.setText(d.getName());
        txtPickupPhone.setText(d.getPhone());
        OrderRequest or = (OrderRequest) selectedRequest.getOrder();
        txtDeliveryAddress.setText(or.getDeliveryAddress());
        txtDeliveryName.setText(or.getDeliveryName());
        txtDeliveryPhone.setText(or.getDeliveryPhone());
    }
     private void resetPasswordField() {
        txtoldPword.setText("");
        txtNewPword.setText("");
        txtConfirmPWord.setText("");
    }

    private void setFieldsEditable(boolean b) {
        txtEmail.setEnabled(b);
        txtFirstName.setEnabled(b);
        txtLastName.setEnabled(b);
        txtProfilePhone.setEnabled(b);
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnProfileCancel = new javax.swing.JButton();
        btnProfileSave = new javax.swing.JButton();
        btnProfileEdit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProfilePhone = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        passwordPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnPWordSave = new javax.swing.JButton();
        btnPwordCancel = new javax.swing.JButton();
        txtConfirmPWord = new javax.swing.JPasswordField();
        txtNewPword = new javax.swing.JPasswordField();
        txtoldPword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPickupName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPickupPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtPickupAddress = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtDeliveryName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDeliveryPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDeliveryAddress = new javax.swing.JTextArea();
        btnInitailize = new javax.swing.JButton();
        btnPickedUp = new javax.swing.JButton();
        btnDelivered = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel6.setText("Welcome, ");

        nameLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        nameLabel1.setText("<Name>");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        btnProfileCancel.setText("Cancel");
        btnProfileCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileCancelActionPerformed(evt);
            }
        });

        btnProfileSave.setText("Save");
        btnProfileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileSaveActionPerformed(evt);
            }
        });

        btnProfileEdit.setText("Edit");
        btnProfileEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileEditActionPerformed(evt);
            }
        });

        jLabel14.setText("Role:");

        jLabel13.setText("Username:");

        jLabel12.setText("Email:");

        jLabel11.setText("Phone:");

        jLabel15.setText("Last Name:");

        jLabel1.setText("First Name:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(80, 80, 80)
                        .addComponent(txtFirstName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProfilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(123, 123, 123))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnProfileEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnProfileSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProfileCancel))
                            .addComponent(txtEmail)
                            .addComponent(txtUsername)
                            .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(647, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtProfilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProfileEdit)
                    .addComponent(btnProfileSave)
                    .addComponent(btnProfileCancel))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("My Profile", jPanel2);

        passwordPanel.setBackground(new java.awt.Color(204, 204, 255));

        jLabel16.setText("Old Password:");

        jLabel17.setText("New Password:");

        jLabel18.setText("Confirm Password:");

        btnPWordSave.setText("Save");
        btnPWordSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPWordSaveActionPerformed(evt);
            }
        });

        btnPwordCancel.setText("Cancel");
        btnPwordCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPwordCancelActionPerformed(evt);
            }
        });

        txtConfirmPWord.setText("jPasswordField3");

        txtNewPword.setText("jPasswordField2");

        txtoldPword.setText("jPasswordField1");

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPWordSave)
                    .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)))
                .addGap(34, 34, 34)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPwordCancel)
                    .addComponent(txtoldPword, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(txtNewPword)
                    .addComponent(txtConfirmPWord))
                .addContainerGap(652, Short.MAX_VALUE))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel17)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel18))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addComponent(txtoldPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtNewPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtConfirmPWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPWordSave)
                    .addComponent(btnPwordCancel))
                .addContainerGap(312, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Change Password", jPanel3);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Date", "Pharmacy", "Status"
            }
        ));
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        jLabel2.setText("Pickup Details:");

        jLabel3.setText("Name:");

        jLabel4.setText("Phone:");

        jLabel5.setText("Address:");

        txtPickupAddress.setColumns(20);
        txtPickupAddress.setRows(5);
        jScrollPane5.setViewportView(txtPickupAddress);

        jLabel7.setText("Delivery Details:");

        jLabel8.setText("Name:");

        jLabel9.setText("Phone:");

        jLabel10.setText("Address:");

        txtDeliveryAddress.setColumns(20);
        txtDeliveryAddress.setRows(5);
        jScrollPane6.setViewportView(txtDeliveryAddress);

        btnInitailize.setBackground(new java.awt.Color(255, 255, 204));
        btnInitailize.setText("Initialize Delivery");
        btnInitailize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitailizeActionPerformed(evt);
            }
        });

        btnPickedUp.setText("Picked Up");
        btnPickedUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPickedUpActionPerformed(evt);
            }
        });

        btnDelivered.setText("Delivered");
        btnDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInitailize)
                        .addGap(38, 38, 38)
                        .addComponent(btnPickedUp)
                        .addGap(34, 34, 34)
                        .addComponent(btnDelivered))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(51, 51, 51)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDeliveryPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDeliveryName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPickupPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPickupName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPickupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPickupPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDeliveryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDeliveryPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPickedUp)
                    .addComponent(btnInitailize)
                    .addComponent(btnDelivered))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Work Area", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(nameLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nameLabel1))
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileEditActionPerformed
       btnProfileSave.setEnabled(true);
        btnProfileCancel.setEnabled(true);
        btnProfileEdit.setEnabled(false);
        
        txtUsername.setEnabled(false);
        txtRole.setEnabled(false);

        setFieldsEditable(true); // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileEditActionPerformed

    private void btnProfileCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileCancelActionPerformed
      setFieldsEditable(false);
        setInfo();

        btnProfileSave.setEnabled(false);
        btnProfileCancel.setEnabled(false);
        btnProfileEdit.setEnabled(true);  // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileCancelActionPerformed

    private void btnInitailizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitailizeActionPerformed
        selectedRequest.setStatus(StatusEnum.WaitForPickup);
        selectedRequest.setAccount(this.employeeAccount);
        selectedRequest.getOrder().setStatus(StatusEnum.WaitForPickup);
        system.getCustomerAccountByUsername(selectedRequest.getOrder().getAccount().getUserName()).
                getWork().getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.WaitForPickup);
        system.getEnterpriseById(selectedRequest.getOrder().getEnterprise().getID()).getWorkQueue().
                getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.WaitForPickup);
       
        HospitalType model = (HospitalType)system.getEnterpriseById(selectedRequest.getOrder().getEnterprise().getID());
        
        model.getWorkQueue().getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.WaitForPickup);
        en.getWorkQueue().getWorkRequestList().remove(selectedRequest);
        this.employeeAccount.getWork().getWorkRequestList().add(selectedRequest);
        DB4O.getInstance().storeSystem(system);
        populateOrderTable(getAllDeliveryRequest());
        populateDetails();
        btnInitailize.setEnabled(false);
        btnPickedUp.setEnabled(true);
        btnDelivered.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnInitailizeActionPerformed

    private void btnPWordSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPWordSaveActionPerformed
       char[] passwordCharArray = txtoldPword.getPassword();
        String password = String.valueOf(passwordCharArray);
        char[] passwordCharArray1 = txtNewPword.getPassword();
        String new1 = String.valueOf(passwordCharArray1);
        char[] passwordCharArray2 = txtConfirmPWord.getPassword();
        String new2 = String.valueOf(passwordCharArray2);

        if (password.equals(employeeAccount.getPassword())) {
            if (!new1.equals("")) {
                if (new1.equals(new2)) {
                    employeeAccount.setPassword(new1);
                    JOptionPane.showMessageDialog(null, "Password updated successfully!");
                    DB4O.getInstance().storeSystem(system);
                    resetPasswordField();
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords don't match!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password can't be empty!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correct!");
        }// TODO add your handling code here:// TODO add your handling code here:
    }//GEN-LAST:event_btnPWordSaveActionPerformed

    private void btnPwordCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPwordCancelActionPerformed
       resetPasswordField(); // TODO add your handling code here:
    }//GEN-LAST:event_btnPwordCancelActionPerformed

    private void btnProfileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileSaveActionPerformed
       String brand=txtFirstName.getText();
            if(brand==null || brand.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter First Name.");
                return;
            }
            else if(! brand.matches("^[a-zA-Z]+$"))
            {
                JOptionPane.showMessageDialog(null,"Enter valid First name. Only alphabets");

            }
         String lastname=txtLastName.getText();
            if(lastname==null || lastname.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Last Name.");
                return;
            }
            else if(! lastname.matches("^[a-zA-Z]+$"))
            {
                JOptionPane.showMessageDialog(null,"Enter valid Last name. Only alphabets");

            }   
            String min= txtProfilePhone.getText();
            if(min==null || min.equals("")){
                JOptionPane.showMessageDialog(null, "Phone Number cannot be Empty");
                return;
            }
            try{
                Integer.parseInt(min);

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Enter Valid Phone number. Only Numbers");
                return;
            }
        
        
        if (!txtEmail.getText().equals("") && !txtFirstName.getText().equals("")
                && !txtLastName.getText().equals("") && !txtProfilePhone.getText().equals("")) {
            this.employee.setEmailID(txtEmail.getText());
            this.employee.setFirstName(txtFirstName.getText());
            this.employee.setLastName(txtLastName.getText());
            this.employee.setContactNum(txtProfilePhone.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        setFieldsEditable(false);
        btnProfileSave.setEnabled(false);
        btnProfileCancel.setEnabled(false);
        btnProfileEdit.setEnabled(true);

        DB4O.getInstance().storeSystem(system);
      // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileSaveActionPerformed

    private void btnPickedUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPickedUpActionPerformed
        selectedRequest.setStatus(StatusEnum.OnTheWay);
        selectedRequest.getOrder().setStatus(StatusEnum.OnTheWay);
        system.getCustomerAccountByUsername(selectedRequest.getOrder().getAccount().getUserName()).
                getWork().getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.OnTheWay);
        system.getEnterpriseById(selectedRequest.getOrder().getEnterprise().getID()).getWorkQueue().
                getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.OnTheWay);
        DB4O.getInstance().storeSystem(system);
        populateOrderTable(getAllDeliveryRequest());
        populateDetails();
        btnInitailize.setEnabled(false);
        btnPickedUp.setEnabled(false);
        btnDelivered.setEnabled(true);// TODO add your handling code here:
       
    }//GEN-LAST:event_btnPickedUpActionPerformed

    private void btnDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveredActionPerformed
        
        
        selectedRequest.setStatus(StatusEnum.Completed);
        selectedRequest.getOrder().setStatus(StatusEnum.Completed);
        
        
        system.getCustomerAccountByUsername(selectedRequest.getOrder().getAccount().getUserName()).
                getWork().getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.Completed);
        system.getEnterpriseById(selectedRequest.getOrder().getEnterprise().getID()).getWorkQueue().
                getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.Completed);
      
        DB4O.getInstance().storeSystem(system);
        populateOrderTable(getAllDeliveryRequest());
        populateDetails();
        btnInitailize.setEnabled(false);
        btnPickedUp.setEnabled(false);
        btnDelivered.setEnabled(false);  // TODO add your handling code here:
    }//GEN-LAST:event_btnDeliveredActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
       int index = tblOrder.getSelectedRow();

        if (index >= 0) {
            selectedRequest = (DeliveryRequest) tblOrder.getValueAt(index, 1);
            if (selectedRequest.getStatus().equals(StatusEnum.Ready)) {
                btnInitailize.setEnabled(true);
                btnPickedUp.setEnabled(false);
                btnDelivered.setEnabled(false);
            }
            if (selectedRequest.getStatus().equals(StatusEnum.WaitForPickup)) {
                btnInitailize.setEnabled(false);
                btnPickedUp.setEnabled(true);
                btnDelivered.setEnabled(false);
            }
            if (selectedRequest.getStatus().equals(StatusEnum.OnTheWay)) {
                btnInitailize.setEnabled(false);
                btnPickedUp.setEnabled(false);
                btnDelivered.setEnabled(true);
            }
            if (selectedRequest.getStatus().equals(StatusEnum.Completed) ||
                    selectedRequest.getStatus().equals(StatusEnum.Cancelled)) {
                btnInitailize.setEnabled(false);
                btnPickedUp.setEnabled(false);
                btnDelivered.setEnabled(false);
            }
            populateDetails();
        } else {
            btnInitailize.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblOrderMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelivered;
    private javax.swing.JButton btnInitailize;
    private javax.swing.JButton btnPWordSave;
    private javax.swing.JButton btnPickedUp;
    private javax.swing.JButton btnProfileCancel;
    private javax.swing.JButton btnProfileEdit;
    private javax.swing.JButton btnProfileSave;
    private javax.swing.JButton btnPwordCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JTable tblOrder;
    private javax.swing.JPasswordField txtConfirmPWord;
    private javax.swing.JTextArea txtDeliveryAddress;
    private javax.swing.JTextField txtDeliveryName;
    private javax.swing.JTextField txtDeliveryPhone;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtNewPword;
    private javax.swing.JTextArea txtPickupAddress;
    private javax.swing.JTextField txtPickupName;
    private javax.swing.JTextField txtPickupPhone;
    private javax.swing.JTextField txtProfilePhone;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtoldPword;
    // End of variables declaration//GEN-END:variables
}
