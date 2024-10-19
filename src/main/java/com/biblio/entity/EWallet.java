package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;
import com.biblio.enumeration.EWalletProvider;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "ewallet")
public class EWallet extends Payment implements Serializable {

    //region Attributes

    @Column(name = "wallet_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String walletId;

    @Column(name = "provider", nullable = false, columnDefinition = "nvarchar(255)")
    private String provider;

    @Column(name = "transaction_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String transactionId;
    //endregion

    //region Constructors

    public EWallet() {
        super();
    }

    public EWallet(String walletId, String provider, String transactionId) {
        this.walletId = walletId;
        this.provider = provider;
        this.transactionId = transactionId;
    }

    public EWallet(Long id, Timestamp createdAt, double amount, String status, String currency, String walletId, String provider, String transactionId) {
        super(id, createdAt, amount, status, currency);
        this.walletId = walletId;
        this.provider = provider;
        this.transactionId = transactionId;
    }

    //endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "id")
    private Order order;

    // endregion

    //region Getters & Setters

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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
    // endregion
}
