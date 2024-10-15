package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable {
    //region Attributes
    private String id;
    private Order order;
    private Date createdAt;
    private double amount;
    private EPaymentStatus status;
    private EPaymentCurrency currency;
    //endregion

    //region Constructors

    public Payment(String id, Order order, Date createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency) {
        this.id = id;
        this.order = order;
        this.createdAt = createdAt;
        this.amount = amount;
        this.status = status;
        this.currency = currency;
    }

    //endregion

    //region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public EPaymentStatus getStatus() {
        return status;
    }

    public void setStatus(EPaymentStatus status) {
        this.status = status;
    }

    public EPaymentCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(EPaymentCurrency currency) {
        this.currency = currency;
    }

    //endregion
}
