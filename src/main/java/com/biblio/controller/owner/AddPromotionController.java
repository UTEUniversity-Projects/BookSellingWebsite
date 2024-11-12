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
        } else if ("addCoupon".equals(formType)) {
            handleAddCoupon(request, response);
        } else if ("addFreeShip".equals(formType)) {
            handleAddFreeShip(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/owner/add-promotion");
    }

    // Hàm xử lý form thêm voucher
//    private void handleAddVoucher(HttpServletRequest request, HttpServletResponse response) {
//        PromotionInsertRequest promotionInsertRequest = new PromotionInsertRequest();
//
//        try {
//            BeanUtils.populate(promotionInsertRequest, request.getParameterMap());
//            promotionInsertRequest.setStatus(EPromotionStatus.EFFECTIVE);
//            promotionInsertRequest.setType(EPromotionType.VOUCHER);
//            promotionInsertRequest.setPercentDiscount(100);
//            String time = request.getParameter("dateeffective");
//
//            String[] parts = time.split(" - ");
//            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd hh:mm a");
//            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
//            int currentYear = LocalDateTime.now().getYear();
//            LocalDateTime startDateTime = LocalDateTime.parse(currentYear + "/" + parts[0], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
//            LocalDateTime endDateTime = LocalDateTime.parse(currentYear + "/" + parts[1], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
//            promotionInsertRequest.setEffectiveDate(startDateTime.format(outputFormatter));
//            promotionInsertRequest.setExpirationDate(endDateTime.format(outputFormatter));
//
//            PromotionTargetInsertRequest promotionTargetInsertRequest = new PromotionTargetInsertRequest();
//            promotionTargetInsertRequest.setApplicableObjectId(EPromotionTargetType.WHOLE.toString());
//            promotionTargetInsertRequest.setType(EPromotionTargetType.WHOLE);
//            String unlimited = request.getParameter("unlimited");
//            int quantity = getQuantity(request);
//            promotionTargetInsertRequest.setQuantity(quantity);
//
//            promotionInsertRequest.getPromotionTargets().add(promotionTargetInsertRequest);
//            promotionService.insert(promotionInsertRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // Gọi service để lưu vào database
//    }
//    private void handleAddCoupon(HttpServletRequest request, HttpServletResponse response) {
//        PromotionInsertRequest promotionInsertRequest = new PromotionInsertRequest();
//
//        try {
//            BeanUtils.populate(promotionInsertRequest, request.getParameterMap());
//            promotionInsertRequest.setStatus(EPromotionStatus.EFFECTIVE);
//            promotionInsertRequest.setType(EPromotionType.COUPON);
//            promotionInsertRequest.setMinValueApplied(0);
//            String time = request.getParameter("dateeffective");
//
//            String[] parts = time.split(" - ");
//            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd hh:mm a");
//            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
//            int currentYear = LocalDateTime.now().getYear();
//            LocalDateTime startDateTime = LocalDateTime.parse(currentYear + "/" + parts[0], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
//            LocalDateTime endDateTime = LocalDateTime.parse(currentYear + "/" + parts[1], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
//            promotionInsertRequest.setEffectiveDate(startDateTime.format(outputFormatter));
//            promotionInsertRequest.setExpirationDate(endDateTime.format(outputFormatter));
//
//            PromotionTargetInsertRequest promotionTargetInsertRequest = new PromotionTargetInsertRequest();
//            promotionTargetInsertRequest.setApplicableObjectId(EPromotionTargetType.WHOLE.toString());
//            promotionTargetInsertRequest.setType(EPromotionTargetType.WHOLE);
//            String unlimited = request.getParameter("unlimited");
//            int quantity = getQuantity(request);
//            promotionTargetInsertRequest.setQuantity(quantity);
//
//            promotionInsertRequest.getPromotionTargets().add(promotionTargetInsertRequest);
//            promotionService.insert(promotionInsertRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // Gọi service để lưu vào database
//    }
//    private void handleAddFreeShip(HttpServletRequest request, HttpServletResponse response) {
//        PromotionInsertRequest promotionInsertRequest = new PromotionInsertRequest();
//
//        try {
//            BeanUtils.populate(promotionInsertRequest, request.getParameterMap());
//            promotionInsertRequest.setStatus(EPromotionStatus.EFFECTIVE);
//            promotionInsertRequest.setType(EPromotionType.FREESHIP);
//            promotionInsertRequest.setPercentDiscount(100);
//            promotionInsertRequest.setMinValueApplied(0);
//            String time = request.getParameter("dateeffective");
//
//            String[] parts = time.split(" - ");
//            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd hh:mm a");
//            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
//            int currentYear = LocalDateTime.now().getYear();
//            LocalDateTime startDateTime = LocalDateTime.parse(currentYear + "/" + parts[0], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
//            LocalDateTime endDateTime = LocalDateTime.parse(currentYear + "/" + parts[1], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
//            promotionInsertRequest.setEffectiveDate(startDateTime.format(outputFormatter));
//            promotionInsertRequest.setExpirationDate(endDateTime.format(outputFormatter));
//
//            PromotionTargetInsertRequest promotionTargetInsertRequest = new PromotionTargetInsertRequest();
//            promotionTargetInsertRequest.setApplicableObjectId(EPromotionTargetType.WHOLE.toString());
//            promotionTargetInsertRequest.setType(EPromotionTargetType.WHOLE);
//            String unlimited = request.getParameter("unlimited");
//            int quantity = getQuantity(request);
//            promotionTargetInsertRequest.setQuantity(quantity);
//
//            promotionInsertRequest.getPromotionTargets().add(promotionTargetInsertRequest);
//            promotionService.insert(promotionInsertRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // Gọi service để lưu vào database
//    }
//    public int getQuantity(HttpServletRequest request) {
//        String unlimited = request.getParameter("unlimited");
//
//        if ("true".equals(unlimited)) {
//            return -1;
//        } else {
//            return Integer.parseInt(request.getParameter("quantity"));
//        }
//    }

    private void handleAddPromotion(HttpServletRequest request, HttpServletResponse response, EPromotionType type, Double percentDiscount, Double minValueApplied) {
        PromotionInsertRequest promotionInsertRequest = new PromotionInsertRequest();

        try {
            BeanUtils.populate(promotionInsertRequest, request.getParameterMap());
            Boolean isCodeExist = promotionService.isCodeExist(promotionInsertRequest.getCode());
            if (isCodeExist) {
                request.setAttribute("errorMessage", "Mã khuyến mãi đã tồn tại.");
                request.getRequestDispatcher("/owner/add-promotion").forward(request, response);
                return;
            }

            promotionInsertRequest.setStatus(EPromotionStatus.EFFECTIVE);
            promotionInsertRequest.setType(type);
            promotionInsertRequest.setPercentDiscount(percentDiscount);
            promotionInsertRequest.setMinValueApplied(minValueApplied);

            String time = request.getParameter("dateeffective");
            setPromotionDates(time, promotionInsertRequest);

            PromotionTargetInsertRequest promotionTargetInsertRequest = createPromotionTargetRequest(request);
            promotionInsertRequest.getPromotionTargets().add(promotionTargetInsertRequest);

            promotionService.insert(promotionInsertRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPromotionDates(String time, PromotionInsertRequest promotionInsertRequest) {
        try {
            String[] parts = time.split(" - ");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            int currentYear = LocalDateTime.now().getYear();

            LocalDateTime startDateTime = LocalDateTime.parse(currentYear + "/" + parts[0], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));
            LocalDateTime endDateTime = LocalDateTime.parse(currentYear + "/" + parts[1], DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a"));

            promotionInsertRequest.setEffectiveDate(startDateTime.format(outputFormatter));
            promotionInsertRequest.setExpirationDate(endDateTime.format(outputFormatter));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PromotionTargetInsertRequest createPromotionTargetRequest(HttpServletRequest request) {
        PromotionTargetInsertRequest promotionTargetInsertRequest = new PromotionTargetInsertRequest();
        promotionTargetInsertRequest.setApplicableObjectId(EPromotionTargetType.WHOLE.toString());
        promotionTargetInsertRequest.setType(EPromotionTargetType.WHOLE);

        int quantity = getQuantity(request);
        promotionTargetInsertRequest.setQuantity(quantity);

        return promotionTargetInsertRequest;
    }

    private int getQuantity(HttpServletRequest request) {
        String unlimited = request.getParameter("unlimited");
        return "true".equals(unlimited) ? -1 : Integer.parseInt(request.getParameter("quantity"));
    }

    // Các phương thức gọi chung
    private void handleAddVoucher(HttpServletRequest request, HttpServletResponse response) {
        String minValueApplied = request.getParameter("minValueApplied");
        handleAddPromotion(request, response, EPromotionType.VOUCHER,  100.0, Double.parseDouble(minValueApplied));
    }

    private void handleAddCoupon(HttpServletRequest request, HttpServletResponse response) {
        String percentDiscount = request.getParameter("percentDiscount");
        handleAddPromotion(request, response, EPromotionType.COUPON, Double.parseDouble(percentDiscount), 0.0); // percentDiscount 0, minValueApplied 0
    }

    private void handleAddFreeShip(HttpServletRequest request, HttpServletResponse response) {
        handleAddPromotion(request, response, EPromotionType.FREESHIP, 100.0, 0.0); // percentDiscount 100, minValueApplied 0
    }

}

