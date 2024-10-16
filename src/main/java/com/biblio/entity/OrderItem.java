package com.biblio.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {

    //region Attributes
    private int id;
    private Customer customer;
    private int quantity;
    //endregion

    //region Constructors
    public OrderItem() {
    }

    public OrderItem(int id, Customer customer, int quantity) {
        this.id = id;
        this.customer = customer;
        this.quantity = quantity;
    }
    //endregion

    //region Getters & Setters
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
    //endregion
}
