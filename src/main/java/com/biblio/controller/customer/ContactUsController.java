package com.biblio.controller.customer;

import com.biblio.dto.request.SupportRequest;
import com.biblio.service.ISupportService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/contact-us")
public class ContactUsController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private ISupportService supportService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("breadcumb", "Liên hệ");
        request.getRequestDispatcher("/views/customer/contact-us.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession(true); // true sẽ tạo session nếu không tồn tại
        Long customerId = 1L; // Giả lập ID khách hàng, trong thực tế có thể lấy từ session thực tế

        // Đặt thông tin vào session giả
        session.setAttribute("customerId", customerId);

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // Kiểm tra đầu vào
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            request.setAttribute("errorMessage", "Tiêu đề và nội dung không được để trống.");
            request.getRequestDispatcher("/views/customer/contact-us.jsp").forward(request, response);
            return;
        }

        SupportRequest supportRequestDTO = new SupportRequest();
        supportRequestDTO.setTitle(title);
        supportRequestDTO.setFeedbackContent(content);
        supportRequestDTO.setCustomerId(customerId);
        try {
            supportService.createSupport(supportRequestDTO);
            request.setAttribute("message", "Đã gửi yêu cầu hỗ trợ!");
            //response.sendRedirect(request.getContextPath() + "/contact-us?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            // Nếu có lỗi trong xử lý, hiển thị thông báo lỗi
            request.setAttribute("errorMessage", "Đã có lỗi xảy ra, vui lòng thử lại sau.");
            request.getRequestDispatcher("/views/customer/contact-us.jsp").forward(request, response);
        }
    }

}
