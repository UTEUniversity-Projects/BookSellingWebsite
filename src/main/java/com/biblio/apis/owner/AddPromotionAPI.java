//package com.biblio.apis.owner;
//
//import com.biblio.dto.request.PromotionInsertRequest;
//import com.biblio.dto.request.PromotionTargetInsertRequest;
//import com.biblio.enumeration.EPromotionStatus;
//import com.biblio.enumeration.EPromotionTargetType;
//import com.biblio.enumeration.EPromotionType;
//import com.biblio.service.IPromotionService;
//import com.biblio.utils.HttpUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.Serial;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet(urlPatterns = {"/owner/promotion/add"})
//public class AddPromotionAPI extends HttpServlet {
//    @Serial
//    private static final long serialVersionUID = 1L;
//
//    @Inject
//    private IPromotionService promotionService;
//
//    public AddPromotionAPI() {
//        super();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//
//        // Lấy kiểu khuyến mãi từ yêu cầu
//        String formType = request.getParameter("formType");
//        Map<String, Object> map = new HashMap<>();
//
//        try {
//            if ("addVoucher".equals(formType)) {
//                handleAddVoucher(request, response, map);
//            } else if ("addCoupon".equals(formType)) {
//                handleAddCoupon(request, response, map);
//            } else if ("addFreeShip".equals(formType)) {
//                handleAddFreeShip(request, response, map);
//            }
//
//            // Gửi phản hồi dưới dạng JSON
//            ObjectMapper mapper = new ObjectMapper();
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(mapper.writeValueAsString(map));
//        } catch (Exception e) {
//            map.put("error", "Đã xảy ra lỗi khi thêm khuyến mãi.");
//            e.printStackTrace();
//        }
//    }
//
//    private void handleAddPromotion(HttpServletRequest request, Map<String, Object> map, EPromotionType type, Double percentDiscount, Double minValueApplied) throws Exception {
//        PromotionInsertRequest promotionInsertRequest = HttpUtil.of(request.getReader()).toModel(PromotionInsertRequest.class);
//
//        // Kiểm tra mã khuyến mãi đã tồn tại
//        boolean isCodeExist = promotionService.isCodeExisted(promotionInsertRequest.getCode().trim());
//        if (isCodeExist) {
//            map.put("isCodeExisted", true);
//            map.put("message", "Mã khuyến mãi đã tồn tại.");
//            return;
//        }
//
//        promotionInsertRequest.setStatus(EPromotionStatus.EFFECTIVE);
//        promotionInsertRequest.setType(type);
//        promotionInsertRequest.setPercentDiscount(percentDiscount);
//        promotionInsertRequest.setMinValueApplied(minValueApplied);
//
//        // Thêm các mục tiêu khuyến mãi
//        PromotionTargetInsertRequest promotionTargetInsertRequest = createPromotionTargetRequest(request);
//        promotionInsertRequest.getPromotionTargets().add(promotionTargetInsertRequest);
//
//        // Thêm khuyến mãi
//        promotionService.insert(promotionInsertRequest);
//        map.put("isCodeExisted", false);
//        map.put("message", "Thêm khuyến mãi thành công.");
//    }
//
//    private PromotionTargetInsertRequest createPromotionTargetRequest(HttpServletRequest request) {
//        PromotionTargetInsertRequest promotionTargetInsertRequest = new PromotionTargetInsertRequest();
//        promotionTargetInsertRequest.setApplicableObjectId(EPromotionTargetType.WHOLE.toString());
//        promotionTargetInsertRequest.setType(EPromotionTargetType.WHOLE);
//
//        int quantity = getQuantity(request);
//        promotionTargetInsertRequest.setQuantity(quantity);
//
//        return promotionTargetInsertRequest;
//    }
//
//    private int getQuantity(HttpServletRequest request) {
//        String unlimited = request.getParameter("unlimited");
//        return "true".equals(unlimited) ? -1 : Integer.parseInt(request.getParameter("quantity"));
//    }
//
//    private void handleAddVoucher(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) throws Exception {
//        String minValueApplied = request.getParameter("minValueApplied");
//        handleAddPromotion(request, map, EPromotionType.VOUCHER, 100.0, Double.parseDouble(minValueApplied));
//    }
//
//    private void handleAddCoupon(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) throws Exception {
//        String percentDiscount = request.getParameter("percentDiscount");
//        handleAddPromotion(request, map, EPromotionType.COUPON, Double.parseDouble(percentDiscount), 0.0);
//    }
//
//    private void handleAddFreeShip(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) throws Exception {
//        handleAddPromotion(request, map, EPromotionType.FREESHIP, 100.0, 0.0);
//    }
//}
package com.biblio.apis.owner;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.service.IPromotionService;
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
    private IPromotionService promotionService;

    public AddPromotionAPI() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Parse JSON request to PromotionInsertRequest model
        PromotionInsertRequest promotionInsertRequest = HttpUtil.of(request.getReader()).toModel(PromotionInsertRequest.class);

        // Check if the code already exists
        boolean isCodeExisted = promotionService.isCodeExisted(promotionInsertRequest.getCode().trim());

        // Prepare response map
        Map<String, Object> map = new HashMap<>();
        if (isCodeExisted) {
            map.put("isCodeExisted", true);
            map.put("message", "Mã khuyến mãi đã tồn tại.");
        } else {
            // Additional logic for inserting promotion can be added here
            promotionService.insert(promotionInsertRequest); // Call to insert the promotion
            map.put("isCodeExisted", false);
            map.put("message", "Thêm khuyến mãi thành công.");
        }

        // Send JSON response
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mapper.writeValueAsString(map));
    }
}
