package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "cash")
public class Cash extends Payment implements Serializable {

    // region Attributes

    @Column(name = "cash_received", nullable = false)
    private double cashReceived;

    @Column(name = "[change]", nullable = false)
    private double change;

    // endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // endregion

    // region Constructors

    public Cash() {
        super();
    }

    public Cash(double cashReceived, double change) {
        this.cashReceived = cashReceived;
        this.change = change;
    }

    public Cash(Long id, LocalDateTime createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency, double cashReceived, double change, Order order) {
        super(id, createdAt, amount, status, currency);
        this.cashReceived = cashReceived;
        this.change = change;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // endregion

    //  region Methods

    @Override
    public void processPayment() {

    }

    // endregion
}
