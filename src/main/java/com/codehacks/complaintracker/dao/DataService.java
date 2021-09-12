package com.codehacks.complaintracker.dao;

import com.codehacks.complaintracker.entities.Employee;
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
        User newUser = new User(email, username, hashedPassword, group);
        em.persist(newUser);
        em.flush();
        return newUser;
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        String hashedPassword = passwordHasher.generate(employee.getPassword().toCharArray());
        employee.setPassword(hashedPassword);
        em.persist(employee);
        em.flush();
        return employee;
    }
    
    public List<Employee> getAllEmployees() {
        List<Employee> allUsers = em.createNamedQuery("Employee.all", Employee.class).getResultList();
        return allUsers;
    }
    
    public Optional<Employee> getAnEmployee(String email) {
        Optional<Employee> user = em.createNamedQuery("Employee.byEmail", Employee.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst();
        return user;
    }
}
