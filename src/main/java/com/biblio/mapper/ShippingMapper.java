package com.biblio.mapper;

import com.biblio.dto.response.ShippingResponse;
import com.biblio.entity.Shipping;

public class ShippingMapper {
    public static ShippingResponse toShippingResponse(Shipping shipping) {
        return ShippingResponse.builder()
                .address(shipping.getAddress().getFullAddress())
                .shippingFee(shipping.getShippingFee())
                .shippingUnit(shipping.getShippingUnit())
                .build();
    }
}
