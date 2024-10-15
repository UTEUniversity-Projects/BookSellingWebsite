package com.biblio.entity;

import java.io.Serializable;

public class CreditCard implements Serializable {
    //region Attributes
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    private String billingAddress;
    //endregion

    //region Constructors

    public CreditCard(String cardNumber, String cardHolderName, String expiryDate, String cvv, String billingAddress) {
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
}
