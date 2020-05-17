/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DeliveryManRole;
import Business.Role.ManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class DeliveryOrganization extends Organization {

    public DeliveryOrganization() {
        super(Organization.Type.Delivery.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
      ArrayList<Role> roles = new ArrayList();
        roles.add(new DeliveryManRole());
        roles.add(new ManagerRole());
        return roles;  
    }

   
    
    
    
}
