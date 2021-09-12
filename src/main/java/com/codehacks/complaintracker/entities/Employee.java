package com.codehacks.complaintracker.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rhume
 */
@Entity
@Table(name="Employee")
@NamedQueries({
    @NamedQuery(name="Employee.all", query="select us from Employee us order by us.id"),
    @NamedQuery(name="Employee.byEmail", query="select us from Employee us where us.email = :email")
})
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="email", nullable=false, unique=true)
    private String email;
    
    @Column(name="Username", nullable=false, unique=true)
    private String username;
    
    @Column(name="Password", nullable=false)
    private String password;
    
    @Column(name="user_group", nullable=false)
    private String user_group;

    public Employee() { }

    public Employee(String email, String username, String password, String user_group) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.user_group = user_group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_group() {
        return user_group;
    }

    public void setUser_group(String user_group) {
        this.user_group = user_group;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + '}';
    }
}
