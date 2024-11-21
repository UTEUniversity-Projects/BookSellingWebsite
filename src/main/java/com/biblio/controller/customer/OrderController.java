package com.biblio.controller.customer;

import com.biblio.dto.response.OrderCustomerResponse;
import com.biblio.dto.response.OrderManagementResponse;
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
        HttpSession session = request.getSession();
        session.setAttribute("customerId", 1L);  // Sample customerId for testing (4L)
        Long customerId = (Long) session.getAttribute("customerId");

        // Check if the customer is authenticated
        if (customerId == null) {
            response.sendRedirect(request.getContextPath() + "/login"); // Redirect to login page
            return;
        }

        // Fetch orders for the customer based on customerId
        List<OrderCustomerResponse> orderList = orderService.findOrdersByCustomerId(customerId);

        // Set attributes for the JSP view
        request.setAttribute("breadcrumb", "Danh sách đơn hàng");
        request.setAttribute("orders", orderList);

        // Convert orders to JSON format for use in JavaScript on the frontend
        String ordersJson = convertOrdersToJson(orderList);
        request.setAttribute("ordersJson", ordersJson);

        // Forward request to JSP view
        request.getRequestDispatcher("/views/customer/order.jsp").forward(request, response);
    }

    /**
     * Method to convert the list of orders to JSON format
     */
    private String convertOrdersToJson(List<OrderCustomerResponse> orderList) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        for (int i = 0; i < orderList.size(); i++) {
            OrderCustomerResponse order = orderList.get(i);
            jsonBuilder.append("{")
                    .append("\"orderId\": \"").append(order.getId()).append("\", ")
                    .append("\"status\": \"").append(order.getStatus()).append("\", ")
                    .append("\"vat\": ").append(order.getVat()).append("}");

            if (i < orderList.size() - 1) {
                jsonBuilder.append(", ");
            }
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
