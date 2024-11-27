package com.biblio.controller.customer;

import com.biblio.dto.request.VerifyEmailRequest;
import com.biblio.service.ICustomerService;
import com.biblio.service.IEmailService;
import com.biblio.utils.HttpUtil;
import com.biblio.utils.SendMailUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyEmailController
 */
@WebServlet("/verify-email")
public class VerifyEmailController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private ICustomerService customerService;

    @Inject
    private IEmailService emailService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("breadcrumb", "Xác thực email");
        request.getRequestDispatcher("/views/customer/verify-email.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        VerifyEmailRequest verifyEmailRequest = HttpUtil.of(request.getReader()).toModel(VerifyEmailRequest.class);

        Map<String, Object> map = new HashMap<>();

        boolean isEmailExisted = customerService.isEmailExisted(verifyEmailRequest.getEmail());
        if (isEmailExisted) {
            map.put("code", 400);
            map.put("message", "Email đã tồn tại !");
        } else {
            String optCode = SendMailUtil.generateOTP();
            long otpTimestamp = System.currentTimeMillis();
            request.getSession().setAttribute("otpCode", optCode);
            request.getSession().setAttribute("otpTimestamp", otpTimestamp);
            request.getSession().setAttribute("otpEmail", verifyEmailRequest.getEmail());
            String emailContent = generateOtpVerificationEmail(optCode);
            try {
                emailService.sendEmail(verifyEmailRequest.getEmail(), "Xác thực email của bạn", emailContent);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            map.put("code", 200);
            map.put("message", "Mã OTP đã được gửi đến email của bạn!");
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mapper.writeValueAsString(map));
    }

    private String generateOtpVerificationEmail(String otpCode) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("<html><body>");
        emailContent.append("<p>Chào bạn,</p>");
        emailContent.append("<p>Cảm ơn bạn đã đăng ký tài khoản tại Biblio Bookshop!</p>");
        emailContent.append("<p><strong>Mã OTP của bạn là:</strong> <span style=\"font-size: 18px; font-weight: bold; color: #4CAF50;\">")
                .append(otpCode).append("</span></p>");
        emailContent.append("<p>Mã này có hiệu lực trong <strong>2 phút</strong>. Vui lòng không chia sẻ mã này với bất kỳ ai.</p>");
        emailContent.append("<hr>");
        emailContent.append("<p>Nếu cần hỗ trợ thêm, vui lòng liên hệ với chúng tôi qua email <a href=\"mailto:support@biblio.com\">support@biblio.com</a>.</p>");
        emailContent.append("<p>Trân trọng,<br>Biblio Bookshop</p>");
        emailContent.append("</body></html>");

        return emailContent.toString();
    }
}
