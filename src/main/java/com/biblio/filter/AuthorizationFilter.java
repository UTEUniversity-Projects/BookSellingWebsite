package com.biblio.filter;

import com.biblio.dto.response.AccountGetResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class Filter
 */
@WebFilter("/2321321/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        String contextPath = req.getContextPath();
        String requestURI = req.getRequestURI();

        if (session == null || session.getAttribute("account") == null) {
            if (!requestURI.endsWith("/login")) {
                res.sendRedirect(contextPath + "/login");
            } else {
                chain.doFilter(request, response);
            }
            return;
        }

        AccountGetResponse account = (AccountGetResponse) session.getAttribute("account");

        if (account == null) {
            if (!requestURI.endsWith("/login")) {
                res.sendRedirect(contextPath + "/login");
            } else {
                chain.doFilter(request, response);
            }
            return;
        }

        String role = account.getRole();

        if ("owner".equals(role) && !requestURI.startsWith(contextPath + "/owner/")) {
            res.sendRedirect(contextPath + "/owner/ecommerce");
            return;
        } else if ("staff".equals(role) && !requestURI.startsWith(contextPath + "/staff/")) {
            res.sendRedirect(contextPath + "/staff/product-dashboard");
            return;
        } else if ("customer".equals(role) && (requestURI.startsWith(contextPath + "/owner/") || requestURI.startsWith(contextPath + "/staff/"))) {
            res.sendRedirect(contextPath + "/home");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
