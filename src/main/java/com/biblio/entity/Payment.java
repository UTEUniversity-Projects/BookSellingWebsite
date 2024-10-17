package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public abstract class Payment implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Timestamp createdAt;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "status", nullable = false, columnDefinition = "nvarchar(255)")
    private String status;

    @Column(name = "currency", nullable = false, columnDefinition = "nvarchar(255)")
    private String currency;

    // endregion

    // region Constructors

    public Payment() {
    }

    public Payment(Long id, Timestamp createdAt, double amount, String status, String currency) {
        this.id = id;
        this.createdAt = createdAt;
        this.amount = amount;
        this.status = status;
        this.currency = currency;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // endregion

    // region Abstract Methods

    public abstract void processPayment();

    // endregion
}
