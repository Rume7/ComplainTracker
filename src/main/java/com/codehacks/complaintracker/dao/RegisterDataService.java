package com.codehacks.complaintracker.dao;

import com.codehacks.complaintracker.entities.Registration;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;

/**
 *
 * @author Rhume
 */
@ApplicationScoped
public class RegisterDataService {
    
    @PersistenceContext(unitName = "ComplainTrackerPU")
    EntityManager em;

    @Inject
    Pbkdf2PasswordHash passwordHasher;
    
    @Transactional
    public Registration createUser(String username, String firstname, 
                                        String lastname, String email, String password) {
        String hashedPassword = passwordHasher.generate(password.toCharArray());
        Registration newUser = new Registration(username, firstname, lastname, email, hashedPassword);
        em.persist(newUser);
        em.flush();
        return newUser;
    }
    
    @Transactional
    public Registration registerUser(Registration registration) {
        String hashedPassword = passwordHasher.generate(registration.getPassword().toCharArray());
        registration.setPassword(hashedPassword);
        em.persist(registration);
        em.flush();
        return registration;
    }
    
    
}
