package com.biblio.entity;

import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EMembership;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Support> supports;

    @ManyToMany(mappedBy = "customers")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "media_file_id")
    private MediaFile avatar;

    // endregion

    // region Constructors

    public Customer() {
        super();
    }

    public Customer(EMembership membership) {
        this.membership = membership;
    }

    public Customer(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, LocalDateTime joinAt, EMembership membership) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, joinAt);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public MediaFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MediaFile avatar) {
        this.avatar = avatar;
    }


    // endregion
}
