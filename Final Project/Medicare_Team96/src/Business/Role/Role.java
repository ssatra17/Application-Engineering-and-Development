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

/**
 *
 * @author parth
 */
public abstract class Role {
     private RoleType type;
    public enum RoleType{
        Doctor("Doctor"),
        LabAssistant("Lab Assistant"),
        Manager("Manager"),
        Patient("Patient"),
        SystemAdmin("System Admin"),
        DeliveryMan("Delivery Man"),
        EventManager("Event Manager");
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
 public Role(RoleType type){
       this.type=type;
   }
 

   public RoleType getRoleType() {
        return this.type;
    }
    
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
            public abstract JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount,  Enterprise en, Organization organization);

    
}