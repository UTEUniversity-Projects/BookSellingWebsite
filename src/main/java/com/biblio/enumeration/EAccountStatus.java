package com.biblio.enumeration;

public enum EAccountStatus {
    ACTIVE("Hoạt động"),
    INACTIVE("Bị cấm");

    private final String value;

    EAccountStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
