<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Notify sidebar -->
<div class="cr-notify-bar-overlay"></div>
<div class="cr-notify-bar">
    <div class="cr-bar-title">
        <h6>Notifications<span class="label" id="notification-count">0</span></h6>
        <a href="javascript:void(0)" class="close-notify">
            <i class="ri-close-line"></i>
        </a>
    </div>
    <div class="cr-bar-content">
<%--        <ul class="nav nav-tabs" id="myTab" role="tablist">--%>
<%--            <li class="nav-item" role="presentation">--%>
<%--                <button--%>
<%--                        class="nav-link active"--%>
<%--                        id="alert-tab"--%>
<%--                        data-bs-toggle="tab"--%>
<%--                        data-bs-target="#alert"--%>
<%--                        type="button"--%>
<%--                        role="tab"--%>
<%--                        aria-controls="alert"--%>
<%--                        aria-selected="true"--%>
<%--                >--%>
<%--                    Alert--%>
<%--                </button>--%>
<%--            </li>--%>
<%--        </ul>--%>
        <div class="tab-content" id="myTabContent">
            <div
                    class="tab-pane fade show active"
                    id="alert"
                    role="tabpanel"
                    aria-labelledby="alert-tab"
            >
                <div class="cr-alert-list">
                    <ul id="notification-list">
                        <!-- Các thông báo sẽ được thêm vào đây -->
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Thêm thư viện jQuery 3.6.4 từ CDN -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    // Hàm gọi API và hiển thị thông báo bằng AJAX
    function fetchNotifications() {
        console.log("Fetching notifications...");

        $.ajax({
            url: `${contextPath}/api/staff/notification/get`,  // URL đến API
            method: "GET",                       // Phương thức HTTP
            dataType: "json",                    // Định dạng dữ liệu trả về (JSON)
            success: function (notifications) {
                console.log("Notifications received:", notifications);

                // Kiểm tra nếu không có dữ liệu trả về từ API
                if (!notifications || notifications.length === 0) {
                    console.log("No notifications available.");
                    $("#notification-list").empty().append("<li>No notifications available</li>");
                    $("#notification-count").text(0);
                    return;
                }

                const notificationList = $("#notification-list");
                const notificationCount = $("#notification-count");

                // Xóa danh sách thông báo cũ
                notificationList.empty();

                // Cập nhật số lượng thông báo
                notificationCount.text(notifications.length);

                // Duyệt qua các thông báo và thêm vào UI
                notifications.forEach(notification => {
                    console.log("Processing notification:", notification);

                    // Kiểm tra và thay thế các giá trị null/undefined với giá trị mặc định
                    const title = notification.title || "No title";
                    const content = notification.content || "No content";
                    const sentTime = notification.sentTime || "N/A"; // Kiểm tra sentTime
                    const hyperlink = "${pageContext.request.contextPath}" + notification.hyperLink || "#"; // Đảm bảo rằng có link
                    const isRead = notification.status === "VIEWED";

                    console.log("Title:", title);  // Kiểm tra giá trị của title
                    console.log("Content:", content);  // Kiểm tra giá trị của content
                    console.log("SentTime:", sentTime);  // Kiểm tra giá trị của sentTime

                    // Tạo HTML cho mỗi thông báo
                    const li = $("<li>").attr("data-id", notification.id); // Gán data-id vào thẻ <li>
                    li.html(`
                    <a href="#" class="notification-link">
                        <div class="icon cr-alert">
                            <i class="ri-alarm-warning-line"></i>
                        </div>
                        <div class="detail">
                            <div class="title"></div> <!-- Gắn text sau -->
                            <p class="time"></p> <!-- Gắn text sau -->
                            <p class="message"></p> <!-- Gắn text sau -->
                        </div>
                    </a>
                `);

                    // Gán giá trị vào các thẻ cụ thể
                    li.find(".title").text(title);
                    li.find(".time").text(content);
                    li.find(".message").text(sentTime);

                    // Thay đổi màu nền và font-weight cho thông báo chưa đọc
                    if (!isRead) {
                        li.css("background-color", "#f0f8ff"); // Màu nền cho thông báo chưa đọc (sử dụng màu xanh nhạt, có thể thay đổi theo ý bạn)
                        li.css("font-weight", "bold");  // Để đậm văn bản cho thông báo chưa đọc
                    }

                    // Gán giá trị vào các thẻ cụ thể
                    li.find(".notification-link").attr("href", hyperlink);

                    // Thêm thông báo vào danh sách
                    notificationList.append(li);
                });

                // Thêm sự kiện click cho từng thông báo
                $("li[data-id]").click(function(e) {
                    e.preventDefault();  // Ngừng hành động mặc định của thẻ <a>

                    const notificationId = $(this).attr("data-id");  // Lấy ID của thông báo từ data-id của thẻ <li>
                    const link = $(this).find(".notification-link").attr("href"); // Lấy liên kết từ thẻ <a>

                    // Gọi API để cập nhật trạng thái thông báo khi người dùng nhấn vào
                    $.ajax({
                        url: `${contextPath}/api/staff/notification/update`,
                        method: "POST",
                        data: { notificationId: notificationId },
                        success: function(response) {
                            console.log("Notification status updated successfully.");
                            // Sau khi cập nhật thành công, chuyển hướng tới trang thông báo
                            window.location.href = link; // Chuyển hướng đến trang đã được gắn trong thẻ <a>
                        },
                        error: function(xhr, status, error) {
                            console.error("Error updating notification status: ", error);
                            alert("Lỗi khi cập nhật trạng thái thông báo!");
                        }
                    });
                });
            },
            error: function (xhr, status, error) {
                console.error("Error fetching notifications: ", error);
                alert("Lỗi khi tải thông báo!");
            }
        });
    }

    // Gọi API khi trang được tải
    $(document).ready(function () {
        console.log("Page loaded. Calling fetchNotifications()");
        fetchNotifications();
    });

</script>







