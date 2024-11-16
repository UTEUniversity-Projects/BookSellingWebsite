package com.biblio.controller.owner;

import com.biblio.dto.response.AuthorResponse;
import com.biblio.service.IAuthorService;
import org.jboss.weld.context.http.Http;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet(urlPatterns = {"/owner/author-list"})
public class AuthorListController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    IAuthorService authorService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorListController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<AuthorResponse> list = authorService.findAll();
        request.setAttribute("authors", list);
        request.getRequestDispatcher("/views/owner/author-list.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        String id = session.getAttribute("authorId").toString();
        String action = session.getAttribute("authorAction").toString();

        if (id != null && action != null) {
            try {
                Long authorId = Long.parseLong(id);

                if (action.equals("delete")){
                    authorService.deleteAuthor(authorId);
                    response.getWriter().write("success");
                }
            } catch (NumberFormatException e) {
                response.getWriter().write("error");
            }
            return;
        }

        doGet(request, response);
    }
}
