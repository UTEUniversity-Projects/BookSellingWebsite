// Remove cart item
import { debounce } from '../../commons/js/debounce.js';

// Click vao nut them gio hang
// Lay id cua book template
// Truyen len API
// Lay ra bookTemplate tuong ung
// set bookTemplate do' cho cartItem

/*
* AddCartItemRequest
* cartId
* cartItemId
* bookTemplate
* */

/*
* Cac truong gui len trong ajax phai tuong ung voi cac truong trong dto request
* AddCartItemRequest addCartItemRequest = HttpUtil.of(request.getReader()).toModel(AddCartItemRequest.class);
* */

/*
* Xu ly them cartItem
* */

/*
* Tra ve ket qua thanh cong hay that bai
* */

$(document).ready(function () {
    // Add
    $(".add-to-cart-btn").on("click", function () {
        const bookId = $(this).data("book-id");
        const quantity = $(this).data("quantity") || $(this).closest(".modal-body, .cr-product-card").find(".quantity").val();

        console.log({
            bookId: bookId,
            quantity: quantity
        });
        $.ajax({
            url: `${contextPath}/api/customer/add-cart-item`,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                bookTemplateId: bookId,
                quantity: quantity
            }),
            success: function (response) {
                console.log(response);
            },
            error: function (xhr, status, error) {
                console.error("Error: ", xhr.responseText);
            }
        });
    });
    // Load
    $('#view-cart-btn').on('click', function () {
        $.ajax({
            url: `${contextPath}/api/customer/load-cart-sidebar`,
            type: 'GET',
            success: function (response) {
                const cartItemsContainer = $('.crcart-pro-items');

                cartItemsContainer.empty();

                if (response.cart && response.cart.cartItems && response.cart.cartItems.length > 0) {

                    response.cart.cartItems.forEach(cartItem => {
                        const itemHTML = `
                         <li>
                             <a href="${contextPath}/book?id=${cartItem.bookId}" class="crside_pro_img">
                                 <img src="${contextPath}${cartItem.imageUrl}" alt="${cartItem.title}" />
                             </a>
                             <div class="cr-pro-content">
                                 <a href="${contextPath}/book?id=${cartItem.bookId}" class="cart_pro_title">
                                     ${cartItem.title}
                                 </a>
                                 <span class="cart-price">
                                    <span class="new-price price-value">${cartItem.sellingPrice}</span>
                                    <span class="old-price price-value">${cartItem.sellingPrice}</span>
                                 </span>
                                 <div class="cr-cart-qty">
                                     <div class="cart-qty-plus-minus">
                                         <button type="button" class="minus">-</button>
                                         <input
                                             type="text"
                                             value="${cartItem.quantity}"
                                             class="quantity"
                                             minlength="1"
                                             maxlength="20"
                                         />
                                         <button type="button" class="plus">+</button>
                                     </div>
                                 </div>
                                 <a href="javascript:void(0)" class="remove">×</a>
                             </div>
                         </li>
                     `;
                        cartItemsContainer.append(itemHTML);
                    });
                } else {
                    cartItemsContainer.html('<p class="text-center">Giỏ hàng của bạn đang trống.</p>');
                }
                formatCurrency();
            },
            error: function (xhr, status, error) {

            }
        });
    });
    // Update
    $(".quantity").on("change", debounce(function () {
        const newQuantity = $(this).val();
        const cartItemId = $(this).closest('tr').data("cart-item-id");
        console.log(cartItemId);
        console.log(newQuantity);

        $.ajax({
            url: `${contextPath}/api/customer/update-cart-item`,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                cartItemId: cartItemId,
                quantity: newQuantity
            }),
            success: function (response) {
            },
            error: function (xhr, status, error) {
                console.error("Error: ", xhr.responseText);
            }
        })
    },1000));
    // Delete
    $(".remove-item").on("click", function (){
        const cartItemId = $(this).closest('tr').data("cart-item-id");
        const item = this.closest('tr');
        console.log(cartItemId);
       $.ajax({
           url: `${contextPath}/api/customer/delete-cart-item`,
           type: "POST",
           contentType: "application/json",
           data: JSON.stringify({
               cartItemId: cartItemId
           }),
           success: function (response) {
               item.remove();
           },
           error: function (xhr, status, error) {
               console.error("Error: ", xhr.responseText);
           }
       })
    });
});

function formatCurrency() {
    document.querySelectorAll('.cr-cart-view .price-value').forEach(el => {
        const rawValue = el.textContent.trim();

        const value = parseFloat(rawValue);

        if (!isNaN(value)) {
            const formattedValue = value.toLocaleString('vi-VN');
            if (el.classList.contains('minus-value')) {
                el.innerHTML = `-${formattedValue}<span class="currency-symbol">₫</span>`;
            } else {
                el.innerHTML = `${formattedValue}<span class="currency-symbol">₫</span>`;
            }
        }
    });
}

