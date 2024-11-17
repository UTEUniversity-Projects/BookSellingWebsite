package com.biblio.apis.staff;

import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.request.ResponseReviewRequest;
import com.biblio.entity.ResponseReview;
import com.biblio.service.IResponseReviewService;
import com.biblio.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/staff/response-review/add"})
public class AddResponseReviewAPI extends HttpServlet {
    @Inject
    private IResponseReviewService reviewService;
    @Serial
    private static final long serialVersionUID = 1L;

    public AddResponseReviewAPI() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");

        ResponseReviewRequest reviewRequest = HttpUtil.of(request.getReader()).toModel(ResponseReviewRequest.class);

        ResponseReview responseReview = reviewService.insertResponseReview(reviewRequest);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> result = new HashMap<>();
        result.put("message", "Phản hồi đã được ghi nhận.");
        response.getWriter().write(mapper.writeValueAsString(result));
    }
}
