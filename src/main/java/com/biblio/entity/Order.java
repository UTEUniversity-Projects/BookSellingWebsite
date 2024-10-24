package com.biblio.entity;

import com.biblio.enumeration.EOrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "[order]")
public class Order implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "note", nullable = false)
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EOrderStatus status;

    // endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "order")
    private Set<Promotion> promotions;

    // endregion

    // region Constructors

    public Order() {
    }

    public Order(Long id, String note, EOrderStatus status) {
        this.id = id;
        this.note = note;
        this.status = status;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public EOrderStatus getStatus() {
        return status;
    }

    public void setStatus(EOrderStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }


    // endregion
}
