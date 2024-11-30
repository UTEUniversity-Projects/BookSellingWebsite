package com.biblio.apis.staff;

import com.biblio.dto.response.AccountGetResponse;
import com.biblio.dto.response.NotificationGetResponse;
import com.biblio.service.IStaffService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/api/staff/notification/get"})
public class GetNotificationAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    IStaffService staffService;

    public GetNotificationAPI() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Lấy session hiện tại
        HttpSession session = request.getSession(false); // false để không tạo mới session nếu chưa tồn tại

        // Kiểm tra xem session có chứa "account" hay không
        AccountGetResponse account = (session != null) ? (AccountGetResponse) session.getAttribute("account") : null;

        System.out.println(account.getId());
        if (account == null) {
            // Nếu không có account trong session, trả về lỗi hoặc yêu cầu đăng nhập
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // HTTP 401 Unauthorized
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("status", "error");
            errorMap.put("message", "Bạn cần đăng nhập để thực hiện hành động này.");
            writeResponse(response, errorMap);
            return;
        }

        Long staffId = staffService.findIdStaffByAccountId(account.getId());
        List<NotificationGetResponse> notificationGetResponse = staffService.getAllNotificationByStaffId(staffId);
        writeResponse(response, notificationGetResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void writeResponse(HttpServletResponse response, Object responseObject) throws IOException {
        // Tạo đối tượng ObjectMapper để chuyển đối tượng Java thành JSON
        ObjectMapper objectMapper = new ObjectMapper();
        // Chuyển đối tượng responseObject thành chuỗi JSON
        String jsonResponse = objectMapper.writeValueAsString(responseObject);
        // Gửi chuỗi JSON về phía client
        response.getWriter().write(jsonResponse);
    }
}
