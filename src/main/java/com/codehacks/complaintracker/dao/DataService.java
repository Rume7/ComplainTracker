package com.codehacks.complaintracker.dao;

import com.codehacks.complaintracker.entities.User;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;

/**
 * @author Rhume
 * @date Sept 7, 2021
 */

@ApplicationScoped
public class DataService {

    @PersistenceContext(unitName = "ComplainTrackerPU")
    EntityManager em;

    @Inject
    Pbkdf2PasswordHash passwordHasher;
    
    @Transactional
    public User createUser(String email, String username, String password, String group) {
        String hashedPassword = passwordHasher.generate(password.toCharArray());
        //hashedPassword = hashedPassword.substring(25);
        User newUser = new User(email, username, hashedPassword, group);
        em.persist(newUser);
        em.flush();
        return newUser;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = em.createNamedQuery("User.all", User.class).getResultList();
        return allUsers;
    }
    
    public Optional<User> getUser(String email) {
        Optional<User> user = em.createNamedQuery("User.byEmail", User.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst();
        return user;
    }
}
