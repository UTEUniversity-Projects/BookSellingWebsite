package com.biblio.entity;

import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EMembership;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Customer extends User implements Serializable {

    //region Attributes
    private Address address;
    private EMembership membership;
    //endregion

    //region Constructors
      public Customer() {
        super();
    }
  
    public Customer(Long id, String userName, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, MediaFile avatar, Date joinAt, Address address, EMembership membership) {
        super(id, userName, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt);
        this.address = address;
        this.membership = membership;
    }
    //endregion

    //region Getters & Setters
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EMembership getMembership() {
        return membership;
    }

    public void setMembership(EMembership membership) {
        this.membership = membership;
    }
    //endregion
}
