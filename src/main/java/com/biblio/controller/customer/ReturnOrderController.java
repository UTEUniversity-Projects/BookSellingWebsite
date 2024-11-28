package com.biblio.controller.customer;

import com.biblio.dto.request.ReturnBookRequest;
import com.biblio.dto.request.ReturnOrderRequest;
import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.entity.ReturnBook;
import com.biblio.enumeration.EReasonReturn;
import com.biblio.service.IOrderService;
import com.biblio.service.IReturnBookService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class HomeController
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 15)   // 15 MB
@WebServlet("/return-order")
public class ReturnOrderController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IReturnBookService returnBookService;
    @Inject
    private IOrderService orderService;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String orderIdParam = request.getParameter("orderId");
//        if (orderIdParam == null || orderIdParam.isEmpty()) {
//            // Nếu không có orderId, redirect về trang danh sách đơn hàng
//            response.sendRedirect(request.getContextPath() + "/order");
//            return;
//        }

        // Chuyển đổi orderId từ String sang Long
        //Long orderId = Long.parseLong(orderIdParam);
        Long orderId = 1L;
// Lấy chi tiết đơn hàng dựa trên orderId
        OrderCustomerResponse orderDetail = orderService.findOrderByIdCustomer(orderId);

        if (orderDetail == null) {
            System.out.println("Order not found for ID: " + orderId);
            response.sendRedirect(request.getContextPath() + "/order");
            return;
        }

        // Truyền thông tin đơn hàng vào JSP
        request.setAttribute("orderDetail", orderDetail);

        // Truyền danh sách Enum EReasonReturn vào JSP
        request.setAttribute("EReasonReturn", EReasonReturn.values());

        // Truyền thông tin breadcrumb vào JSP
        request.setAttribute("breadcrumb", "Hoàn trả sách");

        // Chuyển tiếp yêu cầu đến JSP
        request.getRequestDispatcher("/views/customer/return-order.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String description = request.getParameter("description");
        String reasonStr = request.getParameter("reason");

        // Kiểm tra nếu lý do hoặc mô tả không hợp lệ
        if (reasonStr == null || reasonStr.isEmpty()) {
            request.setAttribute("errorMessage", "Lý do hoàn trả không thể để trống.");
            request.getRequestDispatcher("/views/customer/return-order.jsp").forward(request, response);
            return;
        }

        // Chuyển đổi lý do hoàn trả từ chuỗi thành Enum
        EReasonReturn reason = null;
        try {
            reason = EReasonReturn.valueOf(reasonStr); // Chuyển đổi thành Enum
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "Lý do hoàn trả không hợp lệ.");
            request.getRequestDispatcher("/views/customer/return-order.jsp").forward(request, response);
            return;
        }

        // Kiểm tra mô tả chi tiết
        if (description == null || description.isEmpty()) {
            request.setAttribute("errorMessage", "Mô tả chi tiết không thể để trống.");
            request.getRequestDispatcher("/views/customer/return-order.jsp").forward(request, response);
            return;
        }
        Long orderId = 1L;


        // Tạo đối tượng ReturnBook
        ReturnBookRequest returnBook = new ReturnBookRequest(reason, description, orderId);

        // Lưu vào cơ sở dữ liệu
        returnBookService.save(returnBook);


        // Chuyển hướng hoặc trả về thông báo
        request.setAttribute("message", "Yêu cầu hoàn trả đã được xử lý.");
        request.getRequestDispatcher("/return-confirmation.jsp").forward(request, response);
    }
}
