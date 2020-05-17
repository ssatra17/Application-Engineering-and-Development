/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Delivery.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import static Business.Enterprise.HospitalType.departmenttype.Lab;
import static Business.Enterprise.HospitalType.departmenttype.Pharmacy;
import Business.Hospital.Doctor.Doctor;
import Business.Hospital.Lab.Lab;
import Business.Hospital.Pharmacy.Pharmacy;
import Business.Hospital.SocialEvents.SocialEvents;
import static Business.Organization.Organization.Type.Pharmacy;
import static Business.Role.Role.RoleType.Doctor;
import java.util.ArrayList;

/**
 *
 * @author saura
 */
public class Network {
     private String id;
    private EnterpriseDirectory enterpriseDir;
    private String City;
    private static int counter=0;
    
    public Network(String name){
        enterpriseDir= new EnterpriseDirectory();
        this.City=City;
        this.id="Network" + counter;
        counter++;
    }   

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnterpriseDirectory getEnterpriseDir() {
        return enterpriseDir;
    }

    public void setEnterpriseDir(EnterpriseDirectory enterpriseDir) {
        this.enterpriseDir = enterpriseDir;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Network.counter = counter;
    }
     public Pharmacy createPharmacy(String name, String address, String phone) {
        Pharmacy p = new Pharmacy(name, address, phone);
        p.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(p);
        return p;
    }
     public ArrayList<Pharmacy> getPharmacyList() {
        ArrayList<Pharmacy> result = new ArrayList<>();
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof Pharmacy) {
                Pharmacy p = (Pharmacy) en;
                result.add(p);
            }
        }
        return result;
    }

    public DeliveryCompany createDeliveryCompany(String name, String address, String phone) {
        DeliveryCompany d = new DeliveryCompany(name, address, phone);
        d.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(d);
        return d;
    }
    public ArrayList<DeliveryCompany> getDeliveryCompanyList() {
        ArrayList<DeliveryCompany> result = new ArrayList<>();
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof DeliveryCompany) {
                DeliveryCompany del = (DeliveryCompany) en;
                result.add(del);
            }
        }
        return result;
    }    
     public Lab createLab(String name, String phone,String contact) {
        Lab l = new Lab(name,phone,contact);
        l.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(l);
        return l;
    }
     public ArrayList<Lab> getLabList() {
        ArrayList<Lab> result = new ArrayList<>();
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof Lab) {
                Lab l = (Lab) en;
                result.add(l);
            }
        }
        return result;
    }
     
      public Doctor createDoctor(String name, String phone,String contact) {
        Doctor d = new Doctor(name,phone,contact);
        d.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(d);
        return d;
    }
     public ArrayList<Doctor> getDoctorList() {
        ArrayList<Doctor> result = new ArrayList<>();
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof Doctor) {
                Doctor d = (Doctor) en;
                result.add(d);
            }
        }
        return result;
    }
     public SocialEvents createEvents(String name, String phone,String contact) {
        SocialEvents s = new SocialEvents(name,phone,contact);
        s.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(s);
        return s;
    }
     public ArrayList<SocialEvents> getEventList() {
        ArrayList<SocialEvents> result = new ArrayList<>();
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en instanceof SocialEvents) {
                SocialEvents s = (SocialEvents) en;
                result.add(s);
            }
        }
        return result;
    }
     
     @Override
     public String  toString(){
         return id;
     }
}
