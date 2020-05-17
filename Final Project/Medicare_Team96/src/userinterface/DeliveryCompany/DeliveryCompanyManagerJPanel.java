/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DeliveryCompany;

import Business.DB4O.DB4O;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Delivery.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
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
import UserInterface.Pharmacy.Medicines.createEmployeeJPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author parth
 */
public class DeliveryCompanyManagerJPanel extends javax.swing.JPanel {
private EcoSystem system;
    private JPanel userProcessContainer;
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
    
    /**
     * Creates new form DeliveryCompanyManagerJPanel
     */
    

    public DeliveryCompanyManagerJPanel(EcoSystem system, JPanel container, UserAccount userAccount,Enterprise en, Organization organization) {
        this.system = system;
        this.userProcessContainer=container;
       // this.net=net;
        this.en=en;
        this.organization=organization;
        this.employeeAccount = (EmployeeAccount) userAccount;
        this.employee = this.employeeAccount.getEmployee();
        this.company=(DeliveryCompany) en;
        initComponents();
        populateOrderTable(getAllDeliveryRequest());
        populateEmployeeTable(company.getOrganizationDirectory().getOrganizationList());
        
        //Overview
        btnEdit.setEnabled(true);
        btnSave.setEnabled(false);        
        btnCancel.setEnabled(false);
        setOverviewFieldsEditable(false);
        setOverviewInfo();
        //Profile
        btnProfileSave.setEnabled(false);
        btnProfileCancel.setEnabled(false);
        btnProfileEdit.setEnabled(true);
        txtUsername.setEnabled(false);
        txtRole.setEnabled(false);

        setInfo();
        setProfileFieldsEditable(false);
       //password
        txtoldPword.setText("");
        txtNewPword.setText("");
        txtConfirmPWord.setText("");
        //
        btnDeliveryCancel.setVisible(false);
    }

    
    private void setInfo(){
      lblName.setText(employee.getFirstName() +"   " + employee.getLastName());
    txtFirstName.setText(employee.getFirstName());
    txtLastName.setText(employee.getLastName());
    txtProfilePhone.setText(employee.getContactNum());
    txtEmail.setText(employee.getEmailID());
    txtUsername.setText(employeeAccount.getUserName());
     txtRole.setText(this.employeeAccount.getRole().getRoleType().getValue());
    
}
    private void setProfileFieldsEditable(boolean b) {
        txtEmail.setEnabled(b);
        txtFirstName.setEnabled(b);
        txtLastName.setEnabled(b);
        txtProfilePhone.setEnabled(b);
        
    }
    private void setOverviewFieldsEditable(boolean b) {
        txtName.setEnabled(b);
        txtAddress.setEnabled(b);
        txtPhone.setEnabled(b);
        txtDescription.setEnabled(b);
    }
    private void setOverviewInfo(){
     txtName.setText(company.getName());
     txtAddress.setText(company.getAddress());
     txtPhone.setText(company.getPhone());
     txtDescription.setText(company.getDescription());
 }
    private void resetPasswordField() {
        txtoldPword.setText("");
        txtNewPword.setText("");
        txtConfirmPWord.setText("");
    }
    private ArrayList<WorkRequest> getAllDeliveryRequest() {
        ArrayList<WorkRequest> list = new ArrayList<>();
        for (WorkRequest wr:en.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof DeliveryRequest) {
                list.add(wr);
            }
        }
        for (UserAccount ac : en.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Delivery).
                getUserAccountDirectory().getUserAccountList()) {
            list.addAll(ac.getWork().getWorkRequestList());
        }
        return list;
    }
     public void populateOrderTable(ArrayList<WorkRequest> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblOrder.getModel();
        dtm.setRowCount(0);
        for (WorkRequest wr : list) {
            DeliveryRequest or = (DeliveryRequest) wr;
            Object row[] = new Object[4];
            row[0] = or.getOrder().getId();
            row[1] = or;
            row[2] = (HospitalType) or.getOrder().getEnterprise();
            row[3] = or.getStatus();
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


    public void populateEmployeeTable(ArrayList<Organization> list) {
        ArrayList<EmployeeAccount> result = new ArrayList<>();

        result.addAll(this.en.getUserAccountDirectory().toEmployeeAccounts());

        for (Organization org : list) {
            result.addAll(org.getUserAccountDirectory().toEmployeeAccounts());
        }

        DefaultTableModel dtm = (DefaultTableModel) tblEmployee.getModel();
        dtm.setRowCount(0);
        for (EmployeeAccount e : result) {
            Object row[] = new Object[4];
            row[0] = e;
            row[1] = e.getRole();
            row[2] = e.getEmployee().getFirstName() + e.getEmployee().getLastName();
            row[3] = e.getEmployee().getEmailID();
            dtm.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        OverviewPanel = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        employeePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        DeliveryPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPickupName = new javax.swing.JTextField();
        txtPickupPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDeliveryName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDeliveryPhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnDeliveryCancel = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtPickupAddress = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDeliveryAddress = new javax.swing.JTextArea();
        profilePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProfilePhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        btnProfileEdit = new javax.swing.JButton();
        btnProfileSave = new javax.swing.JButton();
        btnProfileCancel = new javax.swing.JButton();
        passwordPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnPWordSave = new javax.swing.JButton();
        btnPwordCancel = new javax.swing.JButton();
        txtoldPword = new javax.swing.JPasswordField();
        txtNewPword = new javax.swing.JPasswordField();
        txtConfirmPWord = new javax.swing.JPasswordField();
        lblWelcome = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        OverviewPanel.setBackground(new java.awt.Color(204, 204, 255));

        lblname.setText("Name:");

        lblAddress.setText("Address:");

        lblPhone.setText("Phone:");

        lblDescription.setText("Description");

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane3.setViewportView(txtAddress);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane4.setViewportView(txtDescription);

        javax.swing.GroupLayout OverviewPanelLayout = new javax.swing.GroupLayout(OverviewPanel);
        OverviewPanel.setLayout(OverviewPanelLayout);
        OverviewPanelLayout.setHorizontalGroup(
            OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OverviewPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAddress)
                        .addComponent(lblPhone)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription))
                .addGap(34, 34, 34)
                .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(OverviewPanelLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 601, Short.MAX_VALUE))
        );
        OverviewPanelLayout.setVerticalGroup(
            OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OverviewPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(OverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addGap(234, 234, 234))
        );

        jTabbedPane1.addTab("Overview", OverviewPanel);

        employeePanel.setBackground(new java.awt.Color(204, 204, 255));

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Email", "Username", "Role"
            }
        ));
        jScrollPane1.setViewportView(tblEmployee);

        btnCreate.setText("Add New Employee");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh Employee Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeePanelLayout = new javax.swing.GroupLayout(employeePanel);
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(jButton1))))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Employee", employeePanel);

        DeliveryPanel.setBackground(new java.awt.Color(204, 204, 255));

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

        jLabel6.setText("Delivery Details:");

        jLabel7.setText("Name:");

        jLabel8.setText("Phone:");

        jLabel9.setText("Address:");

        btnDeliveryCancel.setText("Cancel Order");
        btnDeliveryCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryCancelActionPerformed(evt);
            }
        });

        txtPickupAddress.setColumns(20);
        txtPickupAddress.setRows(5);
        jScrollPane5.setViewportView(txtPickupAddress);

        txtDeliveryAddress.setColumns(20);
        txtDeliveryAddress.setRows(5);
        jScrollPane6.setViewportView(txtDeliveryAddress);

        javax.swing.GroupLayout DeliveryPanelLayout = new javax.swing.GroupLayout(DeliveryPanel);
        DeliveryPanel.setLayout(DeliveryPanelLayout);
        DeliveryPanelLayout.setHorizontalGroup(
            DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeliveryPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(DeliveryPanelLayout.createSequentialGroup()
                                    .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(50, 50, 50)
                                    .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPickupPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addComponent(txtPickupName)
                                        .addComponent(jScrollPane5)))
                                .addGroup(DeliveryPanelLayout.createSequentialGroup()
                                    .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDeliveryPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addComponent(txtDeliveryName, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6))))))
                    .addGroup(DeliveryPanelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnDeliveryCancel)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        DeliveryPanelLayout.setVerticalGroup(
            DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DeliveryPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPickupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPickupPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDeliveryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDeliveryPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DeliveryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addComponent(btnDeliveryCancel)))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Delivery", DeliveryPanel);

        profilePanel.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("First Name:");

        jLabel10.setText("Last Name:");

        jLabel11.setText("Phone:");

        jLabel12.setText("Email:");

        jLabel13.setText("Username:");

        jLabel14.setText("Role:");

        btnProfileEdit.setText("Edit");
        btnProfileEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileEditActionPerformed(evt);
            }
        });

        btnProfileSave.setText("Save");
        btnProfileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileSaveActionPerformed(evt);
            }
        });

        btnProfileCancel.setText("Cancel");
        btnProfileCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(80, 80, 80)
                        .addComponent(txtFirstName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(80, 80, 80)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProfilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(83, 83, 83))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(123, 123, 123))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                                        .addComponent(btnProfileEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)))))
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addComponent(btnProfileSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProfileCancel))
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtRole))))
                .addContainerGap(533, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtProfilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProfileEdit)
                    .addComponent(btnProfileSave)
                    .addComponent(btnProfileCancel))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("My Profile", profilePanel);

        passwordPanel.setBackground(new java.awt.Color(204, 204, 255));

        jLabel15.setText("Old Password:");

        jLabel16.setText("New Password:");

        jLabel17.setText("Confirm Password:");

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

        txtoldPword.setText("jPasswordField1");

        txtNewPword.setText("jPasswordField2");

        txtConfirmPWord.setText("jPasswordField3");

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addContainerGap())
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addGroup(passwordPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnPWordSave)))
                        .addGap(52, 52, 52)
                        .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(passwordPanelLayout.createSequentialGroup()
                                .addComponent(txtConfirmPWord, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(passwordPanelLayout.createSequentialGroup()
                                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPwordCancel)
                                    .addComponent(txtNewPword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtoldPword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(584, Short.MAX_VALUE))))))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtoldPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtNewPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtConfirmPWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPWordSave)
                    .addComponent(btnPwordCancel))
                .addContainerGap(355, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Change Password", passwordPanel);

        lblWelcome.setText("Welcome");

        lblName.setText("<Name>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addGap(18, 18, 18)
                .addComponent(lblName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(lblName))
                .addGap(25, 25, 25)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        btnEdit.setEnabled(false);

        setOverviewFieldsEditable(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setOverviewFieldsEditable(false);
        setOverviewInfo();

        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        btnEdit.setEnabled(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
       createEmployeeJPanel m = new createEmployeeJPanel(system, userProcessContainer, this.company,en,organization);
        this.userProcessContainer.add(m);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        populateEmployeeTable(company.getOrganizationDirectory().getOrganizationList());
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeliveryCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryCancelActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Are you sure to cancel this order?");
        if (input == 0) {
            selectedRequest.setStatus(StatusEnum.Cancelled);
            selectedRequest.getOrder().setStatus(StatusEnum.Cancelled);
            system.getCustomerAccountByUsername(selectedRequest.getOrder().getAccount().getUserName()).
                    getWork().getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.Cancelled);
            system.getEnterpriseById(selectedRequest.getOrder().getEnterprise().getID()).getWorkQueue().
                    getOrderById(selectedRequest.getOrder().getId()).setStatus(StatusEnum.Cancelled);
            DB4O.getInstance().storeSystem(system);
            populateOrderTable(getAllDeliveryRequest());
        } // TODO add your handling code here:
    }//GEN-LAST:event_btnDeliveryCancelActionPerformed

    private void btnProfileEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileEditActionPerformed
       btnProfileSave.setEnabled(true);
        btnProfileCancel.setEnabled(true);
        btnProfileEdit.setEnabled(false);
        txtUsername.setEnabled(false);
        txtRole.setEnabled(false);


        setProfileFieldsEditable(true); // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileEditActionPerformed

    private void btnProfileCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileCancelActionPerformed
       setProfileFieldsEditable(false);
        setInfo();
        txtUsername.setEnabled(false);
        txtRole.setEnabled(false);

        btnProfileSave.setEnabled(false);
        btnProfileCancel.setEnabled(false);
        btnProfileEdit.setEnabled(true); // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileCancelActionPerformed

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
        }
    }//GEN-LAST:event_btnPWordSaveActionPerformed

    private void btnPwordCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPwordCancelActionPerformed
        resetPasswordField();
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
              
      }else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
      
        setProfileFieldsEditable(false);
        btnProfileSave.setEnabled(false);
        btnProfileCancel.setEnabled(false);
        btnProfileEdit.setEnabled(true);

        DB4O.getInstance().storeSystem(system);  // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileSaveActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      String brand=txtName.getText();
            if(brand==null || brand.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Name.");
                return;
            }
            else if(! brand.matches("^[a-zA-Z]+$"))
            {
                JOptionPane.showMessageDialog(null,"Enter valid name. Only alphabets");

            }
        String address=txtAddress.getText();
            if(address==null || address.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Address.");
                return;
            }
            String min= txtPhone.getText();
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
        
        
        if (!txtPhone.getText().equals("") && !txtAddress.getText().equals("")
                && !txtDescription.getText().equals("") && !txtName.getText().equals("")) {
            company.setName(txtName.getText());
            company.setAddress(txtAddress.getText());
            company.setDescription(txtDescription.getText());
            company.setPhone(txtPhone.getText());
            
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        setOverviewFieldsEditable(false);
        setOverviewInfo();
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        btnEdit.setEnabled(true);

        DB4O.getInstance().storeSystem(system);  // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        int index = tblOrder.getSelectedRow();

        if (index >= 0) {
            selectedRequest = (DeliveryRequest) tblOrder.getValueAt(index, 1);
            if (!selectedRequest.getStatus().equals(StatusEnum.Cancelled)
                    && !selectedRequest.getStatus().equals(StatusEnum.Completed)) {
                btnDeliveryCancel.setVisible(true);
            }
            populateDetails();
        } else {
            btnDeliveryCancel.setVisible(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tblOrderMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        populateEmployeeTable(company.getOrganizationDirectory().getOrganizationList());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeliveryPanel;
    private javax.swing.JPanel OverviewPanel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDeliveryCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPWordSave;
    private javax.swing.JButton btnProfileCancel;
    private javax.swing.JButton btnProfileEdit;
    private javax.swing.JButton btnProfileSave;
    private javax.swing.JButton btnPwordCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel employeePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblname;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JPasswordField txtConfirmPWord;
    private javax.swing.JTextArea txtDeliveryAddress;
    private javax.swing.JTextField txtDeliveryName;
    private javax.swing.JTextField txtDeliveryPhone;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtNewPword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextArea txtPickupAddress;
    private javax.swing.JTextField txtPickupName;
    private javax.swing.JTextField txtPickupPhone;
    private javax.swing.JTextField txtProfilePhone;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtoldPword;
    // End of variables declaration//GEN-END:variables
}
