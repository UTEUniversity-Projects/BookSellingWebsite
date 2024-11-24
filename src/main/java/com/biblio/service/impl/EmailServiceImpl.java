package com.biblio.service.impl;

import com.biblio.service.IEmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImpl implements IEmailService {
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String USERNAME = "vubaolong1484@gmail.com";
    private static final String PASSWORD = "cezztfksvcvwnibn";

    private Session createEmailSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Đảm bảo sử dụng TLS 1.2
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);

        return Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }


    @Override
    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        Session session = createEmailSession();
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USERNAME));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject, "UTF-8");
        message.setContent(body, "text/html; charset=UTF-8");

        Transport.send(message);
    }


    @Override
    public String getPromotionEmail(String customerName, String promotionDetails) {
        return "<html>" +
                "<body>" +
                "<p>Kính gửi " + customerName + ",</p>" +
                "<p>Chúng tôi vui mừng thông báo chương trình khuyến mãi mới:</p>" +
                "<p><strong>" + promotionDetails + "</strong></p>" +
                "<p>Nhanh tay tham gia để nhận ưu đãi hấp dẫn!</p>" +
                "<p>Trân trọng,<br>Biblio BookShop</p>" +
                "</body>" +
                "</html>";
    }

    @Override
    public String getWelcomeEmail(String customerName) {
        return "<html>" +
                "<body>" +
                "<p>Chào mừng " + customerName + ",</p>" +
                "<p>Cảm ơn bạn đã đăng ký tài khoản với chúng tôi.</p>" +
                "<p>Trân trọng,<br>Biblio BookShop</p>" +
                "</body>" +
                "</html>";
    }

    @Override
    public String getAccountLockEmail(String customerName) {
        return "<html>" +
                "<body>" +
                "<p>Kính gửi " + customerName + ",</p>" +
                "<p>Tài khoản của bạn đã bị khóa tạm thời.</p>" +
                "<p>Những phản hồi/khiếu nại vui lòng gửi đến email <a href=\"mailto:biblio@gmail.com\">biblio@gmail.com</a>.</p>" +
                "<p>Trân trọng,<br>Biblio BookShop</p>" +
                "</body>" +
                "</html>";
    }

    @Override
    public String getAccountUnlockEmail(String customerName) {
        return "<html>" +
                "<body>" +
                "<p>Kính gửi " + customerName + ",</p>" +
                "<p>Tài khoản của bạn đã được mở khóa.</p>" +
                "<p>Trân trọng,<br>Biblio BookShop</p>" +
                "</body>" +
                "</html>";
    }

    @Override
    public String getAccountDeleteEmail(String customerName) {
        return "<html>" +
                "<body>" +
                "<p>Kính gửi " + customerName + ",</p>" +
                "<p>Tài khoản của bạn đã bị xóa khỏi hệ thống.</p>" +
                "<p>Trân trọng,<br>Biblio BookShop</p>" +
                "</body>" +
                "</html>";
    }

    @Override
    public String getReturnConfirmationEmail(String customerName, String orderId) {
        return "<html>" +
                "<body>" +
                "<p>Kính gửi " + customerName + ",</p>" +
                "<p>Yêu cầu hoàn trả cho đơn hàng <strong>#" + orderId + "</strong> đã được chấp thuận.</p>" +
                "<p>Trân trọng,<br>Biblio BookShop</p>" +
                "</body>" +
                "</html>";
    }

}
