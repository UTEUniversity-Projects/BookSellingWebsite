package com.biblio.controller.customer;

import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.service.ICustomerService;
import com.biblio.service.IOrderService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/order-detail")
public class OrderDetailController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IOrderService orderService;

    @Inject
    private ICustomerService customerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderIdParam = request.getParameter("orderId");
        if (orderIdParam == null || orderIdParam.isEmpty()) {
            // Nếu không có orderId, redirect về trang danh sách đơn hàng
            response.sendRedirect(request.getContextPath() + "/order");
            return;
        }

        // Chuyển đổi orderId từ String sang Long
        Long orderId = Long.parseLong(orderIdParam);

        // Lấy chi tiết đơn hàng dựa trên orderId
        OrderCustomerResponse orderDetail = orderService.findOrderByIdCustomer(orderId);

        if (orderDetail == null) {
            System.out.println("Order not found for ID: " + orderId);
            response.sendRedirect(request.getContextPath() + "/order");
            return;
        }


        // Truyền thông tin đơn hàng vào JSP
        request.setAttribute("orderDetail", orderDetail);

        // Forward request to JSP view
        request.getRequestDispatcher("/views/customer/order-detail.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
