package com.biblio.apis.staff;


import com.biblio.enumeration.EOrderStatus;
import com.biblio.service.IOrderService;
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

@WebServlet(urlPatterns = {"/staff/order/*"})
public class OrderAPI extends HttpServlet {
    @Inject
    IOrderService orderService;

    @Serial
    private static final long serialVersionUID = 1L;

    public OrderAPI() {
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
                case "/confirm-order":
                    handleConfirmOrder(request, response, result, mapper);
                    break;

                case "/cancel-order":
                    handleCancelOrder(request, response, result, mapper);
                    break;


                default:
                    result.put("message", "Không tìm thấy hành động phù hợp!");
                    result.put("type", "error");
                    response.getWriter().write(mapper.writeValueAsString(result));
                    break;
            }
        } catch (Exception e) {
            result.put("message", "Có lỗi xảy ra trong quá trình xử lý yêu cầu.");
            result.put("type", "error");
            response.getWriter().write(mapper.writeValueAsString(result));
        }
    }

    private void handleConfirmOrder(HttpServletRequest request, HttpServletResponse response, Map<String, String> result, ObjectMapper mapper) throws IOException {
        Map<String, Object> jsonMap = mapper.readValue(request.getReader(), Map.class);
        long orderId = Long.parseLong(jsonMap.get("orderId").toString());
        boolean success = orderService.updateStatus(orderId, EOrderStatus.PACKING);
        if (success) {
            result.put("message", "Đơn hàng được xác nhận thành công!");
            result.put("type", "success");
            result.put("status", EOrderStatus.PACKING.getDescription());
            result.put("statusStyle", EOrderStatus.PACKING.getStatusStyle());
        } else {
            result.put("message", "Không thể xác nhận đơn hàng. Vui lòng thử lại!");
            result.put("type", "info");
        }
        response.getWriter().write(mapper.writeValueAsString(result));
    }

    private void handleCancelOrder(HttpServletRequest request, HttpServletResponse response, Map<String, String> result, ObjectMapper mapper) throws IOException {
        Map<String, Object> jsonMap = mapper.readValue(request.getReader(), Map.class);
        long orderId = Long.parseLong(jsonMap.get("orderId").toString());
        boolean success = orderService.updateStatus(orderId, EOrderStatus.CANCELED);
        if (success) {
            result.put("message", "Đơn hàng được hủy thành công!");
            result.put("type", "success");
            result.put("status", EOrderStatus.CANCELED.getDescription());
            result.put("statusStyle", EOrderStatus.CANCELED.getStatusStyle());
        } else {
            result.put("message", "Không thể hủy đơn hàng. Vui lòng thử lại!");
            result.put("type", "info");
        }
        response.getWriter().write(mapper.writeValueAsString(result));
    }
}
