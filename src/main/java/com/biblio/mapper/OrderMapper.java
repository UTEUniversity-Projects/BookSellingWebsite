package com.biblio.mapper;

import com.biblio.dto.response.*;
import com.biblio.entity.*;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.enumeration.EPromotionTemplateType;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.biblio.utils.DateTimeUtil.formatDateTime;

public class OrderMapper {
    public static OrderManagementResponse mapToOrderManagementResponse(Order order) {
        return OrderManagementResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomer().getFullName())
                .orderDate(formatDateTime(order.getOrderDate(), "HH:mm dd-MM-yyyy"))
                .totalPrice(order.calTotalPrice())
                .paymentMethod(order.getPaymentType().getValue())
                .status(order.getStatus())
                .statusStyle(order.getStatus().getStatusStyle())
                .build();
    }

    public static OrderDetailsManagementResponse mapToOrderDetailsManagementResponse(Order order) {
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
                .orderDate(formatDateTime(order.getOrderDate(), "HH:mm dd-MM-yyyy"))
                .note(order.getNote())
                .products(products)
                .status(order.getStatus())
                .statusStyle(order.getStatus().getStatusStyle())
                .totalPrice(totalPrice)
                .paymentMethod(order.getPaymentType().getValue())
                .promotions(promotions)
                .finalPrice(finalPrice)
                .build();
    }

    public static OrderCustomerResponse toOrderCustomerResponse(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

        List<OrderProductResponse> products = order.getOrderItems().stream()
                .map(OrderItemMapper::mapToOrderProductResponse)
                .collect(Collectors.toList());

        CustomerResponse customer = CustomerMapper.toCustomerResponse(order.getCustomer());

        ShippingResponse shipping = ShippingMapper.toShippingResponse(order.getShipping());

        Set<OrderItem> lineItems = new HashSet<>(order.getOrderItems());
        Set<Promotion> listPromotion = new HashSet<>(order.getPromotions());
        List<PromotionOrderResponse> promotions = new ArrayList<>();
        double totalPrice = order.calTotalPrice();
        double totalDiscount = order.calculateTotalDiscount();
        double finalPrice = order.calTotalPrice();

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

        String publisherName = null;
        if (lineItems != null && !lineItems.isEmpty()) {
            // Duyệt qua các OrderItem để lấy thông tin sách
            for (OrderItem lineItem : lineItems) {
                // Lấy tên sách từ orderItem
                Set<Book> books = lineItem.getBooks();
                if (books != null && !books.isEmpty()) {
                    // Duyệt qua danh sách sách để lấy thông tin Publisher
                    for (Book book : books) {
                        // Lấy BookTemplate từ Book
                        BookTemplate bookTemplate = book.getBookTemplate();
                        if (bookTemplate != null) {
                            // Lấy Publisher từ BookTemplate
                            Publisher publisher = bookTemplate.getPublisher();
                            if (publisher != null) {
                                // Lấy tên nhà xuất bản
                                publisherName = publisher.getName();
                                // Bạn có thể sử dụng publisherName tại đây
                            }
                        }
                    }
                }
            }

        }

        return OrderCustomerResponse.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate().format(formatter))
                .note(order.getNote())
                .products(products)
                .status(order.getStatus())
                //.statusDisplay(order.getStatus().getDescription())
                //.statusStyle(order.getStatus().getStatusStyle())
                .totalPrice(totalPrice)
                //.paymentMethod(order.getPaymentType().getValue())
                .promotions(listPromotion)
                .lineItems(lineItems)
                .finalPrice(finalPrice)
                .totalDiscount(totalDiscount)
                .order(order)
                .publisherName(publisherName)
                .shipping(shipping)
                .build();
    }

    public static RevenueResponse toRevenueResponse(Order order) {
        return RevenueResponse.builder()
                .date(order.getOrderDate())
                .revenue(order.calTotalPrice())
                .build();
    }
    public static OrderOfCustomerResponse toOrderOfCustomerResponse(Order order) {
        return OrderOfCustomerResponse.builder()
                .orderId(order.getId())
                .customerId(order.getCustomer().getId())
                .customerName(order.getCustomer().getFullName())
                .build();
    }

}
