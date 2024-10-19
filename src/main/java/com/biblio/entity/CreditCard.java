package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "credit_card")
public class CreditCard extends Payment implements Serializable {

    // region Attributes
    @Column(name = "card_number", nullable = false, columnDefinition = "nvarchar(255)")
    private String cardNumber;

    @Column(name = "card_holder_name", nullable = false, columnDefinition = "nvarchar(255)")
    private String cardHolderName;

    @Column(name = "expiration_date", nullable = false, columnDefinition = "datetime")
    private Timestamp expirationDate;

    @Column(name = "cvv", nullable = false, columnDefinition = "nvarchar(255)")
    private String cvv;

    @Column(name = "billing_address", nullable = false, columnDefinition = "nvarchar(255)")
    private String billingAddress;

    // endregion

    // region Constructors

    public CreditCard() {
        super();
    }

    public CreditCard(String cardNumber, String cardHolderName, Timestamp expirationDate, String cvv, String billingAddress) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }

    public CreditCard(Long id, Timestamp createdAt, double amount, String status, String currency, String cardNumber, String cardHolderName, Timestamp expirationDate, String cvv, String billingAddress) {
        super(id, createdAt, amount, status, currency);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }

    // endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "id")
    private Order order;

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

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
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
