/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author parth
 */
public class DeliveryRequest extends WorkRequest{
     private StatusEnum status;
    private OrderRequest order;
    private Date preparedTime;
    private String pickupTime;
    private String deliveredTime;
     private String deliveredDate;

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }
    

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DeliveryRequest(Enterprise enterprise, UserAccount account, OrderRequest order) {
        super(enterprise, account);
        this.order = order;
    }

    public String getPreparedTime() {
        return this.format.format(preparedTime);
    }

    public String getPickupTime() {
        return this.format.format(pickupTime);
    }

    public String getDeliveredTime() {
        return this.format.format(deliveredTime);
    }

    public void setPreparedTime(Date date) {
        this.preparedTime = date;
    }

    public void setPickupTime(String date) {
        this.pickupTime = date;
    }

    public void setDeliveredTime(String date) {
        this.deliveredTime = date;
    }

    public String getOrderId() {
        return this.order.getId();
    }

    public OrderRequest getOrder() {
        return this.order;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.order.getRequestDate();
    }
}
