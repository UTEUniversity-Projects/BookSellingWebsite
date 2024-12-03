package com.biblio.controller.customer;

import com.biblio.dto.response.*;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.service.ICustomerService;
import com.biblio.service.IOrderService;
import com.biblio.service.IPromotionTemplateService;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewOrderController
 */
@WebServlet("/order")
public class OrderController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IOrderService orderService;
    @Inject
    private ICustomerService customerService;
    @Inject
    IPromotionTemplateService promotionTemplateService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get session
        HttpSession session = request.getSession(false);
        AccountGetResponse account = (AccountGetResponse) session.getAttribute("account");
        if (account == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        CustomerDetailResponse customer = customerService.getCustomerDetailByUsername(account.getUsername());

        Long customerId = customer.getId();

        if (customerId == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String statusParam = request.getParameter("status");

        if (statusParam == null || statusParam.isEmpty()) {
            statusParam = "all";
        }

        List<OrderDetailsManagementResponse> orderList;
        if ("all".equalsIgnoreCase(statusParam)) {
            orderList = orderService.getAllOrderCustomerResponse(customerId);
        } else {
            orderList = orderService.getOrderCustomerByStatus(customerId, statusParam);
        }

        request.setAttribute("orders", orderList);
        request.setAttribute("status", statusParam);

        request.getRequestDispatcher("/views/customer/order.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
