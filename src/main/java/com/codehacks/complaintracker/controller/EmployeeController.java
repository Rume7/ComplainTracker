package com.codehacks.complaintracker.controller;

/**
 * @author Rhume
 * @date Sept 7, 2021
 */

import com.codehacks.complaintracker.dao.DataService;
import com.codehacks.complaintracker.entities.Employee;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class EmployeeController {
    
    @Inject
    DataService dataService;
    
    private List<Employee> allEmployees;
    
    //@PostConstruct
    public void initialize() {
        this.allEmployees = dataService.getAllEmployees();
    }

    public List<Employee> getAllEmployees() {
        return allEmployees;
    }
    
    public Employee getEmployee(String emailAddress) {
        return dataService.getAnEmployee(emailAddress).get();
    }
    
    public String getEmployeeUsername(String emailAddress) {
        return getEmployee(emailAddress).getUsername();
    }
}
