package com.ffryczek.user_validator.Entity;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID userID;
    @Column(name="email",nullable=false,unique=true)
    private String email;
    @Column(name="password_hash",nullable=false)
    private String passwordHash;
    @Column(name="username",nullable=false,unique=true)
    private String userName;

    //Empty constructor
    public User() {

    }

    //GETTERS
    public String getUserName() {
        return this.userName;
    }

    public UUID getID() {
        return this.userID;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    //SETTERS
    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPasswordHash(String newPasswordHash) {
        this.passwordHash = newPasswordHash;
    }

    
}
