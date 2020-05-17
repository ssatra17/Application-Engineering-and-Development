/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class PatientDirectory {
    private ArrayList<Patient> patientList;
    
    public PatientDirectory(){
        patientList= new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }
    
    public void addPatient(String FirstName, String LastName, String ContactNum, String emailID,String address){
        Patient patient= new Patient(FirstName, LastName, ContactNum, emailID);
        patient.setName(FirstName, LastName);
        patient.setEmailID(emailID);
        patient.setContactNum(ContactNum);
        patient.setAddress(address);
        patientList.add(patient);
        
    }
    public Patient createPatient(String FirstName, String LastName, String ContactNum, String emailID){
        Patient patient= new Patient(FirstName, LastName, ContactNum, emailID);
        this.patientList.add(patient);
        return patient;
    }
    
}
