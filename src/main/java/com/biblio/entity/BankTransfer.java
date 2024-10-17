package com.biblio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "bank_transfer")
public class BankTransfer extends Payment implements Serializable {

    //region Attributes

    @Column(name = "bank_account_number", nullable = false, columnDefinition = "nvarchar(255)")
    private String bankAccountNumber;

    @Column(name = "bank_name", nullable = false, columnDefinition = "nvarchar(255)")
    private String bankName;

    @Column(name = "transaction_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String transactionId;

    //endregion

    //region Constructors

    public BankTransfer() {
        super();
    }

    public BankTransfer(String bankAccountNumber, String bankName, String transactionId) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.transactionId = transactionId;
    }

    public BankTransfer(Long id, Timestamp createdAt, double amount, String status, String currency, String bankAccountNumber, String bankName, String transactionId) {
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
