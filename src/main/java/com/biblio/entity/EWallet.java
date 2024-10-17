package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;
import com.biblio.enumeration.EWalletProvider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    //region Getters & Setters

    //endregion

    // region Methods
    @Override
    public void processPayment() {

    }
    // endregion
}
