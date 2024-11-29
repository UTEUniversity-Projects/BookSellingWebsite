package com.biblio.apis.staff;

import com.biblio.dto.response.NotificationGetResponse;
import com.biblio.service.IStaffService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet(urlPatterns = {"/api/staff/notification/get"})
public class GetNotificationAPI extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    IStaffService staffService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNotificationAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String staffId = request.getParameter("id");
        List<NotificationGetResponse> notificationGetResponse = staffService.getAllNotificationByStaffId(Long.parseLong(staffId));
        writeResponse(response, notificationGetResponse);
    }



    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
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