package com.biblio.enumeration;

public enum EClassificationStatus {
    ACTIVE("Hoạt động"),
    INACTIVE("Không hoạt động");

    private final String status;

    EClassificationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
