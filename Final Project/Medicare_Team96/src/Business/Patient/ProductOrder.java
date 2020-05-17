/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import java.math.BigDecimal;

/**
 *
 * @author parth
 */
public abstract  class ProductOrder {
    
    private Product product;
    private int quantity;
    private double total;
    private HospitalType department;
    
    public ProductOrder(HospitalType department, Product product, int quantity) {
        this.department = department;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    
     public abstract HospitalType getdepartmentModel();
    
    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalprice() {
         BigDecimal bd = new BigDecimal(product.getPrice() * quantity);
        total = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return total;
    }


    public HospitalType getDepartment() {
        return department;
    }

    public void setDepartment(HospitalType department) {
        this.department = department;
    }
    
     @Override
    public String toString() {
        return this.product.getName();
    }
    
    
    
}
