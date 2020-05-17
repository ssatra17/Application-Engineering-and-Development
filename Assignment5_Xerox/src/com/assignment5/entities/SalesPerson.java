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
public class SalesPerson {
    
    private int salesPersonId;
    private List<Item> solditems;

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public List<Item> getSolditems() {
        return solditems;
    }

    public void setSolditems(List<Item> solditems) {
        this.solditems = solditems;
    }
    
    @Override
    public String toString()
    {
        return "SalesPersonId is :"+salesPersonId+" the total number of Items sold is : "+solditems.size();
    }
    
}
