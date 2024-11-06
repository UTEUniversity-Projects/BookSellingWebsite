package com.biblio.entity;

import com.biblio.enumeration.EOrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "[order]")
public class Order implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false)
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EOrderStatus status;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "order")
    private BankTransfer bankTransfer;

    @OneToOne(mappedBy = "order")
    private CreditCard creditCard;

    @OneToOne(mappedBy = "order")
    private Cash cash;

    @OneToOne(mappedBy = "order")
    private EWallet wallet;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Promotion> promotions = new HashSet<Promotion>();

    // endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    // endregion

    // region Constructors

    public Order() {
    }

    public Order(Long id, String note, EOrderStatus status, Customer customer, BankTransfer bankTransfer, CreditCard creditCard, Cash cash, EWallet wallet, Set<OrderItem> orderItems, Set<Promotion> promotions, Address address) {
        this.id = id;
        this.note = note;
        this.status = status;
        this.customer = customer;
        this.bankTransfer = bankTransfer;
        this.creditCard = creditCard;
        this.cash = cash;
        this.wallet = wallet;
        this.orderItems = orderItems;
        this.promotions = promotions;
        this.address = address;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BankTransfer getBankTransfer() {
        return bankTransfer;
    }

    public void setBankTransfer(BankTransfer bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public EWallet getWallet() {
        return wallet;
    }

    public void setWallet(EWallet wallet) {
        this.wallet = wallet;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // endregion
}
