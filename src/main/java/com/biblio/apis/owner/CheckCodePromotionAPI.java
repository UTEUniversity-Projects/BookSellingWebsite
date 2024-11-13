package com.biblio.apis.owner;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.service.IPromotionService;
import com.biblio.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/owner/promotion/checkCode"})
public class CheckCodePromotionAPI {
    @Inject
    private IPromotionService promotionService;
    public CheckCodePromotionAPI() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PromotionInsertRequest promotionInsertRequest = HttpUtil.of(request.getReader()).toModel(PromotionInsertRequest.class);
        boolean isCodeExisted = promotionService.isCodeExisted(promotionInsertRequest.getCode().trim());

        Map<String, Object> map = new HashMap<>();
        if (isCodeExisted) {
            map.put("isCodeExisted", true);
            map.put("message", "Mã khuyến mãi đã tồn tại.");
        }
        // Send JSON response
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mapper.writeValueAsString(map));
    }
}
