// Remove cart item
document.querySelectorAll('.remove-item').forEach((button) => {
    button.addEventListener('click', function () {
    const row = this.closest('tr');
    if (row) {
        row.remove();
    }
    });
});

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

// $(document).ready(function () {
//     $(".add-to-cart-btn").on("click", function () {
//         const bookId = $(this).data("book-id");
//         const cartId = $(this).data("cart-id");
//         const quantity = $(this).data("quantity");
//
//         $.ajax({
//             url: `${contextPath}/api/customer/add-cart-item`,
//             type: "POST",
//             contentType: "application/json",
//             data: JSON.stringify({
//                 bookTemplateId: bookId,
//                 cartId: cartId,
//                 quantity: quantity
//             }),
//             // success: function (response) {
//             //     updateCartUI(response);
//             // },
//         });
//     });
//     // function updateCartUI(response) {
//     //
//     //     $(".total-book-price").text(response.totalBookPrice);
//     //
//     //     response.cartItems.forEach(cartItem => {
//     //         const $cartItemElement = $(`#cart-item-${cartItem.bookTemplateId}`);
//     //         $cartItemElement.find(".quantity").val(cartItem.quantity);
//     //         $cartItemElement.find(".cart-price .price-value").text(cartItem.sellingPrice);
//     //         // const totalItemPrice = cartItem.sellingPrice * cartItem.quantity;
//     //         // $cartItemElement.find(".cart-price").text(`${cartItem.sellingPrice} x ${cartItem.quantity} = ${totalItemPrice}`);
//     //     });
//     // }
// });
