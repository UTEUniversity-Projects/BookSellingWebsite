package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import java.io.Serializable;
import java.util.Date;

public class Cash extends Payment implements Serializable {
    //region Attributes
    private double cashReceived;
    private double change;
    //endregion

    //region Constructors

    public Cash() {}

    public Cash(double cashReceived, double change) {
        this.cashReceived = cashReceived;
        this.change = change;
    }

    public Cash(String id, Date createdAt, EPaymentStatus status, double amount, EPaymentCurrency currency, double cashReceived, double change) {
        super(id, createdAt, status, amount, currency);
        this.cashReceived = cashReceived;
        this.change = change;
    }

    //endregion

    //region Getters & Setters

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

    //endregion

    // region Methods
    @Override
    public void processPayment() {

    }
    // endregion
}
