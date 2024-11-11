package com.biblio.controller.owner;

import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTargetInsertRequest;
import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionTargetType;
import com.biblio.enumeration.EPromotionType;
import com.biblio.service.IPromotionService;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/owner/add-promotion")
public class AddPromotionController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IPromotionService promotionService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPromotionController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getRequestDispatcher("/views/owner/add-promotion.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String formType = request.getParameter("formType");

        if ("addVoucher".equals(formType)) {
            handleAddVoucher(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/owner/add-promotion");
    }

    // Hàm xử lý form thêm voucher
    private void handleAddVoucher(HttpServletRequest request, HttpServletResponse response) {
        PromotionInsertRequest promotionInsertRequest = new PromotionInsertRequest();

        try {
            // Ánh xạ dữ liệu từ request sang VoucherDTO
            BeanUtils.populate(promotionInsertRequest, request.getParameterMap());
            promotionInsertRequest.setStatus(EPromotionStatus.EFFECTIVE);
            promotionInsertRequest.setType(EPromotionType.VOUCHER);
            promotionInsertRequest.setPercentDiscount(100);
            String time = request.getParameter("dateeffective");

            String[] parts = time.split(" - ");
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd hh:mm a");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            int currentYear = LocalDateTime.now().getYear();
            LocalDateTime startDateTime = LocalDateTime.parse(currentYear + "/" + parts[0], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
            LocalDateTime endDateTime = LocalDateTime.parse(currentYear + "/" + parts[1], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
            promotionInsertRequest.setEffectiveDate(startDateTime.format(outputFormatter));
            promotionInsertRequest.setExpirationDate(endDateTime.format(outputFormatter));

            PromotionTargetInsertRequest promotionTargetInsertRequest = new PromotionTargetInsertRequest();
            promotionTargetInsertRequest.setApplicableObjectId(EPromotionTargetType.WHOLE.toString());
            promotionTargetInsertRequest.setQuantity(1);
            promotionTargetInsertRequest.setType(EPromotionTargetType.WHOLE);

            promotionService.insert(promotionInsertRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Gọi service để lưu vào database
    }
}
