package com.biblio.entity;

import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EMembership;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "address_id", nullable = false))
    private Set<Address> addresses = new HashSet<Address>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<Order>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Support> supports = new HashSet<Support>();

    @ManyToMany(mappedBy = "customers")
    private Set<Notification> notifications = new HashSet<Notification>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<Review>();

    // endregion

    // region Constructors

    public Customer() {
        super();
    }

    public Customer(String id, String username, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt, EMembership membership) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt);
        this.membership = membership;
    }

    // endregion

    // region Getters & Setters

    public EMembership getMembership() {
        return membership;
    }

    public void setMembership(EMembership membership) {
        this.membership = membership;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Support> getSupports() {
        return supports;
    }

    public void setSupports(Set<Support> supports) {
        this.supports = supports;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    // endregion
}
