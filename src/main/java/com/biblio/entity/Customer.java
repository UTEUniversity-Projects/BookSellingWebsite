package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends User implements Serializable {

    // region Attributes

    @Column(name = "membership", nullable = false, columnDefinition = "nvarchar(255)")
    private String membership;

    // endregion

    // region Relationships

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private Set<Support> supports;

    @ManyToMany(mappedBy = "customers")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "customer")
    private Set<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "media_file_id")
    private MediaFile avatar;

    // endregion

    // region Constructors

    public Customer() {
        super();
    }

    public Customer(String membership) {
        this.membership = membership;
    }
    //endregion

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    // endregion
}
