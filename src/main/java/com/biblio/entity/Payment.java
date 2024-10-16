package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import java.io.Serializable;
import java.util.Date;

public abstract class Payment implements Serializable {
    //region Attributes
    private String id;
    private Date createdAt;
    private double amount;
    private EPaymentStatus status;
    private EPaymentCurrency currency;
    //endregion

    //region Constructors

    public Payment() {}

    public Payment(String id, Date createdAt, EPaymentStatus status, double amount, EPaymentCurrency currency) {
        this.id = id;
        this.createdAt = createdAt;
        this.status = status;
        this.amount = amount;
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

    //region Abstract Methods
    public abstract void processPayment();
    //endregion
}
