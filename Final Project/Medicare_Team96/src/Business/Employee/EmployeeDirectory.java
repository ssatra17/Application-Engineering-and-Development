/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author saura
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;
    
    public EmployeeDirectory(){
        employeeList=new ArrayList<Employee>();
    } 

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
public boolean isEmployeeExists(Employee e){
    if(!this.employeeList.isEmpty()){
        for (Employee em: this.employeeList){
            if(em.getID()==e.getID()){
                return true;
            }
        }
    }return false;
}   
public Employee createEmployee(String FirstName, String LastName, String ContactNum, String emailID){
    Employee employee= new Employee(FirstName, LastName,ContactNum, emailID);
    employeeList.add(employee);
    return employee;
} 
}