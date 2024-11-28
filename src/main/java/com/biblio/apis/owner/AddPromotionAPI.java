package com.biblio.apis.owner;

import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.dto.response.PromotionTemplateResponse;
import com.biblio.service.ICustomerService;
import com.biblio.service.IEmailService;
import com.biblio.service.IPromotionTemplateService;
import com.biblio.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/owner/promotion/add"})
public class AddPromotionAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private IPromotionTemplateService promotionTemplateService;

    @Inject
    private IEmailService emailService;

    @Inject
    private ICustomerService customerService;

    public AddPromotionAPI() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Parse JSON request to PromotionInsertRequest model
        PromotionTemplateInsertRequest promotionTemplateInsertRequest = HttpUtil.of(request.getReader()).toModel(PromotionTemplateInsertRequest.class);

        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Boolean isExitsCode = promotionTemplateService.isCodeExisted(promotionTemplateInsertRequest.getCode());
            if (isExitsCode) {
                map.put("isCodeExisted", true);
                map.put("message", "Code is existed");
            } else {
                PromotionTemplateResponse promotionTemplateResponse = promotionTemplateService.insertPromotionTemplate(promotionTemplateInsertRequest);
                map.put("isCodeExisted", false);
                map.put("message", "Promotion added successfully");

                for (Long i = 1L; i<=5; i++) {
                    CustomerDetailResponse customer = customerService.findById(i);
                    String emailContent = generatePromotionEmail(promotionTemplateResponse, customer);
                    String subject = "Chương trình khuyến mãi: " + promotionTemplateResponse.getPromotions().iterator().next().getTitle();
                    emailService.sendEmailNoRePlay(customer.getEmail(), subject, emailContent);
                }
            }
        } catch (Exception e) {
            map.put("isCodeExisted", false); // Không kiểm tra mã nên vẫn là false
            map.put("message", "Failed to add promotion: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        // Send JSON response
        response.getWriter().write(mapper.writeValueAsString(map));
    }


    public String generatePromotionEmail(PromotionTemplateResponse promotionTemplateResponse, CustomerDetailResponse customer) {
        StringBuilder emailContent = new StringBuilder();

        // Định dạng ngày giờ mới
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        try {
            // Lấy chuỗi ngày hiệu lực và ngày hết hạn từ response
            String effectiveDateString = promotionTemplateResponse.getPromotions().iterator().next().getEffectiveDate();
            String expirationDateString = promotionTemplateResponse.getPromotions().iterator().next().getExpirationDate();

            // Chuyển đổi chuỗi thành LocalDateTime
            LocalDateTime effectiveDate = LocalDateTime.parse(effectiveDateString, formatter);
            LocalDateTime expirationDate = LocalDateTime.parse(expirationDateString, formatter);

            // Chuyển đổi thành múi giờ Việt Nam
            effectiveDate = effectiveDate.atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDateTime();
            expirationDate = expirationDate.atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDateTime();

            // Định dạng ngày giờ thành "dd-MM-yyyy HH:mm"
            String effectiveDateFormatted = effectiveDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            String expirationDateFormatted = expirationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

            // Định dạng tiền tệ (VND)
            DecimalFormat currencyFormat = new DecimalFormat("#,###");
            String discountLimit = currencyFormat.format(promotionTemplateResponse.getPromotions().iterator().next().getDiscountLimit()) + " VND";
            String minValueApplied = currencyFormat.format(promotionTemplateResponse.getPromotions().iterator().next().getMinValueApplied()) + " VND";

            emailContent.append("<html><body>");

            emailContent.append("<p>Kính gửi ").append(customer.getFullName()).append(",</p>");
            emailContent.append("<p>Chúng tôi vui mừng giới thiệu chương trình khuyến mãi mới:</p>");

            emailContent.append("<hr>");
            emailContent.append("<p><b>Tiêu đề:</b> ").append(promotionTemplateResponse.getPromotions().iterator().next().getTitle()).append("</p>");
            emailContent.append("<p><b>Loại:</b> ").append(promotionTemplateResponse.getType()).append("</p>");
            emailContent.append("<p><b>Mã:</b> ").append(promotionTemplateResponse.getCode()).append("</p>");
            emailContent.append("<p><b>Mô tả:</b> ").append(promotionTemplateResponse.getPromotions().iterator().next().getDescription()).append("</p>");
            emailContent.append("<p><b>Thời gian hiệu lực:</b> từ ").append(effectiveDateFormatted)
                    .append(" đến ").append(expirationDateFormatted).append("</p>");

            if (promotionTemplateResponse.getPromotions().iterator().next().getDiscountLimit() > 0) {
                emailContent.append("<p><b>Giảm:</b> ").append(discountLimit).append("</p>");
            }

            if (promotionTemplateResponse.getPromotions().iterator().next().getMinValueApplied() > 0) {
                emailContent.append("<p><b>Áp dụng cho đơn hàng từ:</b> ").append(minValueApplied).append("</p>");
            }

            emailContent.append("<hr>");
            emailContent.append("<p>Hãy nhanh tay tham gia chương trình khuyến mãi này trước khi hết hạn!</p>");

            emailContent.append("<p>Cảm ơn quý khách!,</p>");
            emailContent.append("<p><b>Biblio</b></p>");

            emailContent.append("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi khi ngày giờ không hợp lệ
        }

        return emailContent.toString();
    }


}

