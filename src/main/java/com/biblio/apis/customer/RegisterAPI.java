package com.biblio.apis.customer;

import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.service.ICustomerService;
import com.biblio.utils.HttpUtil;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class RegisterAPI
 */
@WebServlet("/api/customer/register")
public class RegisterAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    ICustomerService customerService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");

        CustomerRegisterRequest customer = HttpUtil.of(request.getReader()).toModel(CustomerRegisterRequest.class);

        customerService.addCustomer(customer);

        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1000);
        map.put("msg", "Đăng ký thành công !");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(map));
    }

}
