package com.codehacks.complaintracker.controller;

/**
 * @author Rhume
 * @date Sept 7, 2021
 */
import com.codehacks.complaintracker.dao.DataService;
import com.codehacks.complaintracker.entities.Employee;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@Named
public class HomeController {
    
    @Inject
    DataService dataService;
    
    @Inject
    FacesContext facesContext;
    
    private Optional<Employee> currentUser;
    
    public Employee getCurrentUser() {
        return this.currentUser.orElse(null);
    }
    
    public String login() throws ServletException {
        ExternalContext ec = facesContext.getExternalContext();
        ((HttpServletRequest)ec.getRequest()).logout();
        return "app/login.xhtml?faces-redirect=true";
    }
    
    public String registerUser() throws ServletException {
        ExternalContext ec = facesContext.getExternalContext();
        ((HttpServletRequest)ec.getRequest()).logout();
        return "app/register.xhtml?faces-redirect=true";
    }
    
    public String logout() throws ServletException {
        ExternalContext ec = facesContext.getExternalContext();
        ((HttpServletRequest)ec.getRequest()).logout();
        return "/homepage.xhtml?faces-redirect=true";
    }
}
