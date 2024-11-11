function changeStatus(customerId, action) {
    const url = `${contextPath}/owner/customer-list`;

    $.ajax({
        url: url,
        type: 'POST',
        data: {
            action: action,
            id: customerId
        },
        success: function(data) {
            if (data === 'success') {
                alert(action === 'deactivate' ? 'Tài khoản đã bị vô hiệu hóa' : 'Tài khoản đã được mở khóa');

                // Cập nhật trạng thái hiển thị
                const statusElement = document.getElementById(`status-${customerId}`);
                if (statusElement) {
                    statusElement.innerText = (action === 'deactivate') ? 'INACTIVE' : 'ACTIVE';
                }
            } else {
                alert('Có lỗi xảy ra khi thay đổi trạng thái tài khoản');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('Có lỗi xảy ra khi kết nối tới server');
        }
    });
}

document.addEventListener("DOMContentLoaded", function () {
    const tableBody = document.querySelector("#customer-data-table tbody");

    // Đảm bảo `tableBody` không phải là null
    if (tableBody) {
        tableBody.addEventListener("click", function (event) {
            // Kiểm tra xem phần tử được nhấp có phải là .customer-row hay không
            const row = event.target.closest(".customer-row");

            if (
                row &&
                !event.target.closest("button") &&
                !event.target.closest(".dropdown-menu")
            ) {
                const href = row.getAttribute("data-href");
                window.location.href = href;
            }
        });
    }
});
