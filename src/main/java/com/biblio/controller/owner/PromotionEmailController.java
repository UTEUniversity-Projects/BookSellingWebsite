package com.biblio.controller.owner;

import com.biblio.entity.Customer;
import com.biblio.entity.Promotion;
import com.biblio.service.ICustomerService;
import com.biblio.service.IEmailService;
import com.biblio.service.IPromotionService;
import com.biblio.service.impl.CustomerServiceImpl;
import com.biblio.service.impl.EmailServiceImpl;
import com.biblio.service.impl.PromotionServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PromotionEmailController", urlPatterns = {"/api/promotion/send-email"})
public class PromotionEmailController extends HttpServlet {

    private final IEmailService emailService = new EmailServiceImpl(); // Dịch vụ gửi email
    private final IPromotionService promotionService = new PromotionServiceImpl(); // Dịch vụ xử lý khuyến mãi
    private final ICustomerService customerService = new CustomerServiceImpl(); // Dịch vụ lấy thông tin khách hàng

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            // Lấy thông tin promotionId từ request
            String promotionIdParam = request.getParameter("promotionId");
            if (promotionIdParam == null || promotionIdParam.isEmpty()) {
                throw new IllegalArgumentException("Promotion ID không được để trống.");
            }

            long promotionId = Long.parseLong(promotionIdParam);

            // Lấy thông tin khuyến mãi từ PromotionService
            Promotion promotion = promotionService.findPromotionById(promotionId);
            if (promotion == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"message\": \"Không tìm thấy khuyến mãi với ID: " + promotionId + "\"}");
                return;
            }

            // Lấy danh sách khách hàng sẽ nhận email
            List<Customer> customers = customerService.findAllCustomers(); // Lấy tất cả khách hàng hoặc theo nhóm cụ thể

            // Gửi email cho từng khách hàng
            for (Customer customer : customers) {
                String emailContent = generatePromotionEmail(promotion, customer);
                String subject = "Chương trình khuyến mãi: " + promotion.getTitle();
                emailService.sendEmail(customer.getEmailAddress(), subject, emailContent);
            }

            // Phản hồi lại client
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Email thông báo khuyến mãi đã được gửi thành công.\"}");

        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"Lỗi: " + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"Đã xảy ra lỗi khi gửi email: " + e.getMessage() + "\"}");
        }
    }

    // Hàm tạo nội dung email từ thông tin Promotion
    private String generatePromotionEmail(Promotion promotion, Customer customer) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("Kính gửi ").append(customer.getFullName()).append(",\n\n");
        emailContent.append("Chúng tôi vui mừng giới thiệu chương trình khuyến mãi mới:\n");
        emailContent.append("---------------------------------------------------\n");
        emailContent.append("Tiêu đề: ").append(promotion.getTitle()).append("\n");
        emailContent.append("Mô tả: ").append(promotion.getDescription()).append("\n");
        emailContent.append("Thời gian hiệu lực: từ ").append(promotion.getEffectiveDate())
                .append(" đến ").append(promotion.getExpirationDate()).append("\n");
        emailContent.append("Giảm giá: ").append(promotion.getPercentDiscount()).append("%\n");

        if (promotion.getDiscountLimit() > 0) {
            emailContent.append("Giới hạn giảm giá: ").append(promotion.getDiscountLimit()).append(" VND\n");
        }

        if (promotion.getMinValueToBeApplied() > 0) {
            emailContent.append("Áp dụng cho đơn hàng từ: ").append(promotion.getMinValueToBeApplied()).append(" VND\n");
        }

        emailContent.append("---------------------------------------------------\n");
        emailContent.append("Hãy nhanh tay tham gia chương trình khuyến mãi này trước khi hết hạn!\n\n");
        emailContent.append("Trân trọng,\n");
        emailContent.append("[Tên Shop]");

        return emailContent.toString();
    }
}
