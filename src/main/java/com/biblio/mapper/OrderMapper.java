package com.biblio.mapper;

import com.biblio.dto.response.*;
import com.biblio.entity.Order;
import com.biblio.entity.Promotion;
import com.biblio.enumeration.EPromotionTemplateType;

import javax.validation.constraints.Max;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderManagementResponse mapToOrderManagementResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return OrderManagementResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomer().getFullName())
                .orderDate(order.getOrderDate().format(formatter))
                .totalPrice(order.calTotalPrice())
                .paymentMethod(order.getPaymentType().getValue())
                .status(order.getStatus())
                .statusDisplay(order.getStatus().getDescription())
                .statusStyle(order.getStatus().getStatusStyle())
                .build();
    }

    public static OrderDetailsManagementResponse mapToOrderDetailsManagementResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

        List<OrderProductResponse> products = order.getOrderItems().stream()
                .map(OrderItemMapper::mapToOrderProductResponse)
                .collect(Collectors.toList());

        CustomerResponse customer = CustomerMapper.toCustomerResponse(order.getCustomer());

        ShippingResponse shipping = ShippingMapper.toShippingResponse(order.getShipping());

        List<PromotionOrderResponse> promotions = new ArrayList<>();
        double totalPrice = order.calTotalPrice();
        double finalPrice = totalPrice + shipping.getShippingFee();

        for (Promotion promotion : order.getPromotions()) {
            if (promotion.getPromotionTemplate().getType() != EPromotionTemplateType.DISCOUNT) {
                double discount = promotion.calculateDiscount(finalPrice);
                promotions.add(PromotionOrderResponse.builder()
                        .promotionType(promotion.getPromotionTemplate().getType())
                        .discountAmount(discount)
                        .build());
                finalPrice -= discount;
            }
        }
        finalPrice = Math.max(finalPrice, 0);

        return OrderDetailsManagementResponse.builder()
                .id(order.getId())
                .customer(customer)
                .shipping(shipping)
                .orderDate(order.getOrderDate().format(formatter))
                .note(order.getNote())
                .products(products)
                .status(order.getStatus())
                .statusDisplay(order.getStatus().getDescription())
                .statusStyle(order.getStatus().getStatusStyle())
                .totalPrice(totalPrice)
                .paymentMethod(order.getPaymentType().getValue())
                .promotions(promotions)
                .finalPrice(finalPrice)
                .build();
    }

    public static OrderCustomerResponse toOrderRequest(Order order) {
        return new OrderCustomerResponse(
                order.getId(),
                order.getNote(),
                order.getOrderDate(),
                order.getPaymentType() != null ? order.getPaymentType().name() : null,  // Convert EPaymentType to String
                order.getStatus() != null ? order.getStatus().name() : null,  // Convert EOrderStatus to String
                order.getVat(),
                order.getCustomer() != null ? order.getCustomer().getId() : null,
                order.getShipping() != null ? order.getShipping().getId() : null
        );
    }

    public static RevenueResponse toRevenueResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return RevenueResponse.builder()
                .date(order.getOrderDate())
                .revenue(order.calTotalPrice())
                .build();
    }

}
