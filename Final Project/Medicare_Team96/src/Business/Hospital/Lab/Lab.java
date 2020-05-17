/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.Lab;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Organization.LabOrganization;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class Lab extends HospitalType{
     private int photoId;
     private LabCatogary category;
    private String id;
    private static int counter = 0;
    private String photoPath;

    public LabCatogary getCategory() {
        return category;
    }

    public void setCategory(LabCatogary category) {
        this.category = category;
    }
    

    public Lab(String name, String phone, String contactNum) {
        super(name, phone, contactNum);
        this.photoId = counter;
        this.id = "Lab" + counter;
        counter++;
        this.setDepartment(HospitalType.departmenttype.Lab);
    }
    public enum LabCatogary {
           Genrallab
            }
     
    @Override
    public String getID() {
       return this.id;
    }

    
    @Override
    public departmenttype getType() {
    return departmenttype.Lab;    
    }
    public void addTest(Test t){
        this.getProduct().add(t);
    }
    public ArrayList<Test> getGoods() {
        ArrayList<Test> result = new ArrayList<Test>();
        for (Product product : this.getProduct()) {
            Test test = (Test) product;
            result.add(test);
        }
        return result;
    }
public void createOrganizations() {
      this.getOrganizationDirectory().getOrganizationList().add(new LabOrganization());
}
    @Override
    public double getRate() {
        double totalRate = 0;
        double num = 0;
        for (WorkRequest wr : this.getWorkQueue() .getWorkRequestList()) {
            OrderRequest order = (OrderRequest) wr;
            if (order.isPrice()) {
                totalRate = totalRate + order.getPrice().getPrice();
                num++;
            }
        }
        if (num == 0) {
            return -1;
        }
        BigDecimal bd = new BigDecimal(totalRate / num);
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    
}
