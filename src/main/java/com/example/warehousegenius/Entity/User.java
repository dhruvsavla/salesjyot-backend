package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"") // Using quotes to escape reserved keyword
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "password")
    private String password;

    @Column(name = "created_on")
    private Date createdOn;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<UserScreenRights> userScreenRights;

    public User () {
        
    }

    public User(Long id, String userName, String userEmail, String userPhone, String password, Date createdOn) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.password = password;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Set<UserScreenRights> getUserScreenRights() {
        return userScreenRights;
    }

    public void setUserScreenRights(Set<UserScreenRights> userScreenRights) {
        this.userScreenRights = userScreenRights;
    }

}
