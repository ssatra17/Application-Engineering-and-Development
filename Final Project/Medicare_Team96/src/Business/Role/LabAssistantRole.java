/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Lab.LabAssistantJPanel;

/**
 *
 * @author parth
 */
public class LabAssistantRole extends Role {

   public LabAssistantRole() {
        super(Role.RoleType.LabAssistant);
    }

    @Override
    public String toString() {
        return Role.RoleType.LabAssistant.getValue();
    }

    @Override
    public JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Enterprise en, Organization organization) {
        return new LabAssistantJPanel(system,container,userAccount,en,organization);

    }



    

    
}
