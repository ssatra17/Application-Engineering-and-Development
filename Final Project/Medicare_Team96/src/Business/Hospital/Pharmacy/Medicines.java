/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.Pharmacy;

import Business.Enterprise.Product;

/**
 *
 * @author saura
 */
public class Medicines extends Product {
    private Pharmacy pharmacy;
    
    public Medicines(Pharmacy pharmacy, String name, double price ){
        super(name,price);
        this.pharmacy=pharmacy;
    }
    
    public Pharmacy getPharmacy(){
        return this.pharmacy;
    }
    
}
