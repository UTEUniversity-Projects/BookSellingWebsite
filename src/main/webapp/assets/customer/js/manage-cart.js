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
//     // Sự kiện click cho nút "Thêm vào giỏ hàng"
//     $(".add-to-cart-btn").on("click", function () {
//         const bookId = $(this).data("book-id"); // Lấy ID của sách
//         const cartId = 1; // Thay bằng ID giỏ hàng của người dùng (lấy từ session hoặc dữ liệu backend)
//         const quantity = 1; // Số lượng mặc định là 1, có thể tuỳ chỉnh thêm input
//
//         // Gửi AJAX tới server
//         $.ajax({
//             url: "/api/carts/add-item", // Endpoint xử lý thêm vào giỏ hàng
//             type: "POST",
//             contentType: "application/json",
//             data: JSON.stringify({
//                 bookTemplateId: bookId,
//                 cartId: cartId,
//                 quantity: quantity
//             }),
//             success: function (response) {
//                 // Thông báo thêm thành công
//                 alert("Sản phẩm đã được thêm vào giỏ hàng!");
//             },
//             error: function (xhr) {
//                 // Xử lý lỗi
//                 alert("Đã xảy ra lỗi khi thêm vào giỏ hàng: " + xhr.responseText);
//             }
//         });
//     });
// });
