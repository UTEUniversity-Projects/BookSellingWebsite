package com.biblio.controller.owner;

import com.biblio.dto.response.CustomerDetailResponse;
import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.service.ICustomerService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serial;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/owner/customer-list")
public class CustomerListController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private ICustomerService customerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CustomerGetListResponse> list = customerService.findAll();
        request.setAttribute("customers", list);
        request.getRequestDispatcher("/views/owner/customer-list.jsp").forward(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if (action != null && id != null) {
            try {
                long customerId = Long.parseLong(id);
                CustomerDetailResponse customer = customerService.findById(customerId);
                if ("deactivate".equals(action)) {
                    customerService.deactivateCustomer(customerId);
                    sendEmailRequest(action, customer.getEmail(), customer.getFullName());
                    response.getWriter().write("success");
                } else if ("activate".equals(action)) {
                    customerService.activateCustomer(customerId);
                    sendEmailRequest(action, customer.getEmail(), customer.getFullName());
                    response.getWriter().write("success");
                }
            } catch (NumberFormatException e) {
                response.getWriter().write("error");
            }
            return;
        }

        // Nếu không có action và id, ta có thể chuyển tiếp để lấy danh sách
        doGet(request, response);

    }
    private void sendEmailRequest(String action, String customerEmail, String customerName) throws IOException {

        URL url = new URL("http://localhost:8080/BookSellingWebsite/email");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); // Đặt mã hóa UTF-8

        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) { // Đặt mã hóa UTF-8
            String data = "action=" + URLEncoder.encode(action, "UTF-8") +
                    "&customerEmail=" + URLEncoder.encode(customerEmail, "UTF-8") +
                    "&customerName=" + URLEncoder.encode(customerName, "UTF-8");
            out.write(data);
            out.flush();
            System.out.println("Data sent to EmailController: " + data); // Kiểm tra dữ liệu gửi
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Email sent successfully.");
        } else {
            System.err.println("Failed to send email: " + connection.getResponseMessage());
        }

        connection.disconnect();
    }
}
