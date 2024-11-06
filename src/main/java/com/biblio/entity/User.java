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
    private Long id;

    @Column(name = "full_name", nullable = false)
    protected String fullName;

    @Column(name = "email_address", nullable = false)
    protected String emailAddress;

    @Column(name = "date_of_birth", nullable = false)
    protected String dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    protected EGender gender;

    @Column(name = "phone_number", nullable = false)
    protected String phoneNumber;

    @Column(name = "avatar", nullable = false)
    protected String avatar;

    @Column(name = "join_at", nullable = false)
    protected LocalDateTime joinAt;

    // endregion

    // region Relationships

    // endregion

    // region Constructors

    public User() {
    }

    public User(Long id, String fullName, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt) {
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(LocalDateTime joinAt) {
        this.joinAt = joinAt;
    }

    // endregion
}
