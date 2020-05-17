/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.SocialEvents;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Hospital.Lab.Test;
import Business.Organization.EventOrganization;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class SocialEvents extends HospitalType {
   private EventCategory category;
    private String id;
    private static int counter = 0;
    private String photoPath;

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }
    

    public SocialEvents(String name, String phone, String contactNum) {
        super(name, phone, contactNum);
        this.id = "Social Events" + counter;
        counter++;
        this.setDepartment(HospitalType.departmenttype.Events);
    }
    public enum EventCategory {
           Camps
            }
     
    @Override
    public String getID() {
       return this.id;
    }
    public void addEvents(Events a){
        this.getProduct().add(a);
    }

    
    @Override
    public departmenttype getType() {
    return departmenttype.Events;    
    }
    
    public ArrayList<Events> getGoods() {
        ArrayList<Events> result = new ArrayList<Events>();
        for (Product product : this.getProduct()) {
            Events test = (Events) product;
            result.add(test);
        }
        return result;
    }
public void createOrganizations() {
      this.getOrganizationDirectory().getOrganizationList().add(new EventOrganization());
}
    @Override
    public double getRate() {
        double totalRate = 0;
        double num = 0;
        for (WorkRequest wr : this.getWorkQueue() .getWorkRequestList()) {
            OrderRequest order = (OrderRequest) wr;
            if (order.isPrice()) {
                totalRate = totalRate + order.getPrice().getPrice();
                num++;
            }
        }
        if (num == 0) {
            return -1;
        }
        BigDecimal bd = new BigDecimal(totalRate / num);
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
      
}
