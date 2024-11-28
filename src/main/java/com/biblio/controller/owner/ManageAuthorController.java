package com.biblio.controller.owner;

import com.biblio.dto.request.AuthorRequest;
import com.biblio.dto.response.AuthorAnalysisResponse;
import com.biblio.dto.response.AuthorLineResponse;
import com.biblio.dto.response.AuthorProfileResponse;
import com.biblio.service.IAuthorService;
import com.biblio.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@WebServlet(urlPatterns = {"/owner/author/list", "/owner/author/view",
        "/owner/author/create", "/owner/author/update", "/owner/author/delete"})
public class ManageAuthorController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    IAuthorService authorService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageAuthorController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getAction(request);

        switch (action) {
            case "list":
                listAuthors(request, response);
                break;
            case "view":
                viewAuthor(request, response);
                break;
            case "create":
                createAuthorGet(request, response);
                break;
            case "update":
                updateAuthorGet(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getAction(request);

        switch (action) {
            case "create":
                createAuthorPost(request, response);
                break;
            case "update":
                updateAuthorPost(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

    /**
     * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        if (id != null) {
            try {
                authorService.deleteAuthor(Long.parseLong(id));
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("{\"message\":\"Author deleted successfully\"}");
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"message\":\"Error deleting author: " + e.getMessage() + "\"}");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID for deletion");
        }
    }

    private String getAction(HttpServletRequest request) {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            String requestURI = request.getRequestURI();
            String[] pathParts = requestURI.split("/");
            action = pathParts[pathParts.length - 1];
        }

        return action;
    }

    private void listAuthors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AuthorLineResponse> list = authorService.findAll();
        request.setAttribute("authors", list);
        request.getRequestDispatcher("/views/owner/author-list.jsp").forward(request, response);
    }

    private void viewAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = session.getAttribute("authorId").toString();

        AuthorAnalysisResponse authorResponse = authorService.findAnalysisById(Long.parseLong(id));
        request.setAttribute("author", authorResponse);
        request.getRequestDispatcher("/views/owner/author-profile.jsp").forward(request, response);
    }

    private void createAuthorGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/owner/author-create.jsp").forward(request, response);
    }
    private void createAuthorPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            AuthorRequest authorRequest = HttpUtil.of(request.getReader()).toModel(AuthorRequest.class);
            authorRequest.setJoinAt(LocalDateTime.now().toString());

            authorService.createAuthor(authorRequest);

            response.setStatus(HttpServletResponse.SC_OK);  // 200 OK
            response.getWriter().write("{\"success\": true, \"message\": \"Created successfully.\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
            response.getWriter().write("{\"success\": false, \"message\": \"An error occurred while creating.\"}");
            log.error("e: ", e);
        }
    }

    private void updateAuthorGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = session.getAttribute("authorId").toString();

        AuthorProfileResponse authorResponse = authorService.findProfileById(Long.parseLong(id));
        request.setAttribute("author", authorResponse);
        request.getRequestDispatcher("/views/owner/author-update.jsp").forward(request, response);
    }
    private void updateAuthorPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            AuthorRequest authorRequest = HttpUtil.of(request.getReader()).toModel(AuthorRequest.class);

            authorService.updateAuthor(authorRequest);

            response.setStatus(HttpServletResponse.SC_OK);  // 200 OK
            response.getWriter().write("{\"success\": true, \"message\": \"Updated successfully.\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
            response.getWriter().write("{\"success\": false, \"message\": \"An error occurred while updating.\"}");
            log.error("e: ", e);
        }
    }
}
