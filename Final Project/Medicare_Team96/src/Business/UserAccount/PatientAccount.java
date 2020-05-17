/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Patient.Cart;
import Business.Patient.Patient;
import Business.Role.PatientRole;

/**
 *
 * @author parth
 */
public class PatientAccount extends UserAccount {
     private Patient patient;
    private Cart cart;
    
    
    public PatientAccount(String username, String password, Patient patient) {
        super(username, password, new PatientRole());
        this.patient=patient;
        this.cart= new Cart();
    }

    public Patient getPatient() {
        return patient;
    }

    public Cart getCart() {
        return cart;
    }
    
}
