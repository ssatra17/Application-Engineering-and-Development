/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.SocialEvent.getValue())){
            organization = new EventOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
     public Organization getTypicalOrganization(Organization.Type type) {
        if (type.equals(Organization.Type.Delivery)) {
            for (Organization or:this.organizationList) {
                if (or.getName().equalsIgnoreCase(Organization.Type.Delivery.getValue())) {
                    return or;
                }
            }
        }
        if (type.equals(Organization.Type.Pharmacy)) {
            for (Organization or:this.organizationList) {
                if (or.getName().equalsIgnoreCase(Organization.Type.Pharmacy.getValue())) {
                    return or;
                }
            }
        }
        if (type.equals(Organization.Type.Lab)) {
            for (Organization or:this.organizationList) {
                if (or.getName().equalsIgnoreCase(Organization.Type.Lab.getValue())) {
                    return or;
                }
            }
        }
        if (type.equals(Organization.Type.Doctor)) {
            for (Organization or:this.organizationList) {
                if (or.getName().equalsIgnoreCase(Organization.Type.Doctor.getValue())) {
                    return or;
                }
            }
        }
         if (type.equals(Organization.Type.SocialEvent)) {
            for (Organization or:this.organizationList) {
                if (or.getName().equalsIgnoreCase(Organization.Type.SocialEvent.getValue())) {
                    return or;
                }
            }
        }
        return null;
    }  
}