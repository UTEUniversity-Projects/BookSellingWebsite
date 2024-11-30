package com.biblio.apis.staff;

import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.entity.Book;
import com.biblio.entity.OrderItem;
import com.biblio.service.IEmailService;
import com.biblio.service.impl.EmailServiceImpl;
import com.biblio.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.biblio.utils.DateTimeUtil.formatDateTime;

@WebServlet(urlPatterns = {"/staff/email/*"})
public class SendEmailAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private OrderServiceImpl orderService;
    private final IEmailService emailService = new EmailServiceImpl();
    public SendEmailAPI() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getPathInfo(); // Lấy action từ URL
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> result = new HashMap<>();

        try {
            switch (action) {
                case "/order-confirmation":
                    doPost_ConfirmOrder(request, response);
                    break;

                case "/order-cancellation":
                    doPost_CancelOrder(request, response);
                    break;
                case "/refund-cancellation":
                    doPost_SendCancelRefundOrderEmail(request, response);
                    break;

                case "/refund-confirmation":
                    doPost_SendConfirmRefundOrderEmail(request, response);
                    break;

                default:
                    result.put("message", "Hành động không được hỗ trợ!");
                    result.put("type", "error");
                    response.getWriter().write(mapper.writeValueAsString(result));
                    break;
            }
        } catch (Exception e) {
            result.put("message", "Có lỗi xảy ra khi xử lý yêu cầu.");
            result.put("type", "error");
            response.getWriter().write(mapper.writeValueAsString(result));
        }
    }

    protected void doPost_ConfirmOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println("....");
        try {
            String orderIdParam = request.getParameter("orderId");
            String finalPriceParam = request.getParameter("finalPrice");
            System.out.println("finalPrice: " + finalPriceParam);
            if (orderIdParam == null || orderIdParam.isEmpty()) {
                throw new IllegalArgumentException("Order ID không được để trống.");
            }
            System.out.println(orderIdParam);
            long orderId = Long.parseLong(orderIdParam);
            /*Double finalPrice = Double.parseDouble(finalPriceParam);*/
            System.out.println(orderId);
            // Lấy thông tin đơn hàng
            OrderCustomerResponse order = orderService.findOrderById(orderId);
            if (order == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"message\": \"Không tìm thấy đơn hàng với ID: " + orderId + "\"}");
                return;
            }
            // Gửi email
            String emailContent = generateOrderEmail(request,order/*,finalPrice*/);
            System.out.println(emailContent);

            emailService.sendEmail(order.getEmail(), "Xác nhận đơn hàng #" + order.getId(), emailContent);

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
    private String generateOrderEmail(HttpServletRequest request, OrderCustomerResponse order) {
        StringBuilder emailContent = new StringBuilder();

        // Bắt đầu HTML
        emailContent.append("<html><body style=\"font-family: Arial, sans-serif; color: #333; line-height: 1.6;\">");
        emailContent.append("<div style=\"max-width: 600px; margin: auto; border: 1px solid #ddd; border-radius: 10px; padding: 20px; background-color: #f9f9f9;\">");

        // Header
        emailContent.append("<div style=\"text-align: center;\">");
        emailContent.append("<img src=\"https://scontent.fsgn8-4.fna.fbcdn.net/v/t39.30808-6/468703611_1664827497410053_3942884439111183245_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=127cfc&_nc_ohc=zXw3uGs7ZsEQ7kNvgEXUmAZ&_nc_zt=23&_nc_ht=scontent.fsgn8-4.fna&_nc_gid=A2ITxhjZT2QDYgdmlw7QjNT&oh=00_AYBn-1ZCU7YRtTLovzTu7xEwxk-NF3FUYThFLp0dVmgKBg&oe=674DF1D9\" alt=\"logo\" style=\"width: 150px; height: auto;\"/>");
        emailContent.append("<h1 style=\"color: #d35400;\">Biblio Bookshop</h1>");
        emailContent.append("</div>");

        emailContent.append("<p>Chào <b>").append(order.getCustomerName()).append("</b>,</p>");
        emailContent.append("<p>Cảm ơn bạn đã mua sắm tại <b>Biblio Bookshop</b>! Dưới đây là thông tin chi tiết về đơn hàng của bạn:</p>");

        // Thông tin đơn hàng
        emailContent.append("<table style=\"width: 100%; border-collapse: collapse; margin: 20px 0;\">");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\"><b>Mã đơn hàng:</b></td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(order.getId()).append("</td></tr>");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\"><b>Ngày đặt hàng:</b></td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(formatDateTime(LocalDateTime.parse(order.getOrderDate()), "dd-MM-yyyy HH:mm")).append("</td></tr>");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\"><b>Trạng thái:</b></td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(order.getStatus()).append("</td></tr>");
        emailContent.append("</table>");

        // Danh sách sản phẩm
        emailContent.append("<h3 style=\"color: #d35400;\">Sản phẩm trong đơn hàng:</h3>");
        emailContent.append("<table style=\"width: 100%; border-collapse: collapse;\">");
        emailContent.append("<tr style=\"background-color: #f2f2f2;\">");
        emailContent.append("<th style=\"padding: 10px; border: 1px solid #ddd; text-align: left;\">Tên sách</th>");
        emailContent.append("<th style=\"padding: 10px; border: 1px solid #ddd; text-align: left;\">Số lượng</th>");
        emailContent.append("<th style=\"padding: 10px; border: 1px solid #ddd; text-align: left;\">Giá (VND)</th>");
        emailContent.append("</tr>");

        Map<String, Integer> bookCountMap = new HashMap<>();
        for (OrderItem item : order.getLineItems()) {
            for (Book book : item.getBooks()) {
                String bookTitle = book.getTitle();
                bookCountMap.put(bookTitle, bookCountMap.getOrDefault(bookTitle, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : bookCountMap.entrySet()) {
            String bookTitle = entry.getKey();
            int quantity = entry.getValue();
            int bookPrice = 0;

            for (OrderItem item : order.getLineItems()) {
                for (Book book : item.getBooks()) {
                    if (book.getTitle().equals(bookTitle)) {
                        bookPrice = (int) book.getSellingPrice();
                        break;
                    }
                }
            }

            emailContent.append("<tr>");
            emailContent.append("<td style=\"padding: 10px; border: 1px solid #ddd;\">").append(bookTitle).append("</td>");
            emailContent.append("<td style=\"padding: 10px; border: 1px solid #ddd;\">").append(quantity).append("</td>");
            emailContent.append("<td style=\"padding: 10px; border: 1px solid #ddd;\">").append(bookPrice).append("</td>");
            emailContent.append("</tr>");
        }
        emailContent.append("</table>");

        // Tổng giá trị và VAT
        emailContent.append("<h3 style=\"color: #d35400;\">Tổng cộng:</h3>");
        emailContent.append("<p><b>Tổng tiền hàng:</b> ").append((int) order.calTotalPrice()).append(" VND</p>");
        emailContent.append("<p><b>Thuế VAT:</b> ").append(order.getVat()).append("%</p>");

        // Footer
        emailContent.append("<hr>");
        emailContent.append("<p style=\"text-align: center;\">Cảm ơn bạn đã tin tưởng và ủng hộ <b>Biblio Bookshop</b>. Nếu có bất kỳ thắc mắc nào, vui lòng liên hệ qua email: <a href=\"mailto: support@biblio.com\">support@biblio.com</a>.</p>");
        emailContent.append("</div>");

        // Kết thúc HTML
        emailContent.append("</body></html>");

        return emailContent.toString();
    }


    protected void doPost_CancelOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

        // Bắt đầu HTML
        emailContent.append("<html><body style=\"font-family: Arial, sans-serif; color: #333; line-height: 1.6;\">");
        emailContent.append("<div style=\"max-width: 600px; margin: auto; border: 1px solid #ddd; border-radius: 10px; padding: 20px; background-color: #f9f9f9;\">");

        // Header
        emailContent.append("<div style=\"text-align: center;\">");
        emailContent.append("<img src=\"https://scontent.fsgn8-4.fna.fbcdn.net/v/t39.30808-6/468703611_1664827497410053_3942884439111183245_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=127cfc&_nc_ohc=zXw3uGs7ZsEQ7kNvgEXUmAZ&_nc_zt=23&_nc_ht=scontent.fsgn8-4.fna&_nc_gid=A2ITxhjZT2QDYgdmlw7QjNT&oh=00_AYBn-1ZCU7YRtTLovzTu7xEwxk-NF3FUYThFLp0dVmgKBg&oe=674DF1D9\" alt=\"logo\" style=\"width: 150px; height: auto;\"/>");
        emailContent.append("<h1 style=\"color: #d35400;\">Biblio Bookshop</h1>");
        emailContent.append("</div>");

        // Nội dung chính
        emailContent.append("<p>Chào <strong>").append(order.getCustomerName()).append("</strong>,</p>");
        emailContent.append("<p style=\"color: #e74c3c; font-size: 16px;\"><strong>Chúng tôi rất tiếc phải thông báo rằng đơn hàng của bạn đã bị hủy.</strong></p>");
        emailContent.append("<p><strong>Lý do:</strong> ").append(cancelContent).append("</p>");

        emailContent.append("<h3 style=\"color: #d35400;\">Thông tin chi tiết đơn hàng:</h3>");
        emailContent.append("<table style=\"width: 100%; border-collapse: collapse; margin: 20px 0;\">");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\">Mã đơn hàng:</td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(order.getId()).append("</td></tr>");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\">Ngày đặt hàng:</td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(formatDateTime(LocalDateTime.parse(order.getOrderDate()), "dd-MM-yyyy HH:mm")).append("</td></tr>");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\">Trạng thái:</td><td style=\"padding: 10px; border: 1px solid #ddd; color: #e74c3c;\"><strong>Đã hủy</strong></td></tr>");
        emailContent.append("</table>");

        // Thông báo hoàn tiền
        emailContent.append("<p><strong>Chúng tôi sẽ hoàn tiền sớm nhất cho bạn.</strong></p>");
        emailContent.append("<p>Nếu bạn cần hỗ trợ thêm, vui lòng liên hệ với chúng tôi qua email: <a href=\"mailto: support@biblio.com\" style=\"color: #3498db; text-decoration: none;\">support@biblio.com</a>.</p>");

        // Footer
        emailContent.append("<hr style=\"border: none; border-top: 1px solid #ddd; margin: 20px 0;\">");
        emailContent.append("<p style=\"text-align: center;\">Cảm ơn bạn đã tin tưởng và đồng hành cùng <strong>Biblio Bookshop</strong>. Chúng tôi mong được phục vụ bạn trong tương lai.</p>");
        emailContent.append("<p style=\"text-align: center;\">Chúc bạn một ngày tốt lành,</p>");
        emailContent.append("<p style=\"text-align: center; font-weight: bold;\">Biblio Bookshop</p>");

        // Kết thúc HTML
        emailContent.append("</div>");
        emailContent.append("</body></html>");

        return emailContent.toString();
    }

    protected void doPost_SendCancelRefundOrderEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
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

            // Gửi email thông báo hủy yêu cầu hoàn tiền
            String emailContent = generateCancelRefundOrderEmail(order, cancelContent);
            emailService.sendEmail(order.getEmail(), "Hủy yêu cầu hoàn tiền #" + order.getId(), emailContent);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Hủy yêu cầu hoàn tiền thành công và email đã được gửi.\"}");

        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"Đã xảy ra lỗi: " + e.getMessage() + "\"}");
        }
    }

    private String generateCancelRefundOrderEmail(OrderCustomerResponse order, String cancelContent) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("<html><body style=\"font-family: Arial, sans-serif; color: #333; line-height: 1.6;\">");
        emailContent.append("<div style=\"max-width: 600px; margin: auto; border: 1px solid #ddd; border-radius: 10px; padding: 20px; background-color: #f9f9f9;\">");

        emailContent.append("<div style=\"text-align: center;\">");
        emailContent.append("<img src=\"https://scontent.fsgn8-4.fna.fbcdn.net/v/t39.30808-6/468703611_1664827497410053_3942884439111183245_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=127cfc&_nc_ohc=zXw3uGs7ZsEQ7kNvgEXUmAZ&_nc_zt=23&_nc_ht=scontent.fsgn8-4.fna&_nc_gid=A2ITxhjZT2QDYgdmlw7QjNT&oh=00_AYBn-1ZCU7YRtTLovzTu7xEwxk-NF3FUYThFLp0dVmgKBg&oe=674DF1D9\" alt=\"logo\" style=\"width: 150px; height: auto;\"/>");
        emailContent.append("<h1 style=\"color: #d35400;\">Biblio Bookshop</h1>");
        emailContent.append("</div>");

        emailContent.append("<p>Chào <strong>").append(order.getCustomerName()).append("</strong>,</p>");
        emailContent.append("<p style=\"color: #e74c3c; font-size: 16px;\"><strong>Yêu cầu hoàn tiền của bạn đã bị hủy.</strong></p>");
        emailContent.append("<p><strong>Lý do:</strong> ").append(cancelContent).append("</p>");

        emailContent.append("<table style=\"width: 100%; border-collapse: collapse; margin: 20px 0;\">");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\">Mã đơn hàng:</td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(order.getId()).append("</td></tr>");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\">Ngày đặt hàng:</td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(formatDateTime(LocalDateTime.parse(order.getOrderDate()), "dd-MM-yyyy HH:mm")).append("</td></tr>");
        emailContent.append("</table>");

        emailContent.append("<p>Nếu bạn cần hỗ trợ thêm, vui lòng liên hệ với chúng tôi qua email: <a href=\"mailto: support@biblio.com\">support@biblio.com</a>.</p>");

        emailContent.append("<hr style=\"border: none; border-top: 1px solid #ddd; margin: 20px 0;\">");
        emailContent.append("<p style=\"text-align: center;\">Cảm ơn bạn đã đồng hành cùng <strong>Biblio Bookshop</strong>.</p>");
        emailContent.append("</div>");
        emailContent.append("</body></html>");

        return emailContent.toString();
    }

    protected void doPost_SendConfirmRefundOrderEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            request.setCharacterEncoding("UTF-8");

            String orderIdParam = request.getParameter("orderId");
            String refundAmountParam = request.getParameter("refundAmount");

            if (orderIdParam == null || orderIdParam.isEmpty()) {
                throw new IllegalArgumentException("Order ID không được để trống.");
            }

            long orderId = Long.parseLong(orderIdParam);
            double refundAmount = Double.parseDouble(refundAmountParam);

            // Lấy thông tin đơn hàng
            OrderCustomerResponse order = orderService.findOrderById(orderId);
            if (order == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"message\": \"Không tìm thấy đơn hàng với ID: " + orderId + "\"}");
                return;
            }

            // Gửi email xác nhận hoàn tiền
            String emailContent = generateConfirmRefundOrderEmail(order, refundAmount);
            emailService.sendEmail(order.getEmail(), "Xác nhận hoàn tiền #" + order.getId(), emailContent);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Xác nhận hoàn tiền thành công và email đã được gửi.\"}");

        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"Đã xảy ra lỗi: " + e.getMessage() + "\"}");
        }
    }


    private String generateConfirmRefundOrderEmail(OrderCustomerResponse order, double refundAmount) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("<html><body style=\"font-family: Arial, sans-serif; color: #333; line-height: 1.6;\">");
        emailContent.append("<div style=\"max-width: 600px; margin: auto; border: 1px solid #ddd; border-radius: 10px; padding: 20px; background-color: #f9f9f9;\">");

        emailContent.append("<div style=\"text-align: center;\">");
        emailContent.append("<img src=\"https://scontent.fsgn8-4.fna.fbcdn.net/v/t39.30808-6/468703611_1664827497410053_3942884439111183245_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=127cfc&_nc_ohc=zXw3uGs7ZsEQ7kNvgEXUmAZ&_nc_zt=23&_nc_ht=scontent.fsgn8-4.fna&_nc_gid=A2ITxhjZT2QDYgdmlw7QjNT&oh=00_AYBn-1ZCU7YRtTLovzTu7xEwxk-NF3FUYThFLp0dVmgKBg&oe=674DF1D9\" alt=\"logo\" style=\"width: 150px; height: auto;\"/>");
        emailContent.append("<h1 style=\"color: #d35400;\">Biblio Bookshop</h1>");
        emailContent.append("</div>");

        emailContent.append("<p>Chào <strong>").append(order.getCustomerName()).append("</strong>,</p>");
        emailContent.append("<p style=\"color: #27ae60; font-size: 16px;\"><strong>Chúng tôi đã xử lý yêu cầu hoàn tiền của bạn.</strong></p>");
        emailContent.append("<p><strong>Số tiền được hoàn:</strong> ").append(refundAmount).append(" VND</p>");

        emailContent.append("<table style=\"width: 100%; border-collapse: collapse; margin: 20px 0;\">");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\">Mã đơn hàng:</td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(order.getId()).append("</td></tr>");
        emailContent.append("<tr><td style=\"padding: 10px; border: 1px solid #ddd;\">Ngày đặt hàng:</td><td style=\"padding: 10px; border: 1px solid #ddd;\">").append(formatDateTime(LocalDateTime.parse(order.getOrderDate()), "dd-MM-yyyy HH:mm")).append("</td></tr>");
        emailContent.append("</table>");

        emailContent.append("<p>Nếu bạn có bất kỳ thắc mắc nào, vui lòng liên hệ với chúng tôi qua email: <a href=\"mailto: support@biblio.com\">support@biblio.com</a>.</p>");

        emailContent.append("<hr style=\"border: none; border-top: 1px solid #ddd; margin: 20px 0;\">");
        emailContent.append("<p style=\"text-align: center;\">Cảm ơn bạn đã tin tưởng <strong>Biblio Bookshop</strong>.</p>");
        emailContent.append("</div>");
        emailContent.append("</body></html>");

        return emailContent.toString();
    }

}
