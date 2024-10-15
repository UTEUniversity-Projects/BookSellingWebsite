package com.biblio.entity;

import java.io.Serializable;

public class BankTransfer implements Serializable {
    //region Attributes
    private String bankAccountNumber;
    private String bankName;
    private String transactionId;
    //endregion

    //region Constructors

    public BankTransfer(String bankAccountNumber, String bankName, String transactionId) {
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
}
