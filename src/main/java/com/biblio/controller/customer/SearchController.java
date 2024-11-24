package com.biblio.controller.customer;

import com.biblio.dto.request.SearchBookRequest;
import com.biblio.dto.response.BookCardResponse;
import com.biblio.dto.response.CategoryBookCountResponse;
import com.biblio.service.IBookTemplateService;
import com.biblio.service.ICategoryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

/**
 * Servlet implementation class SearchController
 */
@WebServlet(urlPatterns = {"/search", "/book-list"})
public class SearchController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private IBookTemplateService bookTemplateService;

    @Inject
    private ICategoryService categoryService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String title = request.getParameter("title");

        SearchBookRequest searchBookRequest = SearchBookRequest.builder().title(title).build();

        List<CategoryBookCountResponse> categories = categoryService.getBookQuantityPerCategory();
        List<BookCardResponse> books = bookTemplateService.getBookTemplateByCriteria(searchBookRequest);
        long bookCount = bookTemplateService.getBookTemplateQuantityByCriteria(searchBookRequest);

        int index = 1;
        int perPage = 8;
        int endPage = (int) (bookCount / perPage);
        int leftPage = (int) (bookCount % perPage);

        System.out.println("endPage: " + endPage);
        System.out.println("leftPage: " + leftPage);

        if (leftPage > 0)
            endPage++;

        request.setAttribute("index", index);
        request.setAttribute("endPage", endPage);

        request.setAttribute("categories", categories);
        request.setAttribute("books", books);
        request.setAttribute("breadcrumb", "Tìm kiếm sách");
        request.setAttribute("title", title);
        request.setAttribute("searchResult", bookCount);

        request.getRequestDispatcher("/views/customer/search.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
