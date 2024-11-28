package com.biblio.apis.staff;

import com.biblio.dto.request.ResponseReviewRequest;
import com.biblio.service.IReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/staff/review/update/*"})
public class UpdateReviewAPI extends HttpServlet {
    @Inject
    IReviewService reviewService;
    @Serial
    private static final long serialVersionUID = 1L;

    public UpdateReviewAPI() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getPathInfo();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> result = new HashMap<>();

        try {
            switch (action) {
                case "/hidden":
                    handleHideReview(request, response, result, mapper);
                    break;

                default:
                    result.put("message", "Không tìm thấy hành động phù hợp!");
                    result.put("type", "error");
                    response.getWriter().write(mapper.writeValueAsString(result));
                    break;
            }
        } catch (Exception e) {
            result.put("message", "Có lỗi xảy ra trong quá trình xử lý yêu cầu ascasca.");
            result.put("type", "error");
            response.getWriter().write(mapper.writeValueAsString(result));
        }
    }

    private void handleHideReview(HttpServletRequest request, HttpServletResponse response, Map<String, String> result, ObjectMapper mapper) throws IOException {
        Map<String, Object> jsonMap = mapper.readValue(request.getReader(), Map.class);
        long reviewId = Long.parseLong(jsonMap.get("reviewId").toString());

        boolean success = reviewService.updateReviewHidden(reviewId, true);
        if (success) {
            result.put("message", "Đánh giá đã được ẩn thành công!");
            result.put("type", "success");
        } else {
            result.put("message", "Không thể ẩn đánh giá. Vui lòng thử lại!");
            result.put("type", "info");
        }
        response.getWriter().write(mapper.writeValueAsString(result));
    }
}
