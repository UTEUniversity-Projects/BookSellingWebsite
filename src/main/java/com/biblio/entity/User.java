package com.biblio.entity;

import com.biblio.enumeration.EGender;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class User implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private EGender gender;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "join_at", nullable = false)
    private LocalDateTime joinAt;

    // endregion

    // region Constructors

    public User() {
    }

    public User(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, LocalDateTime joinAt) {
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

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(LocalDateTime joinAt) {
        this.joinAt = joinAt;
    }

    // endregion
}
