package com.biblio.controller.customer;

import com.biblio.dto.response.AccountGetResponse;
import com.biblio.service.IAccountService;

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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IAccountService accountService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getRequestDispatcher("/views/customer/login.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (accountService.isUsernameExisted(username) ) {
            AccountGetResponse account = accountService.getAccountByUsername(username);
            if (account.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
            }
            request.getRequestDispatcher("/views/customer/login.jsp").forward(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

}
