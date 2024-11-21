package com.biblio.controller.staff;

import com.biblio.entity.Book;
import com.biblio.entity.LineItem;
import com.biblio.entity.Order;
import com.biblio.service.IEmailService;
import com.biblio.service.IOrderService;
import com.biblio.service.impl.EmailServiceImpl;
import com.biblio.service.impl.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfirmOrderEmailController", urlPatterns = {"/api/order/send-email"})
public class ConfirmOrderEmailController extends HttpServlet {

    private final IEmailService emailService = new EmailServiceImpl();
    private final IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            String orderIdParam = request.getParameter("orderId");
            if (orderIdParam == null || orderIdParam.isEmpty()) {
                throw new IllegalArgumentException("Order ID không được để trống.");
            }

            long orderId = Long.parseLong(orderIdParam);

            // Lấy thông tin đơn hàng
            Order order = orderService.findOrderById(orderId);
            if (order == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"message\": \"Không tìm thấy đơn hàng với ID: " + orderId + "\"}");
                return;
            }

            // Gửi email
            String emailContent = generateOrderEmail(order);
            emailService.sendEmail(order.getCustomer().getEmailAddress(), "Xác nhận đơn hàng #" + order.getId(), emailContent);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Xác nhận đơn hàng thành công và email đã được gửi.\"}");

        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"Đã xảy ra lỗi: " + e.getMessage() + "\"}");
        }
    }

    // Hàm tạo nội dung email từ thông tin Order
    private String generateOrderEmail(Order order) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("Kính gửi ").append(order.getCustomer().getFullName()).append(",\n\n");
        emailContent.append("Cảm ơn bạn đã đặt hàng tại Biblio Bookshop.\n\n");

        emailContent.append("Thông tin chi tiết đơn hàng:\n");
        emailContent.append("---------------------------------------------------\n");
        emailContent.append("Mã đơn hàng: ").append(order.getId()).append("\n");
        emailContent.append("Ngày đặt hàng: ").append(order.getOrderDate()).append("\n");
        emailContent.append("Trạng thái: ").append(order.getStatus()).append("\n\n");

        emailContent.append("Sản phẩm:\n");
        for (LineItem item : order.getLineItems()) {
            for (Book book : item.getBooks()) {
                emailContent.append("- ").append(book.getTitle())
                        .append(" (Giá: ").append(book.getSellingPrice()).append(" VND)\n");
            }
        }

        emailContent.append("\nTổng tiền hàng: ").append(order.calTotalPrice()).append(" VND\n");
        emailContent.append("Thuế VAT: ").append(order.getVat()).append("%\n");

        /*if (order.getPromotions() != null && !order.getPromotions().isEmpty()) {
            emailContent.append("Khuyến mãi áp dụng:\n");
            for (Promotion promo : order.getPromotions()) {
                emailContent.append("- ").append(promo.getDescription()).append("\n");
            }
        }*/

        emailContent.append("\nPhương thức thanh toán: ").append(order.getPaymentType()).append("\n");
        if (order.getShipping() != null) {
            emailContent.append("Địa chỉ giao hàng: ").append(order.getShipping().getAddress().getFullAddress()).append("\n\n");
        }

        if (order.getNote() != null && !order.getNote().isEmpty()) {
            emailContent.append("Ghi chú: ").append(order.getNote()).append("\n\n");
        }

        emailContent.append("---------------------------------------------------\n");
        emailContent.append("Nếu bạn có bất kỳ thắc mắc nào, vui lòng liên hệ với chúng tôi qua email biblioBSW@gmail.com.\n\n");
        emailContent.append("Trân trọng,\n");
        emailContent.append("Biblio Bookshop");

        return emailContent.toString();
    }
}
