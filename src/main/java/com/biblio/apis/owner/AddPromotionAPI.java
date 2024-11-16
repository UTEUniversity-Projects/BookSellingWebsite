package com.biblio.apis.owner;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.service.IPromotionService;
import com.biblio.service.IPromotionTemplateService;
import com.biblio.utils.HttpUtil;
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

@WebServlet(urlPatterns = {"/owner/promotion/add"})
public class AddPromotionAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private IPromotionTemplateService promotionTemplateService;

    public AddPromotionAPI() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Parse JSON request to PromotionInsertRequest model
        PromotionTemplateInsertRequest promotionTemplateInsertRequest = HttpUtil.of(request.getReader()).toModel(PromotionTemplateInsertRequest.class);

        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Boolean isExitsCode = promotionTemplateService.isCodeExisted(promotionTemplateInsertRequest.getCode());
            if (isExitsCode) {
                map.put("isCodeExisted", true);
                map.put("message", "Code is existed");
            } else {
                promotionTemplateService.insertPromotionTemplate(promotionTemplateInsertRequest);
                map.put("isCodeExisted", false);
                map.put("message", "Promotion added successfully");
            }
        } catch (Exception e) {
            map.put("isCodeExisted", false); // Không kiểm tra mã nên vẫn là false
            map.put("message", "Failed to add promotion: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        // Send JSON response
        response.getWriter().write(mapper.writeValueAsString(map));
    }
}

