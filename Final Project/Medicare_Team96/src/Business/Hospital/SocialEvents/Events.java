/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.SocialEvents;

import Business.Enterprise.Product;

/**
 *
 * @author parth
 */
public class Events extends Product{
    private SocialEvents SocialEvents;

    public Events(SocialEvents socialEvents,String name, double price) {
        super(name, price);
        this.SocialEvents=socialEvents;
    }

    public Business.Hospital.SocialEvents.SocialEvents getSocialEvents(){
        return this.SocialEvents;
    }
    
    
    
    
}
