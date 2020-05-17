/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Hospital.SocialEvents.SocialEvents;

/**
 *
 * @author parth
 */
public class EventOrder extends ProductOrder {
    private SocialEvents socialevents;

    public EventOrder(HospitalType department, Product product, int quantity) {
        super(department, product, quantity);
        this.socialevents=(SocialEvents) department;
    }
    
     @Override
    public HospitalType getDepartment(){
        return this.socialevents;
    }

    public SocialEvents getSocialevents() {
        return (SocialEvents) this.getSocialevents();
    }

    
    @Override
    public HospitalType getdepartmentModel() {
     return this.socialevents;
    }
    
    
}
