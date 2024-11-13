package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EPromotionStatus {
    NULL_AND_VOID("Promotion is null and void"),
    EFFECTIVE("Promotion is currently effective"),
    COMING_SOON("Promotion will coming soon"),
    USED_OUT("Promotion has been used out"),
    EXPIRED("Promotion has expired");

    // Getter for description
    private final String description;

    // Constructor
    EPromotionStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name();
    }
}

