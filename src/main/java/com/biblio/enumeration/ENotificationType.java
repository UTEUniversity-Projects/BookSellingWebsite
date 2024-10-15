package com.biblio.enumeration;

public enum ENotificationType {
    ORDER("Order"),
    SUPPORT("Support"),
    SYSTEM("System"),
    OTHER("Other");

    private final String displayName;

    ENotificationType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
