package com.biblio.controller.staff;

import com.biblio.dto.response.OrderGetListResponse;
import com.biblio.entity.Order;
import com.biblio.service.IOrderService;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/staff/order-dashboard")
public class OrderDashBoardController extends HttpServlet {
    @Inject
    IOrderService orderService;
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDashBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<OrderGetListResponse> orders = orderService.getOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/views/staff/order-dashboard.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
