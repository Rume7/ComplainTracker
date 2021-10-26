package com.codehacks.complaintracker.controller;

import com.codehacks.complaintracker.entities.Complaint;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    
    @Inject
    private Complaint complaint;
    
    public ComplaintController() {
        
    }
    
    public Complaint createComplaint() {
        //complaint.setTitle(title);
        
        return null;
    }
    
    public void processComplaint() {
        
        
        
    }
}
