/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Hospital.Pharmacy.Pharmacy;

/**
 *
 * @author parth
 */
public class MedicineOrder extends ProductOrder {
    
    private Pharmacy pharmacy;
    
    public MedicineOrder(HospitalType department, Product product, int quantity){
        super(department, product,quantity);
        this.pharmacy=(Pharmacy) department;
        
    }
    @Override
    public HospitalType getDepartment(){
        return this.pharmacy;
    }
    
    public Pharmacy getPharmacy() {
        return (Pharmacy) this.getDepartment();
    }

    @Override
    public HospitalType getdepartmentModel() {
        return this.pharmacy;
    }
    
}
