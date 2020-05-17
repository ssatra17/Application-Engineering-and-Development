/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;


import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Hospital.Doctor.Doctor;
/**
 *
 * @author DAVE
 */
public class AppointmentOrder extends ProductOrder{
    private Doctor Doctor;
    
    public AppointmentOrder(HospitalType department, Product product, int quantity){
        super(department, product,quantity);
        this.Doctor=(Doctor) department;
        
    }
    @Override
    public HospitalType getDepartment(){
        return this.Doctor;
    }
    
    public Doctor getDoctor() {
        return (Doctor) this.getDoctor();
    }

    @Override
    public HospitalType getdepartmentModel() {
        return this.Doctor;
    }
}
