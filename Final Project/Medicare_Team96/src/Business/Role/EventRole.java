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
import javax.swing.JPanel;
import userinterface.EventMnager.EventManagerPanel;

/**
 *
 * @author parth
 */
public class EventRole  extends Role{

    public EventRole() {
        super(Role.RoleType.EventManager);
    }
@Override
    public String toString() {
        return Role.RoleType.EventManager.getValue();
    }

    @Override
    public JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Enterprise en, Organization organization) {
     return new EventManagerPanel(system, container, userAccount, en, organization);
    }
    
}
