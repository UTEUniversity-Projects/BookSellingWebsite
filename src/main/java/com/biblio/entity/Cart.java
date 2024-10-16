package com.biblio.entity;

import java.io.Serializable;

public class Cart implements Serializable {

    //region Attributes
    private Long id;
    private Customer customer;
    private OrderItem[] books;
    //endregion

    //region Constructors
    public Cart() {
    }

    public Cart(Long id, Customer customer, OrderItem[] books) {
        this.id = id;
        this.customer = customer;
        this.books = books;
    }
    //endregion

    //region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderItem[] getBooks() {
        return books;
    }

    public void setBooks(OrderItem[] books) {
        this.books = books;
    }
    //endregion
}
