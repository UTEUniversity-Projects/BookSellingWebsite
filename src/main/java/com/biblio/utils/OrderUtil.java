package com.biblio.utils;

import com.biblio.dto.response.DiscountResponse;
import com.biblio.dto.response.OrderDetailsManagementResponse;
import com.biblio.dto.response.OrderProductResponse;
import com.biblio.service.IOrderService;
import com.biblio.service.IPromotionTemplateService;

import javax.inject.Inject;
import java.util.List;

public class OrderUtil {
    @Inject
    IOrderService orderService;
    @Inject
    IPromotionTemplateService promotionTemplateService;

    public OrderDetailsManagementResponse getOrderDetails(Long orderId) {
        OrderDetailsManagementResponse orderDetail = orderService.getOrderDetailsManagementResponse(orderId);
        if (orderDetail == null) {
            System.out.println("Order not found for ID: " + orderId);
            return null;
        }

        List<DiscountResponse> discounts = promotionTemplateService.getAllDiscounts();
        for (OrderProductResponse product : orderDetail.getProducts()) {
            double discount = promotionTemplateService.percentDiscount(product.getBookTemplateId(), discounts);
            product.setDiscountPercent(discount);
            product.calTotalPrice();
        }

        orderDetail.updateTotalPrice();
        orderDetail.updateFinalPrice();
        return orderDetail;
    }

}
