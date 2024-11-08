package com.biblio.apis.customer;

import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.entity.Customer;
import com.biblio.mapper.CustomerMapper;
import com.biblio.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serial;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterAPI
 */
@WebServlet("/api-register")
public class RegisterAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private CustomerMapper customerMapper;

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
        response.setContentType("application/json");

        CustomerRegisterRequest user = HttpUtil.of(request.getReader()).toModel(CustomerRegisterRequest.class);
        System.out.println(CustomerMapper.toCustomerRegister(user));
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), user);

//        ObjectMapper objectMapper = new ObjectMapper();
//        CustomerRegisterRequest user = objectMapper.readValue(request.getInputStream(), CustomerRegisterRequest.class);
//        System.out.println("Register API: " + user);
//
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.append("status", "success");
//
//        Gson gson = new Gson();
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(gson.toJson(user));
    }

}
