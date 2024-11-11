package com.biblio.enumeration;

public enum EGender {
    MALE("Nam"),
    FEMALE("Nữ");

    private final String displayName;

    EGender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
