/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class Cart {
 private ArrayList<ProductOrder> productList;
    private double totalPrice;
    
    public Cart(){
        this.productList= new ArrayList<ProductOrder>();
       
    }

    public ArrayList<ProductOrder> getProductList() {
        return productList;
    }

    public double getTotalPrice() {
        totalPrice=0;
        for(ProductOrder p: productList){
            totalPrice= totalPrice+ p.getTotalprice();
        }
        return totalPrice;
    }
    
     public void addToCart(ProductOrder order) {
        this.productList.add(order);
    }
    
    public boolean isCartEmpty() {
        return productList.isEmpty();
    }
     public void clearCart(){
        this.productList = new ArrayList<ProductOrder>();
    }
    
}