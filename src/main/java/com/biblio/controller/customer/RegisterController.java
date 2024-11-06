package com.biblio.controller.customer;

import com.biblio.dto.request.UserRegisterRequest;
import com.biblio.utils.UploadFileUtil;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/register")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class RegisterController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("breadcumb", "Đăng ký tài khoản");
        request.getRequestDispatcher("/views/customer/register.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        UserRegisterRequest user = new UserRegisterRequest();

        try {
            BeanUtils.populate(user, request.getParameterMap());
            Part part = request.getPart("image");
            user.setAvatar(UploadFileUtil.UploadImage(part, getServletContext()));
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
