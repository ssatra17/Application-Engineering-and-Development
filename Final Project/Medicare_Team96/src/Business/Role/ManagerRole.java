/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Delivery.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Hospital.Pharmacy.Pharmacy;
import Business.Organization.DeliveryOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.DeliveryCompany.DeliveryCompanyManagerJPanel;
import UserInterface.Pharmacy.Medicines.MedicinesManagerJpanel;
import javax.swing.JPanel;

/**
 *
 * @author parth
 */
public class ManagerRole extends Role {
  public ManagerRole(){
        super(Role.RoleType.Manager);
    }
  @Override
    public String toString() {
        return Role.RoleType.Manager.getValue();
    }  

    @Override
    public JPanel createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount,Enterprise en, Organization organization) {
        
 if (en instanceof Pharmacy){
        return new MedicinesManagerJpanel(system,container,userAccount,en,(PharmacyOrganization)organization);
 }
 if(en instanceof  DeliveryCompany){
     return new DeliveryCompanyManagerJPanel(system,container,userAccount,en,(DeliveryOrganization) organization);
 }
        return null;

       
    }
  
    
}
