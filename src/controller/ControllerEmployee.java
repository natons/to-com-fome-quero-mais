package controller;

import model.Employee;
import model.dao.EmployeeDAO;

public class ControllerEmployee {
    
    public ControllerEmployee(){
    } 
    
    public boolean authenticate(String login, String password){
        Employee employee = new Employee(login, password);
        
        return new EmployeeDAO().findForObject(employee) != null;
    }
}
