package com.codehacks.complaintracker.controller;

import com.codehacks.complaintracker.dao.DataService;
import com.codehacks.complaintracker.dao.RegisterDataService;
import com.codehacks.complaintracker.entities.Employee;
import com.codehacks.complaintracker.entities.Registration;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Rhume
 */
@RequestScoped
@Named
public class RegistrationController {

    @Inject
    RegisterDataService registerDataService;
    
    @Inject 
    DataService dataService;

    @Inject
    FacesContext facesContext;

    @Inject
    Registration registeredUser;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String submit() throws ServletException {
        if (getPassword().equals(getConfirmPassword())) {
            registeredUser = new Registration(registeredUser.getUsername(), 
                    registeredUser.getFirstname(), registeredUser.getLastname(),
                    registeredUser.getEmailAddress(), registeredUser.getPassword());
            registerDataService.registerUser(registeredUser);
            Employee user = new Employee(registeredUser.getEmailAddress(), 
                    registeredUser.getUsername(), registeredUser.getPassword(), "Regular");
            dataService.createEmployee(user);
            return "/app/login.xhtml?faces-redirect=true";
        }
        return "/register.xhtml?faces-redirect=true";
    }
}
