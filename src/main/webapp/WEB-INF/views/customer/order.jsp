<script defer src="${pageContext.request.contextPath}/assets/customer/js/order-list.js"></script> <!-- Đường dẫn tới tệp JS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/scss/style.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.biblio.dto.response.OrderCustomerResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="com.biblio.dto.response.BookResponse" %>
<%@ page import="java.util.Set" %>

<%
    // Lấy dữ liệu từ controller
    List<OrderCustomerResponse> orders = (List<OrderCustomerResponse>) request.getAttribute("orders");
    String currentStatus = request.getParameter("status") != null ? request.getParameter("status") : "all";
%>

<div class="bg-gray-100 py-5">
    <div class="max-w-[1024px] mx-auto">
        <!-- Thanh bộ lọc trạng thái -->
        <div id="order-filters" class="flex justify-evenly items-center bg-white py-3 mb-5 border border-gray-200">
            <a href="?status=all" class="tag <%= "all".equals(currentStatus) ? "text-[#26aa99] font-bold" : "text-gray-500" %>">Tất cả</a>
            <a href="?status=WAITING_CONFIRMATION" class="tag <%= "WAITING_CONFIRMATION".equals(currentStatus) ? "text-[#26aa99] font-bold" : "text-gray-500" %>">Chờ xác nhận</a>
            <a href="?status=COMPLETE_DELIVERY" class="tag <%= "COMPLETE_DELIVERY".equals(currentStatus) ? "text-[#26aa99] font-bold" : "text-gray-500" %>">Hoàn tất giao hàng</a>
            <a href="?status=CANCELED" class="tag <%= "CANCELED".equals(currentStatus) ? "text-[#26aa99] font-bold" : "text-gray-500" %>">Đã hủy</a>
        </div>

        <!-- Danh sách đơn hàng -->
        <div id="order-list" class="mt-5">
            <% if (orders != null && !orders.isEmpty()) { %>
            <% for (OrderCustomerResponse order : orders) {
                String status = order.getStatus();
                long orderId = order.getId();
                if ("all".equals(currentStatus) || currentStatus.equals(status)) {
                    Set<BookResponse> books = order.getBook();
                    Double totalPrice = order.getTotalPrice();
            %>
            <div class="order-item mb-5 p-4 bg-white border border-gray-200 rounded" data-order-id="<%= orderId %>">
                <!-- Trạng thái -->
                <div class="flex justify-end mb-3 status-container">
                    <span class="text-sm font-bold <%= "COMPLETE_DELIVERY".equals(status) ? "text-green-500" : "CANCELED".equals(status) ? "text-red-500" : "text-yellow-500" %>">
                        <%= "COMPLETE_DELIVERY".equals(status) ? "Giao hàng thành công" : "CANCELED".equals(status) ? "Đã hủy" : "Chờ xác nhận" %>
                    </span>
                </div>

                <!-- Sản phẩm -->
                <% int bookIndex = 0; %>
                <% for (BookResponse book : books) { %>
                <div class="<%= bookIndex > 0 ? "my-hidden" : "" %> flex items-center mb-3" data-book-index="<%= bookIndex %>">
                    <div class="flex items-center book-item">
                        <!-- Hình ảnh sách -->
                        <div>
                            <img src="<%= "https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljhy12voht6q4c.webp" %>" alt="<%= book.getTitle() %>">
                        </div>

                        <!-- Thông tin sách -->
                        <div class="book-info">
                            <h4><%= book.getTitle() %></h4>
                            <p>₫<%= book.getSellingPrice() %></p>
                        </div>
                    </div>

                </div>
                <% bookIndex++; %>
                <% } %>

                <!-- Nút Xem thêm/Thu gọn -->
                <% if (books.size() > 1) { %>
                <div class="status-container flex justify-start w-full cursor-pointer text-[#26aa99]" onclick="toggleItems('<%= orderId %>')">
                    <span id="toggle-text-<%= orderId %>">Xem thêm ▼</span>
                </div>
                <% } %>

                <!-- Tổng tiền -->
                <div class="text-right">
                    <h3 class="text-lg font-bold">Thành tiền: ₫<%= totalPrice %></h3>
                </div>
                <div class="button-container mt-5 text-right">
                    <% if ("COMPLETE_DELIVERY".equals(status)) { %>
                    <button class="px-4 py-2 bg-[#26aa99] rounded text-white hover:bg-[#158d7d]" onclick="alert('Chức năng đang được phát triển!'); return false;">Đặt lại đơn hàng</button>
                    <button class="px-4 py-2 bg-[#ff9800] rounded text-white hover:bg-[#e58900] transition" onclick="alert('Chức năng đang được phát triển!'); return false;">Hoàn trả</button>
                    <button class="px-4 py-2 bg-[#ffc107] rounded text-white hover:bg-[#e6ac00]" onclick="alert('Chức năng đang được phát triển!'); return false;">Đánh giá</button>
                    <% } else if ("WAITING_CONFIRMATION".equals(status)) { %>
                    <button class="px-4 py-2 bg-[#e91e4c] rounded text-white hover:bg-[#d0173f]" onclick="cancelOrder('<%= orderId %>'); return false;">Hủy đơn hàng</button>
                    <% } else if ("CANCELED".equals(status)) { %>
                    <button class="px-4 py-2 bg-[#26aa99] rounded text-white hover:bg-[#158d7d]" onclick="alert('Chức năng đang được phát triển!'); return false;">Mua lại đơn hàng</button>
                    <% } %>
                    <!-- Nút luôn hiển thị -->
                    <button class="px-4 py-2 rounded text-black border border-gray-200 hover:bg-gray-100" onclick="alert('Chức năng đang được phát triển!'); return false;">Liên hệ người bán</button>
                </div>

            </div>
            <% } %>
            <% } %>
            <% } else { %>
            <p class="text-center text-gray-500">Không có đơn hàng nào để hiển thị.</p>
            <% } %>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/assets/customer/js/cancel-order.js"></script>

