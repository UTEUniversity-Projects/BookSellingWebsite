package com.biblio.enumeration;

public enum EPaymentCurrency {
    VND("VNĐ"),
    DOLLAR("$");

    private final String displayName;

    EPaymentCurrency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
