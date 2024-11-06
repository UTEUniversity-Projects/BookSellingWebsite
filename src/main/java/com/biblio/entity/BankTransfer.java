package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // endregion

    // region Constructors

    public BankTransfer() {
        super();
    }

    public BankTransfer(Long id, LocalDateTime createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency, String bankAccountNumber, String bankName, String transactionId, Order order) {
        super(id, createdAt, amount, status, currency);
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.transactionId = transactionId;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // endregion

    // region Methods

    @Override
    public void processPayment() {

    }

    // endregion Methods
}
