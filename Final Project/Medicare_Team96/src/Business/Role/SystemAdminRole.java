/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author parth
 */
public class SystemAdminRole extends Role{

     public SystemAdminRole() {
        super(Role.RoleType.SystemAdmin);
    }

    @Override
    public String toString() {
     return Role.RoleType.SystemAdmin.getValue();
    }

    @Override
    public JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Enterprise en, Organization organization) {
       return new SystemAdminWorkAreaJPanel(container,system);
    }
    
}
