package com.biblio.entity;

import com.biblio.enumeration.EWalletProvider;

import java.io.Serializable;

public class EWallet implements Serializable {
    //region Attributes
    private Long walletId;
    private EWalletProvider provider;
    private String transactionId;
    //endregion

    //region Constructors

    public EWallet(Long walletId, EWalletProvider provider, String transactionId) {
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
}
