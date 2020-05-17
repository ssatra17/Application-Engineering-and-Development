/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

/**
 *
 * @author saura
 */
public class LabTestWorkRequest extends WorkRequest{
    
    private String testResult;

    public LabTestWorkRequest(Enterprise enterprise, UserAccount account) {
        super(enterprise, account);
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    
}
