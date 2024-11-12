package com.biblio.controller.staff;

import com.biblio.dto.request.SupportRequest;
import com.biblio.entity.Support;
import com.biblio.service.ISupportService;
import com.biblio.service.impl.SupportServiceImpl;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/staff/support-customer-dashboard")
public class SupportCustomerDashboardController extends HttpServlet {
    private final ISupportService supportService = new SupportServiceImpl();
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("detail".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            Support supportRequest = supportService.getSupportRequestById(id);
            request.setAttribute("supportRequest", supportRequest);
            request.getRequestDispatcher("/views/staff/support-customer-details.jsp").forward(request, response);
        } else {
            List<Support> supportRequests = supportService.getAllSupportRequests();
            request.setAttribute("supportRequests", supportRequests);
            request.getRequestDispatcher("/views/staff/support-customer-dashboard.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("respond".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            String feedbackContent = request.getParameter("feedbackContent");
            try {
                SupportRequest supportRequest = new SupportRequest(id, feedbackContent);
                supportService.respondToSupportRequest(supportRequest);
                response.sendRedirect(request.getContextPath() + "/staff/support-customer-dashboard");
            } catch (IllegalArgumentException e) {
                request.setAttribute("error", e.getMessage());
                response.sendRedirect(request.getContextPath() + "/staff/support-customer-dashboard?action=detail&id=" + id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
