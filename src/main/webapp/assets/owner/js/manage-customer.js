function changeStatus(customerId, action) {
    const url = `${contextPath}/owner/customer-list`;

    $.ajax({
        url: url,
        type: 'POST',
        data: {
            action: action,
            id: customerId
        },
        success: function (data) {
            if (data === 'success') {
                const message = action === 'deactivate' ? 'Tài khoản đã bị vô hiệu hóa' : 'Tài khoản đã được mở khóa';
                toast({
                    title: "Thành công!",
                    message: message,
                    type: "success",
                    duration: 1000,
                });
                console.log(message);
                // Cập nhật trạng thái hiển thị
                const statusElement = document.getElementById(`status-${customerId}`);
                if (statusElement) {
                    statusElement.innerText = (action === 'deactivate') ? 'INACTIVE' : 'ACTIVE';
                }

                // Cập nhật nội dung dropdown-menu
                const dropdownMenu = statusElement.closest('tr').querySelector('.dropdown-menu');
                if (dropdownMenu) {
                    if (action === 'deactivate') {
                        dropdownMenu.innerHTML = `<a class="dropdown-item pop-positioned-timeout" href="#" onclick="changeStatus(${customerId}, 'activate'); return false;">Mở khóa tài khoản</a>`;
                    } else {
                        dropdownMenu.innerHTML = `<a class="dropdown-item pop-positioned-timeout" href="#" onclick="changeStatus(${customerId}, 'deactivate'); return false;">Vô hiệu hóa tài khoản</a>`;
                    }
                }
            } else {
                toast({
                    title: "Thất bại!",
                    message: "Có lỗi xảy ra khi thay đổi trạng thái tài khoản.",
                    type: "error",
                    duration: 1000,
                });
            }
        },
        error: function (xhr, status, error) {
            console.error('Error:', error);
            toast({
                title: "Thất bại!",
                message: "Có lỗi xảy ra khi kết nối tới server.",
                type: "error",
                duration: 1000,
            });
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
