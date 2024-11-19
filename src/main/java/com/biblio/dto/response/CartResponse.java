package com.biblio.dto.response;

import com.biblio.entity.CartItem;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private List<CartItemResponse> cartItems;
    private double totalBookPrice;
}
