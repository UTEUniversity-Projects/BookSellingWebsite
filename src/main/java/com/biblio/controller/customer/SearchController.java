package com.biblio.controller.customer;

import com.biblio.dto.request.SearchBookRequest;
import com.biblio.dto.response.BookCardResponse;
import com.biblio.dto.response.CategoryBookCountResponse;
import com.biblio.service.IBookService;
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
    private IBookService bookService;

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

        SearchBookRequest searchBookRequest = SearchBookRequest.builder()
                .title(title)
                .categoryId(null)
                .sortBy(null)
                .perPage(6)
                .minPrice(0)
                .maxPrice(10000000000L)
                .categoryId(null)
                .condition(null)
                .format(null)
                .reviewRate(0)
                .pageNumber(1)
                .sortBy(null)
                .build();

        List<CategoryBookCountResponse> categories = categoryService.getBookQuantityPerCategory(searchBookRequest);
        System.out.println(categories);
        List<BookCardResponse> books = bookTemplateService.getBookTemplateByCriteria(searchBookRequest);
        Long bookCount = bookTemplateService.getBookTemplateQuantityByCriteria(searchBookRequest);
        Long totalBook = bookTemplateService.getTotalBookTemplateQuantity();
        Long minPrice = bookService.getMinBookPrice();
        Long maxPrice = bookService.getMaxBookPrice();

        int page = 1;
        int perPage = 6;
        int totalPages = (int) (bookCount / perPage);
        int leftPage = (int) (bookCount % perPage);

        if (leftPage > 0)
            totalPages++;

        request.setAttribute("page", page);
        request.setAttribute("totalPages", totalPages);

        request.setAttribute("categories", categories);
        request.setAttribute("books", books);
        request.setAttribute("breadcrumb", "Tìm kiếm sách");
        request.setAttribute("title", title);
        request.setAttribute("bookCount", bookCount);
        request.setAttribute("totalBook", totalBook);
        request.setAttribute("minPrice", minPrice);
        request.setAttribute("maxPrice", maxPrice);

        request.getRequestDispatcher("/views/customer/search.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
