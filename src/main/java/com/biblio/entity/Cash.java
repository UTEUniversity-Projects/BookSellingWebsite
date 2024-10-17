package com.biblio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "cash")
public class Cash extends Payment implements Serializable {

    // region Attributes

    @Column(name = "cash_received", nullable = false)
    private double cashReceived;

    @Column(name = "change", nullable = false)
    private double change;

    // endregion

    // region Constructors

    public Cash() {
        super();
    }

    public Cash(double cashReceived, double change) {
        this.cashReceived = cashReceived;
        this.change = change;
    }

    public Cash(Long id, Timestamp createdAt, double amount, String status, String currency, double cashReceived, double change) {
        super(id, createdAt, amount, status, currency);
        this.cashReceived = cashReceived;
        this.change = change;
    }

    // endregion

    // region Getters & Setters

    public double getCashReceived() {
        return cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    // endregion

    //  region Methods
    @Override
    public void processPayment() {

    }
    // endregion
}
