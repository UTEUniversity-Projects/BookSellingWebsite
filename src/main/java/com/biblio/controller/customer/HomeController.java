package com.biblio.controller.customer;

import com.biblio.dto.response.BookGetListResponse;
import com.biblio.dto.response.CategoryGetListResponse;
import com.biblio.dto.response.CategoryResponse;
import com.biblio.service.IBookService;
import com.biblio.service.ICategoryService;
import com.biblio.service.IUserService;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IBookService bookService;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        List<CategoryGetListResponse> categories = categoryService.findAll();
        List<BookGetListResponse> books = bookService.findAll();
        request.setAttribute("categories", categories);
        request.setAttribute("books", books);

        request.getRequestDispatcher("/views/customer/home.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
