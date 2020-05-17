/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital.Doctor;

import Business.Enterprise.HospitalType;
import Business.Enterprise.Product;
import Business.Organization.DoctorOrganization;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class Doctor extends HospitalType{
private int photoId;
    private String id;
    private static int counter = 0;
    private String photoPath;
    private String address;
    private DoctorCatogary category;

    
    
    public Doctor(String name, String phone, String contactNum) {
        super(name, phone, contactNum);
        this.photoId = counter;
        this.id = "Doctor" + counter;
        counter++;
        this.setDepartment(HospitalType.departmenttype.Doctor);
    }
    public departmenttype getType(){
        return HospitalType.departmenttype.Doctor;
    }
 public enum DoctorCatogary {
           General,Pediatrician,Neurologist
            }
     public void setCategory(Doctor.DoctorCatogary category) {
        this.category = category;
     }
     
    @Override
    public String getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Appointments> getGoods() {
        ArrayList<Appointments> result = new ArrayList<>();
        for (Product product : this.getProduct()) {
            Appointments Appointments = (Appointments) product;
            result.add(Appointments);
        }
        return result;
    }
    public DoctorCatogary getCategory() {
        return category;
    }
    
    public void addAppointments(Appointments a){
        this.getProduct().add(a);
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
    


    
    public void createOrganizations() {
       this.getOrganizationDirectory().getOrganizationList().add(new DoctorOrganization());

    }

   
    
}
