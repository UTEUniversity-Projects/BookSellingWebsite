function toggleItems(orderId) {
    // Lấy phần tử nút toggle (Xem thêm / Thu gọn)
    const toggleText = document.getElementById(`toggle-text-${orderId}`);
    // Lấy tất cả các mục trong đơn hàng có class "my-hidden" hoặc "my-visible"
    const items = document.querySelectorAll(`.order-item[data-order-id='${orderId}'] .my-hidden, .order-item[data-order-id='${orderId}'] .my-visible`);

    // Kiểm tra xem tất cả các mục có đang bị ẩn không
    const isHidden = Array.from(items).every(item => item.classList.contains('my-hidden'));

    // Duyệt qua tất cả các mục
    items.forEach(item => {
        // Nếu tất cả các mục đều đang ẩn thì hiển thị, ngược lại thì ẩn
        item.classList.toggle('my-hidden', !isHidden);
        item.classList.toggle('my-visible', isHidden); // Đánh dấu đã toggle để quay lại trạng thái ban đầu
    });

    // Cập nhật nội dung nút "Xem thêm ▼" hoặc "Thu gọn ▲" tùy theo trạng thái hiện tại
    toggleText.textContent = isHidden ? "Thu gọn ▲" : "Xem thêm ▼";
}
