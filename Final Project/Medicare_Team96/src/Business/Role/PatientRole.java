/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JFrame;
import javax.swing.JPanel;
import userinterface.Patient.PatientMainJPanel;

/**
 *
 * @author parth
 */
public class PatientRole extends Role{

    public PatientRole() {
        super(Role.RoleType.Patient);
    }

    @Override
    public String toString() {
     return Role.RoleType.Patient.getValue();
    }
   
    @Override
    public JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Enterprise en, Organization organization) {
       return new PatientMainJPanel(system, container,userAccount);

 
}
     
    
 

}
