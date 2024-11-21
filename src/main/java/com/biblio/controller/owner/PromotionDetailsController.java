package com.biblio.controller.owner;

import com.biblio.dto.request.PromotionTargetInsertRequest;
import com.biblio.dto.request.PromotionTargetUpdateRequest;
import com.biblio.dto.request.PromotionTemplateUpdateRequest;
import com.biblio.dto.request.PromotionUpdateRequest;
import com.biblio.dto.response.PromotionResponse;
import com.biblio.dto.response.PromotionTargetResponse;
import com.biblio.dto.response.PromotionTemplateGetDetailsResponse;
import com.biblio.dto.response.PromotionTemplateResponse;
import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionTargetType;
import com.biblio.enumeration.EPromotionTemplateStatus;
import com.biblio.enumeration.EPromotionTemplateType;
import com.biblio.service.IPromotionTemplateService;

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
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
        String id = request.getParameter("id");
        PromotionTemplateGetDetailsResponse promotionTemplateGetDetailsResponse = promotionTemplateService.getPromotionTemplateById(Long.parseLong(id));

        // Lấy danh sách id từ PromotionTargetResponse
        Set<Long> selectedIds = promotionTemplateGetDetailsResponse.getPromotionTargetResponse()
                .stream()
                .map(PromotionTargetResponse::getApplicableObjectId)
                .collect(Collectors.toSet());

        // Lấy giá trị type đầu tiên
        String firstType = promotionTemplateGetDetailsResponse.getPromotionTargetResponse()
                .stream()
                .findFirst()
                .map(PromotionTargetResponse::getType)
                .orElse(null);

        request.setAttribute("promotion", promotionTemplateGetDetailsResponse);
        request.setAttribute("selectedType", firstType); // Gửi type đầu tiên đến JSP
        request.setAttribute("selectedIds", selectedIds); // Gửi danh sách id về JSP
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
            handleEditFreeShip(request, response);
        }
    }


    private void handleEditPromotion(HttpServletRequest request, HttpServletResponse response, EPromotionTemplateType type, Double percentDiscount, Double minValueApplied) {
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String discountLimit = request.getParameter("discountLimit");
        String time = request.getParameter("dateeffective");
        String quantity = request.getParameter("quantity");
        Boolean F = false;
        Boolean T = true;

        try {
            PromotionTemplateGetDetailsResponse promotionTemplateGetDetailsResponse = promotionTemplateService.getPromotionTemplateByCode(code);

            if (Objects.equals(promotionTemplateGetDetailsResponse.getStatus(), EPromotionTemplateStatus.EFFECTIVE.toString())
                    || Objects.equals(promotionTemplateGetDetailsResponse.getStatus(), EPromotionTemplateStatus.COMING_SOON.toString()) ||
                    Objects.equals(promotionTemplateGetDetailsResponse.getStatus(), EPromotionTemplateStatus.USED_OUT.toString())) {

                PromotionTemplateResponse promotionTemplateResponse = promotionTemplateService.getPromotionTemplateDetailsById(promotionTemplateGetDetailsResponse.getId());

                PromotionTemplateUpdateRequest promotionTemplateUpdateRequest = convertToUpdateRequest(promotionTemplateResponse, quantity);

                Optional<String> optionalStartDate = promotionTemplateUpdateRequest
                        .getPromotionUpdates()
                        .stream()
                        .map(PromotionUpdateRequest::getEffectiveDate)
                        .findFirst();

                String startDate = optionalStartDate.orElse(null);
                if (quantity == null) {
                    quantity = "1";
                }
                for (int i = 0; i < Long.parseLong(quantity); i++) {
                    PromotionUpdateRequest promotionUpdateRequest = new PromotionUpdateRequest();

                    promotionUpdateRequest.setTitle(title);
                    promotionUpdateRequest.setDescription(description);
                    promotionUpdateRequest.setPercentDiscount(percentDiscount);
                    promotionUpdateRequest.setMinValueApplied(minValueApplied);
                    promotionUpdateRequest.setDiscountLimit(Double.parseDouble(discountLimit));
                    promotionUpdateRequest.setStatus(EPromotionStatus.NOT_USE);

                    if (promotionTemplateResponse.getStatus() == EPromotionTemplateStatus.EFFECTIVE || promotionTemplateResponse.getStatus() == EPromotionTemplateStatus.USED_OUT) {
                        promotionUpdateRequest.setEffectiveDate(startDate);
                        promotionUpdateRequest.setExpirationDate(convertToIsoFormat(request.getParameter("dateeffective")));
                    } else {
                        String[] parts = time.split(" - ");
                        promotionUpdateRequest.setEffectiveDate(convertToIsoFormat(parts[0]));
                        promotionUpdateRequest.setExpirationDate(convertToIsoFormat(parts[1]));
                    }

                    PromotionTargetUpdateRequest promotionTargetUpdate_add = new PromotionTargetUpdateRequest();
                    promotionTargetUpdate_add.setType(EPromotionTargetType.WHOLE);
                    promotionTargetUpdate_add.setApplicableObjectId(-1L);
                    promotionUpdateRequest.getPromotionTargets().add(promotionTargetUpdate_add);

                    promotionTemplateUpdateRequest.getPromotionUpdates().add(promotionUpdateRequest);
                }
                promotionTemplateService.updatePromotionTemplate(promotionTemplateUpdateRequest);
                response.sendRedirect("/owner/promotion-details?id=" + promotionTemplateUpdateRequest.getId());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String convertToIsoFormat(String input) {
        try {
            // Định dạng chuỗi đầu vào
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("M/dd/yyyy hh:mm a");

            // Chuyển chuỗi đầu vào sang LocalDateTime
            LocalDateTime parsedDateTime = LocalDateTime.parse(input, inputFormatter);

            // Định dạng lại kết quả theo ISO 8601 (yyyy-MM-dd'T'HH:mm)
            DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            return parsedDateTime.format(isoFormatter);

        } catch (Exception e) {
            throw new RuntimeException("Error parsing date: " + input, e);
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

    private void handleEditFreeShip(HttpServletRequest request, HttpServletResponse response) {
        handleEditPromotion(request, response, EPromotionTemplateType.FREESHIP, 100.0, 0.0); // percentDiscount 100, minValueApplied 0
    }



    public PromotionTemplateUpdateRequest convertToUpdateRequest(PromotionTemplateResponse promotionTemplateResponse, String quantity) {
        PromotionTemplateUpdateRequest promotionTemplateUpdateRequest = new PromotionTemplateUpdateRequest();

        promotionTemplateUpdateRequest.setId(promotionTemplateResponse.getId());

        if (quantity == null) {
            promotionTemplateUpdateRequest.setInfinite(true);
        } else {
            promotionTemplateUpdateRequest.setInfinite(false);
        }

        promotionTemplateUpdateRequest.setCode(promotionTemplateResponse.getCode());
        promotionTemplateUpdateRequest.setCreateAt(promotionTemplateResponse.getCreateAt());
        promotionTemplateUpdateRequest.setStatus(promotionTemplateResponse.getStatus());
        promotionTemplateUpdateRequest.setType(promotionTemplateResponse.getType());

        for (PromotionResponse promotionResponse : promotionTemplateResponse.getPromotions()) {
            PromotionUpdateRequest promotionUpdateRequest = new PromotionUpdateRequest();

            promotionUpdateRequest.setId(promotionResponse.getId());
            promotionUpdateRequest.setTitle(promotionResponse.getTitle());
            promotionUpdateRequest.setDescription(promotionResponse.getDescription());
            promotionUpdateRequest.setPercentDiscount(promotionResponse.getPercentDiscount());
            promotionUpdateRequest.setMinValueApplied(promotionResponse.getMinValueApplied());
            promotionUpdateRequest.setDiscountLimit(promotionResponse.getDiscountLimit());
            promotionUpdateRequest.setStatus(EPromotionStatus.USED);
            promotionUpdateRequest.setEffectiveDate(promotionResponse.getEffectiveDate());
            promotionUpdateRequest.setExpirationDate(promotionResponse.getExpirationDate());

            for (PromotionTargetResponse promotionTargetResponse : promotionResponse.getPromotionTargets()) {
                PromotionTargetUpdateRequest promotionTargetUpdateRequest = new PromotionTargetUpdateRequest();

                promotionTargetUpdateRequest.setId(promotionTargetResponse.getId());
                promotionTargetUpdateRequest.setType(EPromotionTargetType.WHOLE);
                promotionTargetUpdateRequest.setApplicableObjectId(promotionTargetResponse.getApplicableObjectId());
                promotionUpdateRequest.getPromotionTargets().add(promotionTargetUpdateRequest);
            }

            promotionTemplateUpdateRequest.getPromotionUpdates().add(promotionUpdateRequest);
        }
        return promotionTemplateUpdateRequest;
    }


}