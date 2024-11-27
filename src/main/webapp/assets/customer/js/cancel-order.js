/**
 * Hủy đơn hàng bằng cách gửi yêu cầu đến servlet
 * @param {Long} orderId - ID của đơn hàng cần hủy
 */
async function cancelOrder(orderId) {
    if (confirm("Bạn có chắc chắn muốn hủy đơn hàng này không?")) {

        try {
            const response = await fetch(`${contextPath}/api/customer/cancelOrder`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: `orderId=${orderId}`
            });

            const data = await response.json();
            console.log(data);

            if (data.success) {
                // Thông báo thành công
                alert('Hủy đơn hàng thành công!');
                location.reload(); // Tải lại trang để cập nhật thông tin đơn hàng
            } else {
                // Thông báo lỗi
                alert('Không thể hủy đơn hàng. Vui lòng thử lại.');
            }
        } catch (error) {
            console.error("Error:", error);
            alert('Có lỗi xảy ra khi hủy đơn hàng. Vui lòng thử lại sau.');
        }
    }
}
