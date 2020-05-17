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
public class Product {
    int prodID;
    int minPrice;
    int maxPrice;
    int targetPrice;
    private int totalQuantity;
    private int totalSalesPrice;
    private double avgSalesPrice;
    private double adjustedTargetPrice;
    private double error;
    private int Quantitysold;

    public Product(int prodID, int minPrice, int maxPrice, int targetPrice) {
        this.prodID = prodID;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.targetPrice = targetPrice;
        
        this.totalQuantity = 0;
        this.totalSalesPrice = 0;
        this.avgSalesPrice = 0;
        this.adjustedTargetPrice = 0;
        this.error = 0;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalSalesPrice() {
        return totalSalesPrice;
    }

    public void setTotalSalesPrice(int totalSalesPrice) {
        this.totalSalesPrice = totalSalesPrice;
    }

    public double getAvgSalesPrice() {
        return avgSalesPrice;
    }

    public void setAvgSalesPrice(double avgSalesPrice) {
        this.avgSalesPrice = avgSalesPrice;
    }

    public double getAdjustedTargetPrice() {
        return adjustedTargetPrice;
    }

    public void setAdjustedTargetPrice(double adjustedTargetPrice) {
        this.adjustedTargetPrice = adjustedTargetPrice;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public int getQuantitysold() {
        return Quantitysold;
    }

    public void setQuantitysold(int Quantitysold) {
        this.Quantitysold = Quantitysold;
    }
    
    
}
