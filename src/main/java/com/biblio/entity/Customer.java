package com.biblio.entity;

import com.biblio.enumeration.EMembership;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends User implements Serializable {

    // region Attributes

    @Enumerated(EnumType.STRING)
    @Column(name = "membership", nullable = false)
    private EMembership membership;

    // endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "customer_notification",
            joinColumns = @JoinColumn(name = "customer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "notification_id", nullable = false))
    private Set<Notification> notifications = new HashSet<Notification>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<Order>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Support> supports = new HashSet<Support>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<Review>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    // endregion

    // region Constructors

    public Customer() {
        super();
    }

    // endregion

    // region Getters & Setters

    // endregion
}
