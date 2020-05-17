/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Delivery.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Patient.ProductOrder;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class OrderRequest extends WorkRequest {
     private String id;
    
    private StatusEnum status;
    private String deliveryName;
    private String deliveryAddress;
    private String deliveryPhone;
    private double amount;
    private DeliveryCompany company;
    private ArrayList<ProductOrder> order;
    private PriceRequest price;
     private String deliverydate;
    private String deliverytime; 

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }
    
    

    // generate order number
    public static String genId() {
        String orderId
                = (System.currentTimeMillis() + "").substring(1);
        return orderId;
    }
   

    public OrderRequest(Enterprise enterprise, UserAccount account, ArrayList<ProductOrder> order) {
        super(enterprise, account);
        this.order = order;
        this.id = genId();
       
    }

    

    public String getId() {
        return this.id;
    }
     

    public String getDeliveryName() {
        return this.deliveryName;
    }

    public void setDeliveryName(String name) {
        this.deliveryName = name;
    }

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String address) {
        this.deliveryAddress = address;
    }

    public String getDeliveryPhone() {
        return this.deliveryPhone;
    }

    public void setDeliveryPhone(String phone) {
        this.deliveryPhone = phone;
    }

    public ArrayList<ProductOrder> getItems() {
        return this.order;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public DeliveryCompany getCompany() {
        return this.company;
    }

    public void setCompany(DeliveryCompany company) {
        this.company = company;
    }

     public boolean isPrice() {
        if (this.price == null) {
            return false;
        } else {
            if (this.price.getPrice() == -1) {
                return false;
            }
        }
        return true;
    }

    public PriceRequest getPrice() {
        return price;
    }

    public void setReview(PriceRequest price) {
        this.price = price;
    }

    public ArrayList<ProductOrder> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<ProductOrder> order) {
        this.order = order;
    }
    
}
