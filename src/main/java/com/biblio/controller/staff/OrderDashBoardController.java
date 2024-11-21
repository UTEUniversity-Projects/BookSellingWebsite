package com.biblio.controller.staff;

import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.service.IOrderService;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serial;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/staff/order-dashboard")
public class OrderDashBoardController extends HttpServlet {
    @Inject
    IOrderService orderService;
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDashBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<OrderManagementResponse> orders = orderService.getAllOrderManagementResponse();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/views/staff/order-dashboard.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            Long orderId = Long.parseLong(request.getParameter("id"));

            if ("confirm".equals(action)) {
                try {
                    // Xác nhận đơn hàng
                    orderService.confirmOrder(orderId);

                    // Gửi email xác nhận đơn hàng
                    sendOrderConfirmationEmail(orderId);

                    // Quay lại trang dashboard
                    response.sendRedirect(request.getContextPath() + "/staff/order-dashboard");
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                    request.getRequestDispatcher("/views/staff/order-details.jsp").forward(request, response);
                }
            } else if ("rejectOutOfStock".equals(action)) {
                try {
                    // Từ chối đơn hàng do hết hàng
                    orderService.rejectOrder(orderId, "Hết hàng");
                    response.sendRedirect(request.getContextPath() + "/staff/order-dashboard");
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                    request.getRequestDispatcher("/views/staff/order-details.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage());
        }
    }
    private void sendOrderConfirmationEmail(Long orderId) throws IOException {
        System.out.println("Email target: " + orderId); // Kiểm tra địa chỉ email
        // URL của API gửi email
        String apiUrl = "http://localhost:8080/BookSellingWebsite/api/order/send-email";
        HttpURLConnection connection = null;

        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Gửi thông tin orderId qua body của request
            String params = "orderId=" + orderId;
            try (OutputStream os = connection.getOutputStream()) {
                os.write(params.getBytes());
                os.flush();
            }

            // Kiểm tra phản hồi từ API
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpServletResponse.SC_OK) {
                throw new IOException("Gửi email thất bại! Mã lỗi: " + responseCode);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
