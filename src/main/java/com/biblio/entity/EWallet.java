package com.biblio.entity;

import com.biblio.enumeration.EPaymentCurrency;
import com.biblio.enumeration.EPaymentStatus;
import com.biblio.enumeration.EWalletProvider;

import java.io.Serializable;
import java.util.Date;

public class EWallet extends Payment implements Serializable {
    //region Attributes
    private Long walletId;
    private EWalletProvider provider;
    private String transactionId;
    //endregion

    //region Constructors

   public EWallet() {
        super();
    }
    public EWallet(Long walletId, EWalletProvider provider, String transactionId) {
        this.walletId = walletId;
        this.provider = provider;
        this.transactionId = transactionId;
    }

    public EWallet(String id, Date createdAt, EPaymentStatus status, double amount, EPaymentCurrency currency, String walletId, EWalletProvider provider, String transactionId) {
        super(id, createdAt, status, amount, currency);
        this.walletId = walletId;
        this.provider = provider;
        this.transactionId = transactionId;
    }

    //endregion

    //region Getters & Setters

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
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


    //endregion

    // region Methods
    @Override
    public void processPayment() {

    }
    // endregion
}
