package com.biblio.entity;

import com.biblio.enumeration.EOrderStatus;

import java.io.Serializable;

public class Order implements Serializable {

    //region Attributes
    private Long id;
    private OrderItem[] books;
    private Customer customer;
    private Address shippingAddress;
    private Promotion[] promotions;
    private Payment payment;
    private String note;
    private EOrderStatus status;
    //endregion

    //region Constructors
    public Order() {
    }
  
    public Order(Long id, OrderItem[] books, Customer customer, Address shippingAddress, Promotion[] promotions, Payment payment, String note, EOrderStatus status) {

        this.id = id;
        this.books = books;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.promotions = promotions;
        this.payment = payment;
        this.note = note;
        this.status = status;
    }
    //endregion

    //region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItem[] getBooks() {
        return books;
    }

    public void setBooks(OrderItem[] books) {
        this.books = books;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Promotion[] getPromotions() {
        return promotions;
    }

    public void setPromotions(Promotion[] promotions) {
        this.promotions = promotions;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
    //endregion
}
