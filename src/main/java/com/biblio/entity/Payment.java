package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "payment_type")
public abstract class Payment implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EPaymentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private EPaymentCurrency currency;

    // endregion

    // region Relationships

    @OneToOne(mappedBy = "payment")
    private Order order;

    // endregion

    // region Constructors

    public Payment() {
    }

    public Payment(String id, LocalDateTime createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency) {
        this.id = id;
        this.createdAt = createdAt;
        this.amount = amount;
        this.status = status;
        this.currency = currency;
    }

    // endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
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

    // endregion

    // region Abstract Methods

    public abstract void processPayment();

    // endregion
}
