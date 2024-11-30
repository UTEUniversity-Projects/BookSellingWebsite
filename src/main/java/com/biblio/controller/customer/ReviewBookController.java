package com.biblio.controller.customer;

import com.biblio.dto.request.ReviewRequest;
import com.biblio.dto.response.AccountGetResponse;
import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.service.ICustomerService;
import com.biblio.service.IReviewService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/review-book")
public class ReviewBookController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IReviewService reviewService;

    @Inject
    private ICustomerService customerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewBookController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("breadcrumb", "Đánh giá");
        request.getRequestDispatcher("/views/customer/review-book.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession(false);
        AccountGetResponse account = (AccountGetResponse) session.getAttribute("account");
        CustomerDetailResponse customer = customerService.getCustomerDetailByUsername(account.getUsername());
        Long customerId = customer.getId();

        if (customerId == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        String content = request.getParameter("content");
        String bookTemplateIdParam = request.getParameter("bookTemplateId");
        Long bookTemplateId = Long.parseLong(bookTemplateIdParam);
        String ratingStr = request.getParameter("rating");
        int rate = Integer.parseInt(ratingStr);
        ReviewRequest reviewRequest = new ReviewRequest();
        reviewRequest.setCustomerId(customerId);
        reviewRequest.setContent(content);
        reviewRequest.setBookTemplateId(bookTemplateId);
        reviewRequest.setRate(rate);

        boolean readyToIntroduce = "true".equalsIgnoreCase(request.getParameter("is-ready"));
        reviewRequest.setReadyToIntroduce(readyToIntroduce);

        try {
            reviewService.createReview(reviewRequest);
            response.sendRedirect(request.getContextPath() + "/review-book?message=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/review-book?message=error");
        }

    }

}
