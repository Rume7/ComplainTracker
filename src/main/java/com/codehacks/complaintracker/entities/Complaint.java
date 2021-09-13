package com.codehacks.complaintracker.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rhume
 */
@Entity
@Table(name="Complaints")
public class Complaint implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Long id;

    @Column(name="Title")
    private String title;
    
    @Column(name="Description")
    private String description;
    
    @Column(name="Manager")
    private String managerAssigned;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    public Complaint() {}

    public Complaint(String title, String description, String managerAssigned, Date dateCreated) {
        this.title = title;
        this.description = description;
        this.managerAssigned = managerAssigned;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManagerAssigned() {
        return managerAssigned;
    }

    public void setManagerAssigned(String managerAssigned) {
        this.managerAssigned = managerAssigned;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complaint other = (Complaint) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Complaint{" + "id=" + id + '}';
    }
}
