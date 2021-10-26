package com.codehacks.complaintracker.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rhume
 */
@ApplicationScoped
public class ComplaintDataService {
    
    @PersistenceContext(unitName = "ComplainTrackerPU")
    EntityManager em;
    
}
