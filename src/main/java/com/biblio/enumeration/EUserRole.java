package com.biblio.enumeration;

public enum EUserRole {
    CUSTOMER("Khách hàng"),
    STAFF("Nhân viên"),
    OWNER("Chủ");


    private final String displayName;

    EUserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
