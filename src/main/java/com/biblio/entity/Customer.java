package com.biblio.entity;


import com.biblio.enumeration.EGender;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends User implements Serializable {

    // region Attributes

    @Column(name = "membership", nullable = false, columnDefinition = "nvarchar(255)")
    private String membership;

    // endregion

    // region Relationships

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    // endregion

    // region Constructors

    public Customer() {
        super();
    }

    public Customer(String membership) {
        this.membership = membership;
    }

    public Customer(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, String gender, String phoneNumber, Timestamp joinAt, String membership) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, joinAt);
        this.membership = membership;
    }

    // endregion

    // region Getters & Setters

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    // endregion
}
