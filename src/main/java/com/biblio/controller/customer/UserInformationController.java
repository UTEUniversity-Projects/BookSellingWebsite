package com.biblio.controller.customer;

import com.biblio.dto.response.AccountGetResponse;
import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.service.ICustomerService;

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
 * Servlet implementation class UserInformationController
 */
@WebServlet("/user-information")
public class UserInformationController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private ICustomerService customerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stubr
        HttpSession session = request.getSession(false);
        AccountGetResponse account = (AccountGetResponse) session.getAttribute("account");

        Long accountId = account.getId(); // Lấy ID trực tiếp từ account

        // Tìm thông tin khách hàng theo accountId
        CustomerDetailResponse customerGetListResponse = customerService.findById(accountId);
        //CustomerGetListResponse customerGetListResponse = customerService.findById(4L);
        request.setAttribute("customer", customerGetListResponse);
        request.getRequestDispatcher("/views/customer/user-information.jsp").forward(request, response);
        // Kiểm tra nếu người dùng đã đăng nhập
        if (session != null && session.getAttribute("username") != null) {
//            // Đặt các thuộc tính vào request để hiển thị trong JSP
//            request.setAttribute("breadcrumb", "Thông tin cá nhân");
//            request.setAttribute("username", session.getAttribute("username"));
//            request.setAttribute("date_of_birth", session.getAttribute("date_of_birth"));
//            request.setAttribute("email_address", session.getAttribute("email_adress"));
//            request.setAttribute("full_name", session.getAttribute("full_name"));
//            request.setAttribute("gender", session.getAttribute("gender"));
//
//
//
//            // Chuyển hướng tới trang user-information.jsp
//
        } else {
            // Nếu chưa đăng nhập, chuyển về trang đăng nhập
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
