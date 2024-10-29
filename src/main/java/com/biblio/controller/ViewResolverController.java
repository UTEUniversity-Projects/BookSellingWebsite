package com.biblio.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewResolverController
 */
@WebServlet(urlPatterns = {"/views/*",
        "/customer/css/*", "/customer/js/*", "/customer/img/*", "/customer/font/*", "/customer/scss/*",
        "/staff/css/*", "/staff/js/*", "/staff/img/*", "/staff/font/*",
        "/owner/css/*", "/owner/js/*", "/owner/img/*", "/owner/font/*"})
public class ViewResolverController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        String resourcePath = path.substring(request.getContextPath().length());

        if (resourcePath.startsWith("/views/")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF" + resourcePath);
            dispatcher.forward(request, response);
        } else if (resourcePath.startsWith("/customer/css/") || resourcePath.startsWith("/customer/js/") || resourcePath.startsWith("/customer/img/") || resourcePath.startsWith("/customer/font/") || resourcePath.startsWith("/customer/scss/")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/assets" + resourcePath);
            dispatcher.forward(request, response);
        } else if (resourcePath.startsWith("/staff/css/") || resourcePath.startsWith("/staff/js/") || resourcePath.startsWith("/staff/img/") || resourcePath.startsWith("/staff/font/")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/assets" + resourcePath);
            dispatcher.forward(request, response);
        } else if (resourcePath.startsWith("/owner/css/") || resourcePath.startsWith("/owner/js/") || resourcePath.startsWith("/owner/img/") || resourcePath.startsWith("/owner/font/")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/assets" + resourcePath);
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
