/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Delivery;

import Business.Enterprise.Enterprise;
import Business.Organization.DeliveryOrganization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class DeliveryCompany extends Enterprise {
    
    private int photoId;
    private String address;
    private String phone;
    private static int counter = 0;
    private String photoPath;
    private String description;
    private String id;
    
    public DeliveryCompany(String name,String address, String phone) {
        super(name,EnterpriseType.Delivery);
        this.photoId = counter;
        this.id = "Delivery" + counter;
        counter++;
        this.address = address;
        this.phone = phone;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        DeliveryCompany.counter = counter;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    @Override
    public String getID() {
     return this.id;        
    }

    public void createOrganizations() {
        this.getOrganizationDirectory().getOrganizationList().add(new DeliveryOrganization() );
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
