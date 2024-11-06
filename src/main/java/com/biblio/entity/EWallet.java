package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;
import com.biblio.enumeration.EWalletProvider;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ewallet")
public class EWallet extends Payment implements Serializable {

    // region Attributes

    @Column(name = "wallet_id", nullable = false)
    private String walletId;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false)
    private EWalletProvider provider;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    // endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // endregion

    // region Constructors

    public EWallet() {
        super();
    }

    public EWallet(String id, LocalDateTime createdAt, double amount, EPaymentStatus status, EPaymentCurrency currency, String walletId, EWalletProvider provider, String transactionId) {
        super(id, createdAt, amount, status, currency);
        this.walletId = walletId;
        this.provider = provider;
        this.transactionId = transactionId;
    }

    // endregion

    // region Getters & Setters

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public EWalletProvider getProvider() {
        return provider;
    }

    public void setProvider(EWalletProvider provider) {
        this.provider = provider;
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

    // endregion
}
