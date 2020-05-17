/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class CustomerDirectory {
 private ArrayList<Customer> custDir;
 public CustomerDirectory()
    {
    custDir = new ArrayList<>();

    }

    public ArrayList<Customer> getCustDir() {
        return custDir;
    }

    public void setCustDir(ArrayList<Customer> custDir) {
        this.custDir = custDir;
    }
    
    public Customer addData(){
     Customer c= new Customer();
     custDir.add(c);
     return c;
 }
  public void removeCustomer(Customer c){
        custDir.remove(c);
    }

}
