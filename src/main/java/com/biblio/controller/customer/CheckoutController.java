package com.biblio.controller.customer;

import com.biblio.dto.request.CheckoutItemRequest;
import com.biblio.dto.request.CheckoutRequest;
import com.biblio.dto.response.*;
import com.biblio.entity.Account;
import com.biblio.entity.Customer;
import com.biblio.service.IBookService;
import com.biblio.service.IBookTemplateService;
import com.biblio.service.ICustomerService;
import com.biblio.service.IPromotionTemplateService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private IBookTemplateService bookTemplateService;

    @Inject
    private IPromotionTemplateService promotionTemplateService;

    @Inject
    private ICustomerService customerService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("breadcrumb", "Thanh toán");

        AccountGetResponse account = (AccountGetResponse) request.getSession().getAttribute("account");
        if (account == null) {
            response.sendRedirect("/login");
            return;
        }

        CustomerDetailResponse customer = customerService.getCustomerDetailByUsername(account.getUsername());

        CheckoutRequest checkoutRequest = (CheckoutRequest) request.getSession().getAttribute("checkoutRequest");

        if (checkoutRequest == null) {
            response.sendRedirect("/cart");
            return;
        }

        CheckOutResponse checkOutResponse = new CheckOutResponse();

        checkOutResponse.setCustomer(customer);
        AddressResponse firstAddress = customer.getAddresses().stream().findFirst().orElse(null);

        checkOutResponse.setAddress(firstAddress.getFullAddress());

        List<CheckoutItemResponse> items = new ArrayList<>();
        for (CheckoutItemRequest item : checkoutRequest.getItems()) {
            CheckoutItemResponse itemResponse = bookTemplateService.getCheckoutItemResponse(item);
            double discount = promotionTemplateService.percentDiscountOfBook(item.getProductId());
            itemResponse.setDiscountPercent(discount);
            itemResponse.calTotalPrice();
            items.add(itemResponse);
        }

        checkOutResponse.setItems(items);
        checkOutResponse.updateTotalPrice();

        request.setAttribute("checkoutResponse", checkOutResponse);
        request.getRequestDispatcher("/views/customer/checkout.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
