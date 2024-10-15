package com.biblio.enumeration;

public enum EOrderStatus {
    WAITING_PAYMENT("Đang chờ thanh toán"),
    PAID("Đã thanh toán"),
    WAITING_CONFIRMATION("Đang chờ xác nhận"),
    PACKING("Đang đóng gói"),
    SHIPPING("Đang giao hàng"),
    COMPLETE_DELIVERY("Đã giao hàng thành công"),
    CANCELED("Đã hủy"),
    REQUEST_REFUND("Yêu cầu hoàn tiền"),
    REFUNDED("Đã hoàn tiền");

    private String description;

    // Constructor
    EOrderStatus(String description) {
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
