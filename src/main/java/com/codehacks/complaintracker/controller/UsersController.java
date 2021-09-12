package com.codehacks.complaintracker.controller;

/**
 * @author Rhume
 * @date Sept 7, 2021
 */

import com.codehacks.complaintracker.dao.DataService;
import com.codehacks.complaintracker.entities.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class UsersController {
    
    @Inject
    DataService dataService;
    
    private List<User> allUsers;
    
    @PostConstruct
    public void initialize() {
        this.allUsers = dataService.getAllUsers();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }
}
