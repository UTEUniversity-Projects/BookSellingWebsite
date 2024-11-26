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
import java.io.OutputStream;
import java.io.Serial;
import java.net.HttpURLConnection;
import java.net.URL;
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

                case "/transport-order":
                    handleTransportOrder(request, response, result, mapper);
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
        /*double finalPrice = Double.parseDouble(jsonMap.get("finalPrice").toString());*/
        if (success) {
            result.put("message", "Đơn hàng được xác nhận thành công!");
            result.put("type", "success");
            result.put("statusType", EOrderStatus.PACKING.name());
            result.put("status", EOrderStatus.PACKING.getDescription());
            result.put("statusStyle", EOrderStatus.PACKING.getStatusStyle());
            sendOrderConfirmationEmail(request,orderId/*, finalPrice*/);
        } else {
            result.put("message", "Không thể xác nhận đơn hàng. Vui lòng thử lại!");
            result.put("type", "info");
        }
        response.getWriter().write(mapper.writeValueAsString(result));
    }

    private void handleCancelOrder(HttpServletRequest request, HttpServletResponse response, Map<String, String> result, ObjectMapper mapper) throws IOException {
        Map<String, Object> jsonMap = mapper.readValue(request.getReader(), Map.class);
        long orderId = Long.parseLong(jsonMap.get("orderId").toString());
        String cancelContent = jsonMap.get("content").toString();

        boolean success = orderService.updateStatus(orderId, EOrderStatus.CANCELED);
        if (success) {
            result.put("message", "Đơn hàng được hủy thành công!");
            result.put("type", "success");
            result.put("statusType", EOrderStatus.CANCELED.name());
            result.put("status", EOrderStatus.CANCELED.getDescription());
            result.put("statusStyle", EOrderStatus.CANCELED.getStatusStyle());
            sendCancelOrderEmail(request,orderId,cancelContent);
        } else {
            result.put("message", "Không thể hủy đơn hàng. Vui lòng thử lại!");
            result.put("type", "info");
        }
        response.getWriter().write(mapper.writeValueAsString(result));
    }

    private void sendOrderConfirmationEmail(HttpServletRequest request ,Long orderId/*, Double finalPrice*/) throws IOException {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = request.getContextPath();

        String apiUrl = scheme + "://" + serverName;
        if ((scheme.equals("http") && serverPort != 80) || (scheme.equals("https") && serverPort != 443)) {
            apiUrl += ":" + serverPort;
        }
        apiUrl += contextPath + "/staff/email/order-confirmation";

        HttpURLConnection connection = null;

        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Gửi thông tin orderId qua body của request
            String params = "orderId=" + orderId /*+ "&finalPrice=" + finalPrice*/;
            try (OutputStream os = connection.getOutputStream()) {
                os.write(params.getBytes());
                os.flush();
            }

            // Kiểm tra phản hồi từ API
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpServletResponse.SC_OK) {
                throw new IOException("Gửi email thất bại! Mã lỗi: " + responseCode);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void sendCancelOrderEmail(HttpServletRequest request,Long orderId, String cancelContent) throws IOException {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = request.getContextPath();

        String apiUrl = scheme + "://" + serverName;
        if ((scheme.equals("http") && serverPort != 80) || (scheme.equals("https") && serverPort != 443)) {
            apiUrl += ":" + serverPort;
        }
        apiUrl += contextPath + "/staff/email/order-cancellation";
        HttpURLConnection connection = null;

        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Gửi thông tin orderId qua body của request
            String params = "orderId=" + orderId + "&cancelContent=" + cancelContent;
            try (OutputStream os = connection.getOutputStream()) {
                os.write(params.getBytes());
                os.flush();
            }

            // Kiểm tra phản hồi từ API
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpServletResponse.SC_OK) {
                throw new IOException("Gửi email hủy đơn hàng thất bại! Mã lỗi: " + responseCode);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void handleTransportOrder(HttpServletRequest request, HttpServletResponse response, Map<String, String> result, ObjectMapper mapper) throws IOException {
        Map<String, Object> jsonMap = mapper.readValue(request.getReader(), Map.class);
        long orderId = Long.parseLong(jsonMap.get("orderId").toString());
        boolean success = orderService.updateStatus(orderId, EOrderStatus.SHIPPING);
        if (success) {
            result.put("message", "Đơn hàng được chuyển đến đơn vị vận chuyển thành công!");
            result.put("type", "success");
            result.put("statusType", EOrderStatus.SHIPPING.name());
            result.put("status", EOrderStatus.SHIPPING.getDescription());
            result.put("statusStyle", EOrderStatus.SHIPPING.getStatusStyle());
        } else {
            result.put("message", "Không thể xác nhận đơn hàng. Vui lòng thử lại!");
            result.put("type", "info");
        }
        response.getWriter().write(mapper.writeValueAsString(result));
    }
}
