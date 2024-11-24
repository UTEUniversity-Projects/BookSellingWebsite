package com.biblio.controller.staff;

import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.entity.Book;
import com.biblio.entity.MediaFile;
import com.biblio.entity.Promotion;
import com.biblio.entity.Order;
import com.biblio.entity.OrderItem;
import com.biblio.service.IEmailService;
import com.biblio.service.IOrderService;
import com.biblio.service.impl.EmailServiceImpl;
import com.biblio.service.impl.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.biblio.utils.DateTimeUtil.formatDateTime;

@WebServlet(name = "ConfirmOrderEmailController", urlPatterns = {"/api/order/send-email"})
public class ConfirmOrderEmailController extends HttpServlet {

    private final IEmailService emailService = new EmailServiceImpl();
    private final IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            String emailContent = generateOrderEmail(order/*,finalPrice*/);
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
    private String generateOrderEmail(OrderCustomerResponse order) {
        StringBuilder emailContent = new StringBuilder();

        // Bắt đầu HTML
        emailContent.append("<html><body>");
        emailContent.append("<p>Kính gửi ").append(order.getCustomerName()).append(",</p>");
        emailContent.append("<p>Cảm ơn bạn đã đặt hàng tại <b>Biblio Bookshop</b>.</p>");

        // Thông tin đơn hàng
        emailContent.append("<p><b>Thông tin chi tiết đơn hàng:</b></p>");
        emailContent.append("<hr>");
        emailContent.append("<p>Mã đơn hàng: ").append(order.getId()).append("</p>");
        emailContent.append("<p>Ngày đặt hàng: ").append(formatDateTime(order.getOrderDate(), "dd-MM-yyyy HH:mm")).append("</p>");
        emailContent.append("<p>Trạng thái: ").append(order.getStatus()).append("</p>");

        // Sản phẩm
        emailContent.append("<p><b>Sản phẩm:</b></p>");

        // Tạo một Map để nhóm các cuốn sách giống nhau
        Map<String, Integer> bookCountMap = new HashMap<>();
        emailContent.append("Sản phẩm:\n");
        for (OrderItem item : order.getOrderItems()) {
            for (Book book : item.getBooks()) {
                String bookTitle = book.getTitle();  // Tên sách
                bookCountMap.put(bookTitle, bookCountMap.getOrDefault(bookTitle, 0) + 1);
            }
        }

        // Hiển thị các sách với số lượng
        for (Map.Entry<String, Integer> entry : bookCountMap.entrySet()) {
            String bookTitle = entry.getKey();
            int quantity = entry.getValue();

            // Lấy giá của sách
            int bookPrice = 0; // Định nghĩa kiểu int thay vì double
            for (LineItem item : order.getLineItems()) {
                for (Book book : item.getBooks()) {
                    if (book.getTitle().equals(bookTitle)) {
                        bookPrice = (int) book.getSellingPrice(); // Ép kiểu giá từ double sang int
                        break;
                    }
                }
            }


            // Lấy hình ảnh cho sách
            List<MediaFile> mediaFiles = order.getLineItems().stream()
                    .flatMap(item -> item.getBooks().stream())
                    .filter(book -> book.getTitle().equals(bookTitle))
                    .findFirst()
                    .map(book -> book.getBookTemplate().getMediaFiles())
                    .orElse(Collections.emptyList());

            if (!mediaFiles.isEmpty()) {
                MediaFile mediaFile = mediaFiles.get(0);
                emailContent.append("<p>- ").append(bookTitle)
                        .append(" (Giá: ").append(bookPrice).append(" VND) x ")
                        .append(quantity).append("</p>");
                emailContent.append("<img src=\"")
                        .append(mediaFile.getImagePath())
                        .append("\" alt=\"").append(bookTitle)
                        .append("\" style=\"width: 100px; height: auto;\"/><br>");
            }
        }

        // Tổng giá trị và VAT
        emailContent.append("<p>Tổng tiền hàng: ").append((int)order.calTotalPrice()).append(" VND</p>");
        emailContent.append("<p>Thuế VAT: ").append(order.getVat()).append("%</p>");

        // Khuyến mãi áp dụng
        if (order.getPromotions() != null && !order.getPromotions().isEmpty()) {
            emailContent.append("<p><b>Khuyến mãi áp dụng:</b></p>");
            for (Promotion promo : order.getPromotions()) {
                emailContent.append("<p>- ").append(promo.getDescription()).append("</p>");
            }
        }

        // Phương thức thanh toán và địa chỉ giao hàng
        emailContent.append("<p>Phương thức thanh toán: ").append(order.getPaymentType()).append("</p>");
        if (order.getAddress() != null) {
            emailContent.append("<p>Địa chỉ giao hàng: ").append(order.getAddress()).append("</p>");
        }

        // Ghi chú
        if (order.getNote() != null && !order.getNote().isEmpty()) {
            emailContent.append("<p>Ghi chú: ").append(order.getNote()).append("</p>");
        }

        emailContent.append("<hr>");
        emailContent.append("<p>Nếu bạn có bất kỳ thắc mắc nào, vui lòng liên hệ với chúng tôi qua email: <b>biblio@gmail.com</b>.</p>");
        emailContent.append("<p>Trân trọng,</p>");
        emailContent.append("<p><b>Biblio Bookshop</b></p>");

        // Kết thúc HTML
        emailContent.append("</body></html>");

        return emailContent.toString();
    }
  
}
