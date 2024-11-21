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
        message.setText(body, "UTF-8");

        Transport.send(message);
    }


    @Override
    public String getPromotionEmail(String customerName, String promotionDetails) {
        return "Kính gửi " + customerName + ",\n\n" +
                "Chúng tôi vui mừng thông báo chương trình khuyến mãi mới:\n" +
                promotionDetails + "\n\n" +
                "Nhanh tay tham gia để nhận ưu đãi hấp dẫn!\n" +
                "Trân trọng,\nBiblio BookShop";
    }



    @Override
    public String getWelcomeEmail(String customerName) {
        return "Chào mừng " + customerName + ",\n\n" +
                "Cảm ơn bạn đã đăng ký tài khoản với chúng tôi.\n\n" +
                "Trân trọng,\nBiblio BookShop";
    }

    @Override
    public String getAccountLockEmail(String customerName) {
        return "Kính gửi " + customerName + ",\n\n" +
                "Tài khoản của bạn đã bị khóa tạm thời.\n\n" +
                "Trân trọng,\nBiblio BookShop";
    }

    @Override
    public String getAccountUnlockEmail(String customerName) {
        return "Kính gửi " + customerName + ",\n\n" +
                "Tài khoản của bạn đã được mở khóa.\n\n" +
                "Trân trọng,\nBiblio BookShop";
    }

    @Override
    public String getAccountDeleteEmail(String customerName) {
        return "Kính gửi " + customerName + ",\n\n" +
                "Tài khoản của bạn đã bị xóa khỏi hệ thống.\n\n" +
                "Trân trọng,\nBiblio BookShop";
    }


    @Override
    public String getReturnConfirmationEmail(String customerName, String orderId) {
        return "Kính gửi " + customerName + ",\n\n" +
                "Yêu cầu hoàn trả cho đơn hàng #" + orderId + " đã được chấp thuận.\n\n" +
                "Trân trọng,\nBiblio BookShop";
    }
}
