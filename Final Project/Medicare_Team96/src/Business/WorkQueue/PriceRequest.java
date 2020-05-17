/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

/**
 *
 * @author parth
 */
public class PriceRequest extends WorkRequest{
     private int price;

    public PriceRequest(Enterprise enterprise, UserAccount account) {
        super(enterprise, account);
        this.price = -1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
