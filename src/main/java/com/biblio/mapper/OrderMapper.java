package com.biblio.mapper;

import com.biblio.dto.response.*;
import com.biblio.entity.Book;
import com.biblio.entity.LineItem;
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
        // Định dạng LocalDateTime thành String
        String formattedOrderDate = (order.getOrderDate() != null) ? order.getOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null;

        // Define a default totalPrice or calculate based on order items
        Double totalPrice = 1000.0; // You can replace this with a calculation based on order's line items

        // Build the OrderCustomerResponse with the fields that don't depend on looping
        OrderCustomerResponse orderCustomerResponse = OrderCustomerResponse.builder()
                .id(order.getId())
                .note(order.getNote())
                .orderDate(formattedOrderDate)  // Chuyển LocalDateTime thành String
                .paymentType(order.getPaymentType() != null ? order.getPaymentType().name() : null)  // Convert EPaymentType to String
                .status(order.getStatus() != null ? order.getStatus().name() : null)  // Convert EOrderStatus to String
                .vat(order.getVat())
                .customerId(order.getCustomer() != null ? order.getCustomer().getId() : null)
                .shippingId(order.getShipping() != null ? order.getShipping().getId() : null)
                .totalPrice(totalPrice)
                .build();

        // Iterate over order items and add books to the response
        for (LineItem lineItem : order.getLineItems()) {
            // Iterate over the books in the line item and convert each to a BookResponse
            for (Book book : lineItem.getBooks()) {
                BookResponse bookResponse = BookResponse.builder()
                        .id(String.valueOf(book.getId()))
                        .title(book.getTitle())
                        .description(book.getDescription())
                        .sellingPrice(String.valueOf(book.getSellingPrice()))
                        .build();

                // Add the BookResponse to the orderCustomerResponse's book set
                orderCustomerResponse.getBook().add(bookResponse);
            }
        }

        return orderCustomerResponse;
    }

    public static RevenueResponse toRevenueResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        return RevenueResponse.builder()
                .date(order.getOrderDate())
                .revenue(order.calTotalPrice())
                .build();
    }

}
