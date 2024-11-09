package com.biblio.controller.owner;

import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.service.ICustomerService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
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

                if ("deactivate".equals(action)) {
                    customerService.deactivateCustomer(customerId);
                    response.getWriter().write("success");
                } else if ("activate".equals(action)) {
                    customerService.activateCustomer(customerId);
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
}
