package com.biblio.enumeration;

public enum EPromotionStatus {
    NULL_AND_VOID("Promotion is null and void"),
    EFFECTIVE("Promotion is currently effective"),
    USED_OUT("Promotion has been used out"),
    EXPIRED("Promotion has expired");

    private String description;

    // Constructor
    EPromotionStatus(String description) {
        this.description = description;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name() + " (" + description + ")";
    }
}

