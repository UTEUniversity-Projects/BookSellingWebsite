package com.biblio.controller.owner;

import com.biblio.dto.request.*;
import com.biblio.dto.response.*;
import com.biblio.entity.PromotionTemplate;
import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionTargetType;
import com.biblio.enumeration.EPromotionTemplateStatus;
import com.biblio.enumeration.EPromotionTemplateType;
import com.biblio.service.IPromotionService;
import com.biblio.service.IPromotionTemplateService;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Servlet implementation class PromotionDetailsController
 */
@WebServlet("/owner/promotion-details")
public class PromotionDetailsController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IPromotionTemplateService promotionTemplateService;
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
        PromotionTemplateGetDetailsResponse promotionTemplateGetDetailsResponse = promotionTemplateService.getPromotionTemplateById(Long.parseLong(id));
        request.setAttribute("promotion", promotionTemplateGetDetailsResponse);
        request.getRequestDispatcher("/views/owner/promotion-details.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String formType = request.getParameter("formType");

        if ("editVoucher".equals(formType)) {
            handleEditVoucher(request, response);
        } else if ("editFreeShip".equals(formType)) {
            handleAddFreeShip(request, response);
        }
    }


    private void handleEditPromotion(HttpServletRequest request, HttpServletResponse response, EPromotionTemplateType type, Double percentDiscount, Double minValueApplied) {
        PromotionTemplate promotionTemplate = new PromotionTemplate();
        String code = request.getParameter("code");

        try {
            PromotionTemplateGetDetailsResponse promotionTemplateGetDetailsResponse = promotionTemplateService.getPromotionTemplateByCode(code);

            if (Objects.equals(promotionTemplateGetDetailsResponse.getStatus(), EPromotionTemplateStatus.EFFECTIVE.toString())) {
                if (promotionTemplateGetDetailsResponse.getQuantity() == Long.parseLong(request.getParameter("quantity"))) {

                    PromotionTemplateResponse promotionTemplateResponse = promotionTemplateService.getPromotionTemplateDetailsById(promotionTemplateGetDetailsResponse.getId());

                    PromotionTemplateUpdateRequest promotionTemplateUpdateRequest = new PromotionTemplateUpdateRequest();

                    promotionTemplateUpdateRequest.setId(promotionTemplateResponse.getId());
                    promotionTemplateUpdateRequest.setCode(promotionTemplateResponse.getCode());
                    promotionTemplateUpdateRequest.setCreateAt(promotionTemplateResponse.getCreateAt());
                    promotionTemplateUpdateRequest.setIsInfinite(promotionTemplateResponse.getIsInfinite());
                    promotionTemplateUpdateRequest.setStatus(promotionTemplateResponse.getStatus());
                    promotionTemplateUpdateRequest.setType(promotionTemplateResponse.getType());

                    for (PromotionResponse promotionResponse : promotionTemplateResponse.getPromotions()) {
                        PromotionUpdateRequest promotionUpdateRequest = new PromotionUpdateRequest();

                        promotionUpdateRequest.setId(promotionResponse.getId());
                        promotionUpdateRequest.setTitle(request.getParameter("title"));
                        promotionUpdateRequest.setDescription(request.getParameter("description"));
                        promotionUpdateRequest.setPercentDiscount(percentDiscount);
                        promotionUpdateRequest.setMinValueApplied(minValueApplied);
                        promotionUpdateRequest.setDiscountLimit(Double.parseDouble(request.getParameter("discountLimit")));
                        promotionUpdateRequest.setStatus(promotionResponse.getStatus());
                        promotionUpdateRequest.setEffectiveDate(promotionResponse.getEffectiveDate());
                        promotionUpdateRequest.setExpirationDate(convertToIsoFormat(request.getParameter("dateeffective")));

                        for (PromotionTargetResponse promotionTargetResponse : promotionResponse.getPromotionTargets()) {
                            PromotionTargetUpdateRequest promotionTargetUpdateRequest = new PromotionTargetUpdateRequest();

                            promotionTargetUpdateRequest.setId(promotionTargetResponse.getId());
                            promotionTargetUpdateRequest.setType(EPromotionTargetType.WHOLE);
                            promotionTargetUpdateRequest.setApplicableObjectId(promotionTargetResponse.getApplicableObjectId());
                            promotionUpdateRequest.getPromotionTargets().add(promotionTargetUpdateRequest);
                        }

                        promotionTemplateUpdateRequest.getPromotionUpdates().add(promotionUpdateRequest);
                    }
                    promotionTemplateService.updatePromotionTemplate(promotionTemplateUpdateRequest);
                    response.sendRedirect(request.getContextPath() + "promotion-details?id=" + promotionTemplateUpdateRequest.getId());

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String convertToIsoFormat(String input) {
        try {
            // Lấy năm hiện tại
            int currentYear = LocalDate.now().getYear();

            // Định dạng chuỗi đầu vào
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd hh:mm a");

            // Chuyển chuỗi đầu vào sang LocalDateTime
            LocalDateTime parsedDateTime = LocalDateTime.parse(
                    currentYear + "-" + input,
                    DateTimeFormatter.ofPattern("yyyy-MM/dd hh:mm a")
            );

            // Định dạng lại kết quả theo ISO 8601 (yyyy-MM-dd'T'HH:mm)
            DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            return parsedDateTime.format(isoFormatter);

        } catch (Exception e) {
            throw new RuntimeException("Error parsing date: " + input, e);
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
       // promotionTargetInsertRequest.setApplicableObjectId(EPromotionTargetType.WHOLE.toString());
        promotionTargetInsertRequest.setType(EPromotionTargetType.WHOLE);

        int quantity = getQuantity(request);
       // promotionTargetInsertRequest.setQuantity(quantity);

        return promotionTargetInsertRequest;
    }

    private int getQuantity(HttpServletRequest request) {
        String unlimited = request.getParameter("unlimited");
        return "true".equals(unlimited) ? -1 : Integer.parseInt(request.getParameter("quantity"));
    }

    // Các phương thức gọi chung
    private void handleEditVoucher(HttpServletRequest request, HttpServletResponse response) {
        String minValueApplied = request.getParameter("minValueApplied");
        handleEditPromotion(request, response, EPromotionTemplateType.VOUCHER,  100.0, Double.parseDouble(minValueApplied));
    }

    private void handleAddFreeShip(HttpServletRequest request, HttpServletResponse response) {
        //handleAddPromotion(request, response, EPromotionTemplateType.FREESHIP, 100.0, 0.0); // percentDiscount 100, minValueApplied 0
    }

}