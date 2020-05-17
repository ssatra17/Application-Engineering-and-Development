/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author parth
 */
public class Patient {
    private int id;
    private String FirstName;
    private String LastName;
    private String FullName;
    private String address;
    private String ContactNum;
    private String emailID;
    private static int counter =0;
    
public Patient(String FirstName, String LastName, String ContactNum, String emailID){
    this.FirstName=FirstName;
    this.LastName=LastName;
    this.address="";
    this.ContactNum=ContactNum;
    this.emailID=emailID;
    this.FullName=FirstName+ " " + LastName;
    id=counter;
    counter++;
    
    
}    

    public int getId() {
        return id;
    }
    public void setName(String FirstName,String LastName){
        this.FirstName=FirstName;
        this.LastName=LastName;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Patient.counter = counter;
    }

}

