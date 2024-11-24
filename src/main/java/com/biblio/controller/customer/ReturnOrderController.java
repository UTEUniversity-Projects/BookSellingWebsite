package com.biblio.controller.customer;

import com.biblio.dto.request.ReturnBookRequest;
import com.biblio.entity.ReturnBook;
import com.biblio.enumeration.EReasonReturn;
import com.biblio.service.IReturnBookService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/return-order")
public class ReturnOrderController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IReturnBookService returnBookService;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ session
        HttpSession session = request.getSession();
        //Long customerId = (Long) session.getAttribute("customerId");
        Long customerId = 4L;
        // Nếu chưa đăng nhập, chuyển hướng đến trang login
        if (customerId == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Hiển thị giao diện hoàn trả (JSP)
        request.getRequestDispatcher("/views/customer/return-order.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ session
        HttpSession session = request.getSession();
        Long customerId = (Long) session.getAttribute("customerId");
        if (customerId == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Lấy dữ liệu từ form
        String reasonStr = request.getParameter("reason");
        String description = request.getParameter("description");

        //ReturnBookRequest returnBookRequest = new ReturnBookRequest(reason, description);
        // Validate form inputs
        if (reasonStr == null || description == null || description.isEmpty()) {
            request.setAttribute("error", "Reason and description are required.");
            request.getRequestDispatcher("/views/customer/return-order.jsp").forward(request, response);
            return;
        }

        // Convert reason string to EReasonReturn
        EReasonReturn reason;
        try {
            reason = EReasonReturn.valueOf(reasonStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Invalid reason selected.");
            request.getRequestDispatcher("/views/customer/return-order.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng ReturnBook
        ReturnBook returnBook = ReturnBook.builder()
                .reason(reason)
                .description(description)
                .createdAt(LocalDateTime.now())
                // .customerId(customerId) // Nếu ReturnBook có trường customerId
                .build();
        // Tạo đối tượng ReturnBook
        returnBook.setId(customerId);
        returnBook.setReason(reason);
        returnBook.setDescription(description);
        returnBook.setCreatedAt(LocalDateTime.now());

        // Lưu thông tin hoàn trả vào cơ sở dữ liệu
        returnBookService.save(returnBook);

        // Gửi phản hồi về client
        response.sendRedirect(request.getContextPath() + "/order");
    }

}
