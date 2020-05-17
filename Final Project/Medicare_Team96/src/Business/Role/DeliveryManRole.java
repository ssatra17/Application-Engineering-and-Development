/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DeliveryCompany.DeliveryManJPanel;
import javax.swing.JPanel;

/**
 *
 * @author parth
 */
public class DeliveryManRole extends Role{

   public DeliveryManRole() {
        super(Role.RoleType.DeliveryMan);
    }      

    @Override
    public String toString() {
     return Role.RoleType.DeliveryMan.getValue();
    }

    @Override
    public JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Enterprise en, Organization organization) {
               return new DeliveryManJPanel(system,container,userAccount,en,organization);

    }

   

   
    
}
