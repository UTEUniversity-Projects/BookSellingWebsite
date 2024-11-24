package com.biblio.controller.customer;

import com.biblio.dto.response.AccountGetResponse;
import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.dto.response.OrderManagementResponse;
import com.biblio.entity.Order;
import com.biblio.service.ICustomerService;
import com.biblio.service.IOrderService;
import com.google.gson.Gson;

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
        HttpSession session = request.getSession(false); // false means do not create a new session if it doesn't exist
        AccountGetResponse account = (AccountGetResponse) session.getAttribute("account");
        CustomerDetailResponse customer = customerService.getCustomerDetailByUsername(account.getUsername());
        // Lấy customerId từ account
        Long customerId = customer.getId();
        // Check if the customer is authenticated
        if (customerId == null) {
            response.sendRedirect(request.getContextPath() + "/login"); // Redirect to login page
            return;
        }

        // Fetch orders for the customer based on customerId
        List<OrderCustomerResponse> orderList = orderService.findOrdersByCustomerId(customerId);

        // Set attributes for the JSP view
        request.setAttribute("orders", orderList);

        // Forward request to JSP view
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
