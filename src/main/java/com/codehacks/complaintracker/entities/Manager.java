package com.codehacks.complaintracker.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rhume
 */
public class Manager implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private Long id;
    
    @Column(name="email", nullable=false, unique=true)
    private String email;
    
    @Column(name="Username", nullable=false, unique=true)
    private String username;
    
    @Column(name="Password", nullable=false)
    private String password;
    
    @Column(name="user_group", nullable=false)
    private Position position;

    public Manager() { }

    public Manager(String email, String username, String password, Position position) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Manager other = (Manager) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Manager {" + "id=" + id + '}';
    }
}
