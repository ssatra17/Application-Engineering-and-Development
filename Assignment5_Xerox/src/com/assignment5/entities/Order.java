/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kasai
 */
public class Order {
    
    int orderId;
    int supplierId;
    int customerId;
    String marketSegment;
    Item item;
    List<Item> item1;

    public List<Item> getItem1() {
        return item1;
    }

    public void setItem1(List<Item> item1) {
        this.item1 = item1;
    }

    

    public Order(int orderId, int supplierId, int customerId, Item item,String marketSegment) {
        this.orderId = orderId;
        this.supplierId = supplierId;
        this.customerId = customerId;
        this.item = item;
        this.marketSegment = marketSegment;
        this.item1 = new ArrayList<>();
        
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    public String getMarketSegment() {
        return marketSegment;
    }

    public void setMarketSegment(String marketSegment) {
        this.marketSegment = marketSegment;
    }
}
