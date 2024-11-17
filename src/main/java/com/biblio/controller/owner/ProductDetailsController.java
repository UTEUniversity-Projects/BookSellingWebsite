package com.biblio.controller.owner;

import com.biblio.dto.response.BookDetailsResponse;
import com.biblio.service.IBookTemplateService;

import javax.enterprise.inject.Intercepted;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/owner/product-details")
public class ProductDetailsController extends HttpServlet {
    @Inject
    IBookTemplateService bookTemplateService;
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Long bookId = Long.parseLong(request.getParameter("id"));
        BookDetailsResponse book = bookTemplateService.getBookDetailsResponse(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/views/owner/product-details.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
