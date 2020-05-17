/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Hospital.Lab.Lab;

/**
 *
 * @author DAVE
 */
public class TestOrder extends ProductOrder {
    private Lab Lab;
    
    public TestOrder(HospitalType department, Product product, int quantity){
        super(department, product,quantity);
        this.Lab=(Lab) department;
        
    }
    @Override
    public HospitalType getDepartment(){
        return this.Lab;
    }
    
    public Lab getLab() {
        return (Lab) this.getLab();
    }

    @Override
    public HospitalType getdepartmentModel() {
        return this.Lab;
    }
    
}
