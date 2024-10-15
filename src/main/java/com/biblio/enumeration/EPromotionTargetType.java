package com.biblio.enumeration;

public enum EPromotionTargetType {
    public enum EPromotionType {
        DISCOUNT("Percentage or fixed amount discount"),
        COUPON("A coupon with a specific code"),
        VOUCHER("A voucher applicable to orders"),
        FREESHIP("Free shipping promotion");

        private String description;

        // Constructor
        EPromotionType(String description) {
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

}
