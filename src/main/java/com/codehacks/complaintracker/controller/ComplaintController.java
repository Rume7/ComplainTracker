package com.codehacks.complaintracker.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rhume
 */
@RequestScoped
@Named
public class ComplaintController {
    
    @PersistenceContext(unitName = "ComplainTrackerPU")
    EntityManager em;
    
    public void processComplaint() {
        
    }
}
