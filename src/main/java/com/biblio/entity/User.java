package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@MappedSuperclass
public class User implements Serializable {

    //region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, columnDefinition = "nvarchar(255)")
    private String username;

    @Column(name = "full_name", nullable = false, columnDefinition = "nvarchar(255)")
    private String fullName;

    @Column(name = "password", nullable = false, columnDefinition = "nvarchar(255)")
    private String password;

    @Column(name = "email_address", nullable = false, columnDefinition = "nvarchar(255)")
    private String emailAddress;

    @Column(name = "date_of_birth", nullable = false, columnDefinition = "nvarchar(255)")
    private String dateOfBirth;

    @Column(name = "gender", nullable = false, columnDefinition = "nvarchar(255)")
    private String gender;

    @Column(name = "phone_number", nullable = false, columnDefinition = "nvarchar(255)")
    private String phoneNumber;

    @Column(name = "join_at", nullable = false, columnDefinition = "datetime")
    private Timestamp joinAt;

    //endregion

    //region Constructors

    public User() {
    }

    public User(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, String gender, String phoneNumber, Timestamp joinAt) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.joinAt = joinAt;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(Timestamp joinAt) {
        this.joinAt = joinAt;
    }

    // endregion
}
