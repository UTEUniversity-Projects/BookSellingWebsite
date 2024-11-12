package com.biblio.controller.owner;

import com.biblio.dto.response.AuthorResponse;
import com.biblio.service.IAuthorService;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/owner/author-profile")
public class AuthorProfileController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IAuthorService authorService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        String id = session.getAttribute("authorId").toString();

        AuthorResponse authorResponse = authorService.findById(Long.parseLong(id));
        request.setAttribute("author", authorResponse);
        request.getRequestDispatcher("/views/owner/author-profile.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
