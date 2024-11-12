package com.biblio.apis.owner;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.service.IPromotionService;
import com.biblio.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPromotionAPI
 */
@WebServlet(urlPatterns = {"/owner/promotion/add"})
public class AddPromotionAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private IPromotionService promotionService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPromotionAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");

        PromotionInsertRequest promotionInsertRequest = HttpUtil.of(request.getReader()).toModel(PromotionInsertRequest.class);

        boolean isCodeExisted = promotionService.isCodeExisted(promotionInsertRequest.getCode().trim());
        Map<String, Object> map = new HashMap<>();
        if (isCodeExisted) {
            map.put("isCodeExisted", "Mã đã tồn tại !");
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mapper.writeValueAsString(map));
    }

}