package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import java.io.Serializable;
import java.util.Date;

public class CreditCard extends Payment implements Serializable {
    //region Attributes
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    private String billingAddress;
    //endregion

    //region Constructors

    public CreditCard() {
        super();
    }

    public CreditCard(String cardNumber, String cardHolderName, String expiryDate, String cvv, String billingAddress) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }

    public CreditCard(String id, Date createdAt, EPaymentStatus status, double amount, EPaymentCurrency currency, String cardNumber, String cardHolderName, String expiryDate, String cvv, String billingAddress) {
        super(id, createdAt, status, amount, currency);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }

    //endregion

    //region Getters & Setters

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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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

    //endregion

    // region Methods
    @Override
    public void processPayment() {

    }
    // endregion
}
