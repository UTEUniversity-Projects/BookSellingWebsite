package com.biblio.enumeration;

public enum EWalletProvider {
    PAYPAL("PayPal"),
    MOMO("Momo"),
    ZALOPAY("ZaloPay");

    private final String displayName;

    EWalletProvider(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
