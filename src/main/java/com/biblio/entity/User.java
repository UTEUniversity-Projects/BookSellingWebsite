package com.biblio.entity;

import com.biblio.enumeration.EGender;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    //region Attributes
    private Long id;
    private String userName;
    private String fullName;
    private String password;
    private String emailAddress;
    private String dateOfBirth;
    private EGender gender;
    private String phoneNumber;
    private MediaFile avatar;
    private Date joinAt;
    //endregion

    //region Contructors

    public User() {}

    public User(Long id, String userName, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, MediaFile avatar, Date joinAt) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.joinAt = joinAt;
    }

    //endregion

    //region Getters & Setters

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

    public MediaFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MediaFile avatar) {
        this.avatar = avatar;
    }

    public Date getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(Date joinAt) {
        this.joinAt = joinAt;
    }

    //endregion
}
