package com.biblio.controller.customer;

import com.biblio.dto.response.AccountGetResponse;
import com.biblio.dto.response.CartResponse;
import com.biblio.service.ICartService;

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
@WebServlet("/cart")
public class CartController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private ICartService cartService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        HttpSession session = request.getSession();
        AccountGetResponse account = (AccountGetResponse) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");
            return;
        }
        CartResponse cart = cartService.getCartResponseByAccountId(account.getId());

        request.setAttribute("breadcrumb", "Giỏ hàng");
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/views/customer/cart.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
