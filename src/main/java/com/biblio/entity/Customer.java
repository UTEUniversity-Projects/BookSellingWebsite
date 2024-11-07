package com.biblio.entity;

import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EMembership;
import com.biblio.utils.DateTimeUtil;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "customer_notification",
            joinColumns = @JoinColumn(name = "customer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "notification_id", nullable = false))
    private Set<Notification> notifications = new HashSet<Notification>();

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<Order>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Support> supports = new HashSet<Support>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<Review>();

    // endregion

    // region Constructors

    public Customer() {
        super();
    }

    public Customer(Long id, String fullName, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt, EMembership membership, Account account, Set<Notification> notifications, Set<Address> addresses, Set<Order> orders, Cart cart, Set<Support> supports, Set<Review> reviews) {
        super(id, fullName, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt);
        this.membership = membership;
        this.account = account;
        this.notifications = notifications;
        this.addresses = addresses;
        this.orders = orders;
        this.cart = cart;
        this.supports = supports;
        this.reviews = reviews;
    }

    // endregion

    // region Getters & Setters

    public EMembership getMembership() {
        return membership;
    }

    public void setMembership(EMembership membership) {
        this.membership = membership;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatar='" + avatar + '\'' +
                ", joinAt=" + DateTimeUtil.formatDateTime(joinAt, "HH:mm:ss dd/MM/yyyy a") +
                '}';
    }

    // endregion
}
