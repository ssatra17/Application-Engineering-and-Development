/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.Pharmacy;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Organization.PharmacyOrganization;
import Business.Role.Role;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author saura
 */
public  class Pharmacy extends HospitalType{
    private int photoId;
    private String id;
    private static int counter = 0;
        private PharmacyCategory category;

    private String photoPath;
      //private static double Pharmacy;

   
    
    public HospitalType.departmenttype getType(){
        return HospitalType.departmenttype.Pharmacy;
    }

    @Override
    public String getID() {
       return this.id;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public enum PharmacyCategory {
           Generalfood, Medicines
            }
    public Pharmacy(String name,String address, String phone){
        super(name,address,phone);
        this.photoId = counter;
        this.id = "Pharmacy" + counter;
        counter++;
        this.setDepartment(HospitalType.departmenttype.Pharmacy);
    }
    
   public ArrayList<Medicines> getGoods() {
        ArrayList<Medicines> result = new ArrayList<Medicines>();
        for (Product product : this.getProduct()) {
            Medicines medicines = (Medicines) product;
            result.add(medicines);
        }
        return result;
    }
   
    public void createOrganizations(){
        this.getOrganizationDirectory().getOrganizationList().add(new PharmacyOrganization());
    }
    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public PharmacyCategory getCategory() {
        return category;
    }

    public void setCategory(PharmacyCategory category) {
        this.category = category;
    }

   
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Pharmacy.counter = counter;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public void addMedicines(Medicines m){
        this.getProduct().add(m);
    }
    @Override
    public double getRate() {
        double totalRate = 0;
        double num = 0;
        for (WorkRequest wr : this.getWorkQueue().getWorkRequestList()) {
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
