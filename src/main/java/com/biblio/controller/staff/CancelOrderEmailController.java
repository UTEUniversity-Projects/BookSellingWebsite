package com.biblio.controller.staff;

import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.service.IEmailService;
import com.biblio.service.IOrderService;
import com.biblio.service.impl.EmailServiceImpl;
import com.biblio.service.impl.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static com.biblio.utils.DateTimeUtil.formatDateTime;

@WebServlet(name = "CancelOrderEmailController", urlPatterns = {"/api/order/cancel-email"})
public class CancelOrderEmailController extends HttpServlet {

    private final IEmailService emailService = new EmailServiceImpl();
    private final IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            // Đặt mã hóa cho request để xử lý tiếng Việt đúng cách
            request.setCharacterEncoding("UTF-8");

            String orderIdParam = request.getParameter("orderId");
            String cancelContent = request.getParameter("cancelContent");
            if (orderIdParam == null || orderIdParam.isEmpty()) {
                throw new IllegalArgumentException("Order ID không được để trống.");
            }

            long orderId = Long.parseLong(orderIdParam);

            // Lấy thông tin đơn hàng
            OrderCustomerResponse order = orderService.findOrderById(orderId);
            if (order == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"message\": \"Không tìm thấy đơn hàng với ID: " + orderId + "\"}");
                return;
            }

            // Gửi email thông báo
            String emailContent = generateCancelOrderEmail(order, cancelContent);
            emailService.sendEmail(order.getEmail(), "Hủy đơn hàng #" + order.getId(), emailContent);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Hủy đơn hàng thành công và email đã được gửi.\"}");

        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"Đã xảy ra lỗi: " + e.getMessage() + "\"}");
        }
    }

    // Hàm tạo nội dung email thông báo hủy đơn hàng
    private String generateCancelOrderEmail(OrderCustomerResponse order, String cancelContent) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("<html><body>");
        emailContent.append("<p>Kính gửi <strong>").append(order.getCustomerName()).append("</strong>,</p>");
        emailContent.append("<p>Chúng tôi rất tiếc phải thông báo rằng đơn hàng của bạn đã bị hủy.</p>");
        emailContent.append("<p><strong>Lý do:</strong> ").append(cancelContent).append(".</p>");
        emailContent.append("<p><strong>Thông tin chi tiết đơn hàng:</strong></p>");
        emailContent.append("<hr>");
        emailContent.append("<p><strong>Mã đơn hàng:</strong> ").append(order.getId()).append("</p>");
        emailContent.append("<p><strong>Ngày đặt hàng:</strong> ").append(formatDateTime(LocalDateTime.parse(order.getOrderDate()), "dd-MM-yyyy HH:mm")).append("</p>");
        emailContent.append("<p><strong>Trạng thái:</strong> Đã hủy</p>");
        emailContent.append("<hr>");
        emailContent.append("<p>Chúng tôi sẽ hoàn tiền sớm nhất cho bạn.</p>");
        emailContent.append("<p>Nếu bạn cần hỗ trợ thêm, vui lòng liên hệ với chúng tôi qua email <a href=\"mailto:biblio@gmail.com\">biblio@gmail.com</a>.</p>");
        emailContent.append("<p>Mong nhận được sự thông cảm từ quý khách, chúc quý khách mội ngày tốt lành,<br>Biblio Bookshop</p>");
        emailContent.append("</body></html>");

        return emailContent.toString();
    }

}
