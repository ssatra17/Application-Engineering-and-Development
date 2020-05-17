/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analysis;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author saura
 */
public class AnalysisHelper {
    
     public void topthreeBestNegotiatedProducts() {
       Map<Integer, Integer> topproducts = new HashMap<Integer, Integer>();
       Map<Integer, Item> item = DataStore.getInstance().getItem();
       Map<Integer, Product> prod = DataStore.getInstance().getProduct();
        
        for (Item i : item.values()) {
           
             if(i.getSalesPrice() > prod.get(i.getProductId()).getTargetPrice()) {
                //Check if prodid from Item is present in Product map
                //Prod is the map. map.get = prod.get
                 if (topproducts.containsKey(i.getProductId()))
                {
                  int quantity = topproducts.get(i.getProductId());
                topproducts.put(i.getProductId(), (quantity + i.getQuantity()));
                }
                else {
                topproducts.put(i.getProductId(), i.getQuantity());
            }

            } 
        }
          //System.out.println("top product map: "+topproducts.values());
         List<Map.Entry<Integer, Integer>> entrylist = new ArrayList<Map.Entry<Integer, Integer>>(topproducts.entrySet());
        
        Collections.sort(entrylist, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> p1,
                               Map.Entry<Integer, Integer> p2)
            {     
               // System.out.println(o1.getValue());
                return (p2.getValue()).compareTo(p1.getValue());
            }
           
             
        });
        
        System.out.println("-------------------------------------------------------------------");
        System.out.println(" Product ID & Quantity: " + entrylist);
        System.out.println("\n \n Top 3 Products according to the quantity are as below:");
        
        for(int j = 0;j<3;j++){
            System.out.println("\n Product: " +entrylist.get(j)+" ");
        }

      }
      public void topthreeBestCustomer() {
       LinkedHashMap<Integer, Integer> top3customers = new LinkedHashMap<Integer, Integer>();
       Map<Integer, Order> order = DataStore.getInstance().getOrder();
       Map<Integer, Product> prod = DataStore.getInstance().getProduct();
       
       for(Order o:order.values()){
           if(top3customers.containsKey(o.getCustomerId())){
               int sumOfDiff = top3customers.get(o.getCustomerId());
               top3customers.put(o.getCustomerId(),sumOfDiff +Math.abs((o.getItem().getSalesPrice() - prod.get(o.getItem().getProductId()).getTargetPrice())));
                       }
           else{
               //Map.get - so we are getting the target price from Product map so we have to traverse through it to get the target price
             top3customers.put(o.getCustomerId(),Math.abs((o.getItem().getSalesPrice() - prod.get(o.getItem().getProductId()).getTargetPrice())));
           }
       }
       
       List<Map.Entry<Integer, Integer>> entrylist = new ArrayList<Map.Entry<Integer, Integer>>(top3customers.entrySet());
        
        Collections.sort(entrylist, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> c1,
                               Map.Entry<Integer, Integer> c2)
            {     
               // System.out.println(o1.getValue());
                return (c1.getValue()).compareTo(c2.getValue());
            }
           
             
        });
        
        System.out.println("-------------------------------------------------------------------");
        System.out.println(" Customer ID & Differnce: " + entrylist);
        System.out.println("\n \n Top 3 Customers according to the closest buying price are:");
        
        for(int j = 0;j<3;j++){
            System.out.println("\n Customer: " +entrylist.get(j)+" ");
        }
          
    }
      
      public void topthreeSalesPersonsandtotalrevenue() {
        LinkedHashMap<Integer, Integer> top3salePerson = new LinkedHashMap<Integer, Integer>();
        Map<Integer, Order> order = DataStore.getInstance().getOrder();
        Map<Integer, Product> prod = DataStore.getInstance().getProduct();

        
        
        for (Order salesPerson : order.values()) {
            if (top3salePerson.containsKey(salesPerson.getSupplierId())) {
                int profit = top3salePerson.get(salesPerson.getSupplierId());
                int revenue = salesPerson.getItem().getQuantity();
                top3salePerson.put(salesPerson.getSupplierId(), profit + ((salesPerson.getItem().getSalesPrice() - prod.get(salesPerson.getItem().getProductId()).getTargetPrice())) * revenue);
            } else {
                //Map.get - so we are getting the target price from Product map so we have to traverse through it to get the target price
                int revenue = salesPerson.getItem().getQuantity();
                top3salePerson.put(salesPerson.getSupplierId(), ((salesPerson.getItem().getSalesPrice() - prod.get(salesPerson.getItem().getProductId()).getTargetPrice())) * revenue);
            }
        }

        List<Map.Entry<Integer, Integer>> entrylist = new ArrayList<Map.Entry<Integer, Integer>>(top3salePerson.entrySet());

        Collections.sort(entrylist, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> s1,
                    Map.Entry<Integer, Integer> s2) {
                // System.out.println(o1.getValue());
                return (s2.getValue()).compareTo(s1.getValue());
            }

        });

        System.out.println("-------------------------------------------------------------------");
        System.out.println(" Sales ID & Differnce: " + entrylist);
        System.out.println("\n \n Top 3 Sales Person according to the profit are:\n");
        
        for (int j = 0; j < 3; j++) {
            System.out.println("\n Sales Person: " + entrylist.get(j) + " ");
        }
        System.out.println("-------------------------------------------------------------------");

        //For total profit of the year 
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : top3salePerson.entrySet()) {
            if (entry.getValue() > 0) {
                sum = sum + entry.getValue();
            }
        }

        System.out.println("Total Profit is = " + sum);

    }
      
      
      public void adjustedTarget(){
        Map<Integer, Product> product = DataStore.getInstance().getProduct();
        Map<Integer, Item> item = DataStore.getInstance().getItem();
        
        
        int i = 0;
        for (Item items : item.values()){
           int prodID = items.getProductId();
           for (Product p: product.values()){
               if (p.getProdID()== prodID){
                   p.setTotalQuantity(p.getTotalQuantity() + items.getQuantity());
                   p.setTotalSalesPrice(p.getTotalSalesPrice()+ (items.getQuantity() * items.getSalesPrice()) );
                   try {
                       p.setAvgSalesPrice(p.getTotalSalesPrice()/p.getTotalQuantity());
                   }
                   catch (ArithmeticException e){
                       System.out.println("p.getTotalSalesPrice() = " + p.getTotalSalesPrice() + "p.getTotalQuantity() = " +p.getTotalQuantity());
                   }
                   int targetPrice = p.getTargetPrice();
                   double avgPrice = p.getAvgSalesPrice();
                   
                   
         //          System.out.println("p.getTotalSalesPrice() = " + p.getTotalSalesPrice() + "   p.getTotalQuantity() = " +p.getTotalQuantity());
           //        System.out.println(" p.getAvgSalesPrice(): " +  p.getAvgSalesPrice() + " prod ID :" + p.getProductID());
                   
                   
                   if(targetPrice < (avgPrice - (0.05*avgPrice)))
                        {
                            p.setAdjustedTargetPrice((avgPrice - (0.05*avgPrice)));
                         
                        }
                   else if(targetPrice > (avgPrice + (0.05*avgPrice)))
                        {
                            p.setAdjustedTargetPrice((avgPrice + (0.05*avgPrice)));
                        }
                   else {
                            p.setAdjustedTargetPrice(targetPrice);
                        }
                   double error = ((p.getAdjustedTargetPrice() - p.getAvgSalesPrice())/p.getAvgSalesPrice())*100; 
                   p.setError(error);
                   
               }
           }
           
           
        }
        
        
 
        
        System.out.printf("%10s %10s %10s %10s ", "PRODUCT ID |", "AVG PRICE |", "TARGET PRICE |", "DIFFERENCE | ");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Product products: product.values()){
            
            System.out.format("%10s %10s %10s %15s",
                products.getProdID(), products.getAvgSalesPrice(), products.getTargetPrice(), products.getAvgSalesPrice() - products.getTargetPrice());
            System.out.println();
            
        }
      
        System.out.println("----------------------MODIFIED TABLE----------------");
       
        System.out.printf("%10s %10s %10s %10s %10s", "PRODUCT ID |", "AVG PRICE |", "MODIFIED TARGET PRICE |", "DIFFERENCE |" ,"ERROR OF MODIFED PRICE");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Product products: product.values()){
        
            System.out.format("%10s %10s %15s %18.2f %15.2f%%",
                products.getProdID(), products.getAvgSalesPrice(), products.getAdjustedTargetPrice(), products.getAvgSalesPrice() - products.getAdjustedTargetPrice(),
                products.getError());
            System.out.println();
            
        }
       
}
 


}