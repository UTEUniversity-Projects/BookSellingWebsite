package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit_card")
public class CreditCard extends Payment implements Serializable {

    // region Attributes

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_holder_name", nullable = false)
    private String cardHolderName;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(name = "billing_address", nullable = false)
    private String billingAddress;

    // endregion

    // region Relationships

    // endregion

    // region Constructors

    public CreditCard() {
        super();
    }

    public CreditCard(String cardNumber, String cardHolderName, LocalDateTime expirationDate, String cvv, String billingAddress) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }

    public CreditCard(String id, LocalDateTime createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency, String cardNumber, String cardHolderName, LocalDateTime expirationDate, String cvv, String billingAddress) {
        super(id, createdAt, amount, status, currency);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }

    // endregion

    // region Getters & Setters

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    // endregion

    // region Methods

    @Override
    public void processPayment() {

    }

    // endregion
}
