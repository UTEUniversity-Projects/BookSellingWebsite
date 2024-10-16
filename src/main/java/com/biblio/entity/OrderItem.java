package com.biblio.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {

    private int id;
    private Customer customer;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(int id, Customer customer, int quantity) {
        this.id = id;
        this.customer = customer;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
