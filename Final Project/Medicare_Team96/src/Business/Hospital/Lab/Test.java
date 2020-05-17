/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.Lab;

import Business.Enterprise.Product;

/**
 *
 * @author parth
 */
public class Test extends Product {
    private Lab Lab;
    
    public Test(Lab Lab, String name, double price){
        super(name,price);
        this.Lab=Lab;
    }
    
    public Business.Hospital.Lab.Lab getLab(){
        return this.Lab;
    }
    
}
