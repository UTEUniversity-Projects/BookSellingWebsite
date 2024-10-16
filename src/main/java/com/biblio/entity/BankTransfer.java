package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import java.io.Serializable;
import java.util.Date;

public class BankTransfer extends Payment implements Serializable {

    //region Attributes
    private String bankAccountNumber;
    private String bankName;
    private String transactionId;
    //endregion

    //region Constructors

    public BankTransfer() {}

    public BankTransfer(String bankAccountNumber, String bankName, String transactionId) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.transactionId = transactionId;
    }

    public BankTransfer(Long id, Date createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency, String bankAccountNumber, String bankName, String transactionId) {
        super(id, createdAt, amount, status, currency);
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.transactionId = transactionId;
    }

    //endregion

    //region Getters & Setters

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    //endregion

    // region Methods
    @Override
    public void processPayment() {

    }
    // endregion Methods
}
