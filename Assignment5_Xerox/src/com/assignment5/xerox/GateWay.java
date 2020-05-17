/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analysis.AnalysisHelper;
import com.assignment5.analysis.DataStore;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import java.io.IOException;

/**
 *
 * @author kasai
 */
public class GateWay {
    
    DataReader orderReader;
    DataReader productReader;
    AnalysisHelper helper;
    
    public GateWay() throws IOException {
       
        DataGenerator generator = DataGenerator.getInstance();
        orderReader = new DataReader(generator.getOrderFilePath());
        productReader = new DataReader(generator.getProductCataloguePath());
        helper = new AnalysisHelper();
    }
    
    public static void main(String args[]) throws IOException{
        
        GateWay instance = new GateWay();
        instance.readData();
        
        //DataGenerator generator = DataGenerator.getInstance();
        
        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        
//        DataReader orderReader = new DataReader(generator.getOrderFilePath());
//        String[] orderRow;
//        printRow(orderReader.getFileHeader());
//        while((orderRow = orderReader.getNextRow()) != null){
//            printRow(orderRow);
//        }
//        System.out.println("_____________________________________________________________");
//        DataReader productReader = new DataReader(generator.getProductCataloguePath());
//        String[] prodRow;
//        printRow(productReader.getFileHeader());
//        while((prodRow = productReader.getNextRow()) != null){
//            printRow(prodRow);
//        }
//    }
    
//    public static void printRow(String[] row){
//        for (String row1 : row) {
//            System.out.print(row1 + ", ");
//        }
//        System.out.println("");
  }
    
    private void readData() throws IOException{
        String[] row;
        while((row = orderReader.getNextRow()) != null ){
            Item item = generateItem(row);
            generateOrder(row);
        }
        while((row = productReader.getNextRow()) != null ){
            generateProduct(row);
        }
        runAnalysis();
    }
    
    private void generateOrder(String[] row){
        // TODO
        Item i = generateItem(row);
        int orderID = Integer.parseInt(row[0]);
        int customerId = Integer.parseInt(row[5]);
        int salesId = Integer.parseInt(row[4]);
        //String marketSegment =row[5];
        
        Order order = new Order(orderID,salesId,customerId,i,row[7]);
        DataStore.getInstance().getOrder().put(orderID, order);
    }
    
  
    private void generateProduct(String[] row){
        // TODO
        int prodId = Integer.parseInt(row[0]);
        int min = Integer.parseInt(row[1]);
        int max = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Product prod = new Product(prodId, min, max, targetPrice);
        DataStore.getInstance().getProduct().put(prodId,prod);
    }
    
    private Item generateItem(String[] row){
        // TODO
        int productId = Integer.parseInt(row[2]);
        // Adding item Id
        int ItemId = Integer.parseInt(row[1]);
        int qty = Integer.parseInt(row[3]);
        int sellingPrice = Integer.parseInt(row[6]);
        Item item = new Item(productId,sellingPrice,qty,ItemId);
        DataStore.getInstance().getItem().put(ItemId, item);
        
        return item;
    }
    
    private void runAnalysis(){
        helper.topthreeBestNegotiatedProducts();
        helper.topthreeBestCustomer();
        helper.topthreeSalesPersonsandtotalrevenue();
        helper.adjustedTarget();
    }
}
