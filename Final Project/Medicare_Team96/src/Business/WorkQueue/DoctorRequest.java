/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

/**
 *
 * @author saura
 */
public class DoctorRequest extends WorkRequest{
    private String testResult;
       

    public DoctorRequest(Enterprise enterprise, UserAccount account) {
        super(enterprise, account);
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

   
   
    
    
}
