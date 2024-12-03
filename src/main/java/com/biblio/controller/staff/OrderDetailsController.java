package com.biblio.controller.staff;

import com.biblio.dto.response.*;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.service.IOrderService;
import com.biblio.service.IPromotionTemplateService;
import com.biblio.service.IReturnBookService;
import com.biblio.utils.OrderUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/staff/order-details")
public class OrderDetailsController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    IOrderService orderService;

    @Inject
    IReturnBookService returnBookService;

    @Inject
    IPromotionTemplateService promotionTemplateService;

    @Inject
    OrderUtil orderUtil;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        AccountGetResponse account = (AccountGetResponse) request.getSession().getAttribute("account");
        if (account == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Long orderId = Long.parseLong(request.getParameter("id"));
        OrderDetailsManagementResponse orderDetailsResponse = orderUtil.getOrderDetails(orderId);
        if (orderDetailsResponse == null) {
            response.sendRedirect(request.getContextPath() + "/staff/order-dashboard");
            return;
        }

        if (orderDetailsResponse.getStatus() == EOrderStatus.REQUEST_REFUND || orderDetailsResponse.getStatus() == EOrderStatus.REFUNDED) {
            ReturnBookManagementResponse returnBook = returnBookService.findReturnBookByOrderId(orderId);
            request.setAttribute("returnBook", returnBook);
        }
        request.setAttribute("order", orderDetailsResponse);
        request.getRequestDispatcher("/views/staff/order-details.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
