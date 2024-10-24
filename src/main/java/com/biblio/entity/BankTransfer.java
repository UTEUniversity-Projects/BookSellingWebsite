package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_transfer")
public class BankTransfer extends Payment implements Serializable {

    // region Attributes

    @Column(name = "bank_account_number", nullable = false)
    private String bankAccountNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    // endregion

    // region Relationships

    // endregion

    // region Constructors

    public BankTransfer() {
        super();
    }

    public BankTransfer(String bankAccountNumber, String bankName, String transactionId) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.transactionId = transactionId;
    }

    public BankTransfer(Long id, LocalDateTime createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency, String bankAccountNumber, String bankName, String transactionId) {
        super(id, createdAt, amount, status, currency);
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.transactionId = transactionId;
    }

    // endregion

    // region Getters & Setters

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

    // endregion

    // region Methods

    @Override
    public void processPayment() {

    }

    // endregion Methods
}
