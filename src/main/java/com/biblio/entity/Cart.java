package com.biblio.entity;

import java.io.Serializable;

public class Cart implements Serializable {
    private String id;
    private Customer customer;
    private OrderItem[] books;

    public Cart() {
    }

    public Cart(String id, Customer customer, OrderItem[] books) {
        this.id = id;
        this.customer = customer;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
