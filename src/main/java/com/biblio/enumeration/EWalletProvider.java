package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EWalletProvider {
    PAYPAL("PayPal"),
    MOMO("Momo"),
    ZALOPAY("ZaloPay");

    private final String displayName;

    EWalletProvider(String displayName) {
        this.displayName = displayName;
    }

}
