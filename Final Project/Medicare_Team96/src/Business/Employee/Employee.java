/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author saura
 */
public class Employee {
   private int ID;
    private String FirstName;
    private String LastName;
    private String FullName;
    private String ContactNum;
    private String emailID;
    private static int count=0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getContactNum() {
        return ContactNum;
    }

    public void setContactNum(String ContactNum) {
        this.ContactNum = ContactNum;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
    
    

    public Employee(String FirstName, String LastName, String ContactNum, String emailID)   {
        this.FirstName= FirstName;
        this.LastName=LastName;
        this.ContactNum=ContactNum;
        this.emailID=emailID;
        this.FullName= FirstName +" "+ LastName; 
        ID=count;
        count++;
        
    }
    
   @Override
   public String toString(){
    return this.FullName;
}
    
}
