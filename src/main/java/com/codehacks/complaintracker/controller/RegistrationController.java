package com.codehacks.complaintracker.controller;

import com.codehacks.complaintracker.dao.RegisterDataService;
import com.codehacks.complaintracker.entities.Registration;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
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
    SecurityContext securityContext;

    @Inject
    FacesContext facesContext;

    private Registration registeredUser;

    @NotEmpty
    private String username;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @NotEmpty
    private String emailAddress;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

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
            registeredUser = new Registration(username, firstname, lastname, emailAddress, password);
            registerDataService.registerUser(registeredUser);
            return "/app/complaintpage.xhtml?faces-redirect=true";
        }
        return "/register.xhtml?faces-redirect=true";
    }
}
