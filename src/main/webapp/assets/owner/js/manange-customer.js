$(document).ready(function() {
    $.ajax({
        url: '/api/owner/customer',  // URL của servlet
        method: 'GET',
        dataType: 'json',          // Định dạng dữ liệu mong đợi là JSON
        success: function(data) {
            // Xử lý dữ liệu JSON nhận được từ servlet
            console.log(data); // Hiển thị dữ liệu trong console để kiểm tra
            data.forEach(function(customer) {
                // Ví dụ: hiển thị tên của khách hàng
                console.log("Tên khách hàng: " + customer.fullName);
                // Bạn có thể thêm mã để hiển thị dữ liệu trên giao diện người dùng
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("Lỗi: " + textStatus + " - " + errorThrown);
        }
    });
})