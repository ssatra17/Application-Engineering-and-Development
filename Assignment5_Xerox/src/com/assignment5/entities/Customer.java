/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

import java.util.List;

/**
 *
 * @author kasai
 */
public class Customer {
    private int id;
    public List<Item> item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "id = " + id + ", no. of products = " + item.size() + '}';
    }
    
}
