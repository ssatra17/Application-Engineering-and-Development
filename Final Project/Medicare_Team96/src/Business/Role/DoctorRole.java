/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Doctor.DoctorAssistantJPanel;

/**
 *
 * @author parth
 */
public class DoctorRole extends Role{

   public DoctorRole() {
        super(Role.RoleType.Doctor);
    }

    @Override
    public String toString() {
       return Role.RoleType.Doctor.getValue();
    }


    @Override
    public JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Enterprise en, Organization organization) {
        return new DoctorAssistantJPanel(system,container,userAccount,en,organization);
    }
    
    
    
    
}
