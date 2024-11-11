package com.biblio.controller.owner;

import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.service.IPromotionService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class PromotionDetailsController
 */
@WebServlet("/owner/promotion-details")
public class PromotionDetailsController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IPromotionService promotionService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromotionDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = request.getParameter("id");
        PromotionGetResponse promotion = promotionService.findById(Long.parseLong(id));
        request.setAttribute("promotion", promotion);
        request.getRequestDispatcher("/views/owner/promotion-details.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}