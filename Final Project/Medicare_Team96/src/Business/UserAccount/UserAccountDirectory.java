/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Patient.Patient;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class UserAccountDirectory {
    
     public ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory(){
        this.userAccountList= new ArrayList<UserAccount>();
        
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    public UserAccount authenticateUser(String username, String password) {
        UserAccount account = null;
        for (UserAccount ua : userAccountList) {
            if (ua.getUserName().equalsIgnoreCase(username) && ua.getPassword().equals(password)) {
                account = ua;
            }
        }
        return account;
    }

    public boolean isUsernameValid(String username) {
        if (userAccountList.isEmpty()) {
            return true;
        }
        for (UserAccount ua : userAccountList) {
            if (ua.getUserName().equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
    }

    public EmployeeAccount createEmployeeAccount(String username, String password, Role role, Employee em) {
        EmployeeAccount ua = new EmployeeAccount(username, password, role, em);
        userAccountList.add(ua);
        return ua;
    }

    public PatientAccount createPatientAccount(String username, String password, Patient patient) {
        PatientAccount ua = new PatientAccount(username, password, patient);
        userAccountList.add(ua);
        return ua;
    }

    public void addAccount(UserAccount account) {
        userAccountList.add(account);
    }

    public ArrayList<EmployeeAccount> toEmployeeAccounts() {
        ArrayList<EmployeeAccount> result = new ArrayList<EmployeeAccount>();
        for (UserAccount ua : this.userAccountList) {
            EmployeeAccount ea = (EmployeeAccount) ua;
            result.add(ea);
        }
        return result;
    }

   
    
    public void removeAccount(UserAccount account) {
        if (this.userAccountList.contains(account)) {
            this.userAccountList.remove(account);
        }
    }
}
