/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.Doctor;

import Business.Enterprise.Product;
/**
 *
 * @author DAVE
 */
public class Appointments extends Product{
    private Doctor Doctor;
    
    public Appointments(Doctor Doctor, String name, double price){
        super(name,price);
        this.Doctor=Doctor;
    }
    
    public Business.Hospital.Doctor.Doctor getLab(){
        return this.Doctor;
    }
}
