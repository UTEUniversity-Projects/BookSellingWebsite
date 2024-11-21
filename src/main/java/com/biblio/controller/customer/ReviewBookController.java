package com.biblio.controller.customer;

import com.biblio.dto.request.ReviewRequest;
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
        request.getRequestDispatcher("/views/customer/review-book.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        Long customerId = 1L;
//        Long customerId = (Long) session.getAttribute("customerId");
//        if (customerId == null) {
//            response.sendRedirect(request.getContextPath() + "/login");
//            return;
//        }
        String content = request.getParameter("content");
        Long bookTemplateId = 1L;
        //int rate = Integer.parseInt(request.getParameter("rating") != null ? request.getParameter("rating") : "0");
        String ratingStr = request.getParameter("rating");
        if (content == null || content.isEmpty()) {
            request.setAttribute("errorMessage", "Nội dung không được để trống.");
            request.getRequestDispatcher("/views/customer/review-book.jsp").forward(request, response);
            return;
        }
        if (ratingStr == null || ratingStr.isEmpty()) {
            request.setAttribute("errorMessage", "Bạn phải chọn một mức đánh giá.");
            request.getRequestDispatcher("/views/customer/review-book.jsp").forward(request, response);
            return;
        }

        int rate = Integer.parseInt(ratingStr);
        ReviewRequest reviewRequest = new ReviewRequest();
        reviewRequest.setCustomerId(customerId);
        reviewRequest.setContent(content);
        reviewRequest.setBookTemplateId(bookTemplateId);
        reviewRequest.setRate(rate);

        boolean readyToIntroduce = request.getParameter("ten-dang-nhap") != null;
        reviewRequest.setReady_to_introduce(readyToIntroduce);

        try {
            reviewService.createReview(reviewRequest);
            response.sendRedirect(request.getContextPath() + "/review-book?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            // Nếu có lỗi trong xử lý, hiển thị thông báo lỗi
            request.setAttribute("errorMessage", "Đã có lỗi xảy ra, vui lòng thử lại sau.");
            request.getRequestDispatcher("/views/customer/review-book.jsp").forward(request, response);
        }
    }

}
