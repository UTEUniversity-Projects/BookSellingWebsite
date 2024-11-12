package com.biblio.enumeration;

import lombok.Getter;

@Getter
public enum EPromotionType {
    DISCOUNT("Discount"),
    COUPON("Coupon"),
    VOUCHER("Voucher"),
    FREESHIP("Free Shipping");

    private final String description;

    EPromotionType(String description) {
        this.description = description;
    }

}

