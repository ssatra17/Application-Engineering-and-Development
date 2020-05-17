/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class EcoSystem extends Organization{
    
   private static EcoSystem business;
    private ArrayList<Network> networkList;
    private PatientDirectory patients;
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
        patients= new PatientDirectory();
    
    }

    public boolean isCityAvabliable(String city) {
        for (Network net : this.networkList) {
            if (net.getCity().equalsIgnoreCase(city)) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
   public Network createNetwork(String state) {
        Network network = new Network(state);
        this.networkList.add(network);
        return network;
    }

    public Network getNetworkByCity(String city) {
        for (Network net : this.networkList) {
            if (net.getId().equals(city)) {
                return net;
            }
        }
        return null;
    }

    public PatientDirectory getPatients() {
        return this.patients;
    }
    
    public UserAccount getCustomerAccountByUsername(String username) {
        for(UserAccount account:this.getUserAccountDirectory().getUserAccountList()) {
            if(account.getUserName().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }
    
    public Enterprise getEnterpriseById(String id) {
        for (Network net : this.networkList) {
            for (Enterprise en : net.getEnterpriseDir().getEnterpriseList()) {
                if(en.getID().equals(id)) {
                    return en;
                }
            }
        }
        return null;
    }

    public boolean isUserNameAvaliable(String username) {
        if (this.getUserAccountDirectory().isUsernameValid(username)) {
            for (Network net : this.networkList) {
                for (Enterprise en : net.getEnterpriseDir().getEnterpriseList()) {
                    if (en.getUserAccountDirectory().isUsernameValid(username)) {
                        for (Organization or : en.getOrganizationDirectory().getOrganizationList()) {
                            if (!or.getUserAccountDirectory().isUsernameValid(username)) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    public void removeNetwork(Network net) {
        Network result = null;
        if (!this.networkList.isEmpty()) {
            for (Network n : networkList) {
                if (net.getId().equalsIgnoreCase(n.getId())) {
                    result = n;
                }
            }
            networkList.remove(result);
        }
    }

    
}
