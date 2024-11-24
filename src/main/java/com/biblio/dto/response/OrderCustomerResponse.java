package com.biblio.dto.response;

import com.biblio.entity.*;
import com.biblio.enumeration.EOrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderCustomerResponse {
    private Long id;
    private String note;
    private LocalDateTime orderDate;
    private String paymentType;
    private String status;
    private Double vat;
    private Long customerId;
    private Long shippingId;
    private String customerName;
    private Set<OrderItem> lineItems;
    private Set<Promotion> promotions = new HashSet<>();
    private Order order;
    private String address;
    private  String email;

    public OrderCustomerResponse(Long id, String note, LocalDateTime orderDate, String paymentType, String status, Double vat, Long customerId, Long shippingId) {
        this.id = id;
        this.note = note;
        this.orderDate = orderDate;
        this.paymentType = paymentType;
        this.status = status;
        this.vat = vat;
        this.customerId = customerId;
        this.shippingId = shippingId;
    }

    public double calTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : lineItems) {
            totalPrice += item.calPriceItem();
        }
        BigDecimal roundedTotal = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
        return roundedTotal.doubleValue();
    }

    public double calculateTotalDiscount() {
        double remainingPrice = calTotalPrice();
        double totalDiscount = 0;

        for (Promotion promotion : promotions) {
            double discount = promotion.calculateDiscount(remainingPrice);
            totalDiscount += discount;
            remainingPrice -= discount;
        }

        return totalDiscount;
    }

    public double getFinalPrice() {
        double totalPrice = calTotalPrice() + order.getShipping().getShippingFee();
        double totalDiscount = calculateTotalDiscount();

        return Math.max(0, totalPrice - totalDiscount);
    }
}
