/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public abstract class HospitalType extends HospitalEnterprise {
    private String name;
    private String phone;
    private String address;
    private String description;
    private departmenttype department;
    private ArrayList<Product> product;

    public HospitalType(String name) {
        super(name);
    }

    public HospitalType(String name, String phone,String address) {
        super(name);
        this.name=name;
        this.phone=phone;
        this.description=description;
        this.address = address;
        this.product= new ArrayList<Product>();
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public enum departmenttype{
        Doctor("Doctor"),
        Lab("Lab"),
        Pharmacy("Pharmacy"),
        Events("Social Events");
        private String value;
        
        private departmenttype (String value){
            this.value=value;
        }
         public String getValue() {
            return value;
        }

        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public departmenttype getDepartment() {
        return department;
    }

    public void setDepartment(departmenttype department) {
        this.department = department;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }
    
    public abstract  departmenttype getType();
    public abstract double getRate();
}
