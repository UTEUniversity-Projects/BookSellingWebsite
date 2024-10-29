package com.biblio.enumeration;

public enum EPromotionType {
    DISCOUNT("Discount"),
    COUPON("Coupon"),
    VOUCHER("Voucher"),
    FREESHIP("Free Shipping");

    private final String description;

    EPromotionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

