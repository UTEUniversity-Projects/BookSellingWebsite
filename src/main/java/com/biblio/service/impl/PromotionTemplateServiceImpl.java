package com.biblio.service.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.dao.IPromotionDAO;
import com.biblio.dao.IPromotionTemplateDAO;
import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.request.PromotionTemplateUpdateRequest;
import com.biblio.dto.response.ApplyCodePromotionResponse;
import com.biblio.dto.response.PromotionTemplateGetDetailsResponse;
import com.biblio.dto.response.PromotionTemplateGetResponse;
import com.biblio.dto.response.PromotionTemplateResponse;
import com.biblio.entity.*;
import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionTemplateStatus;
import com.biblio.enumeration.EPromotionTemplateType;
import com.biblio.mapper.PromotionTemplateMapper;
import com.biblio.service.IPromotionTemplateService;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PromotionTemplateServiceImpl implements IPromotionTemplateService {
    @Inject
    IPromotionDAO promotionDAO;
    @Inject
    IPromotionTemplateDAO promotionTemplateDAO;
    @Inject
    IBookTemplateDAO bookTemplateDAO;

    @Override
    public PromotionTemplateGetDetailsResponse getPromotionTemplateById(Long id) {
        PromotionTemplate promotionTemplate = promotionTemplateDAO.findById(id);
        List<Promotion> promotions = promotionDAO.findAllById(promotionTemplate.getId());
        updatePromotionTemplateStatus(promotionTemplate, promotions);
        List<Promotion> updatedPromotions = promotionDAO.findAllById(promotionTemplate.getId());
        return PromotionTemplateMapper.toPromotionTemplateGetDetailsResponse(updatedPromotions);
    }

    @Override
    public PromotionTemplateResponse getPromotionTemplateDetailsById(Long id) {
        PromotionTemplate promotionTemplate = promotionTemplateDAO.findById(id);
        List<Promotion> promotions = promotionDAO.findAllById(promotionTemplate.getId());
        updatePromotionTemplateStatus(promotionTemplate, promotions);
        PromotionTemplate promotionTemplateUpdate = promotionTemplateDAO.findById(id);
        return PromotionTemplateMapper.toPromotionTemplateResponse(promotionTemplateUpdate);
    }


    @Override
    public PromotionTemplateGetDetailsResponse getPromotionTemplateByCode(String code) {
        PromotionTemplate promotionTemplate = promotionTemplateDAO.findSingleByJPQL(code);
        List<Promotion> promotions = promotionDAO.findAllById(promotionTemplate.getId());
        updatePromotionTemplateStatus(promotionTemplate, promotions);
        List<Promotion> updatedPromotions = promotionDAO.findAllById(promotionTemplate.getId());
        return PromotionTemplateMapper.toPromotionTemplateGetDetailsResponse(updatedPromotions);
    }

    @Override
    public List<PromotionTemplateGetResponse> getAllPromotionTemplates() {
        List<PromotionTemplateGetResponse> list = new ArrayList<>();
        List<PromotionTemplate> promotionTemplates = promotionTemplateDAO.findByJPQL();

        for (PromotionTemplate promotionTemplate : promotionTemplates) {
            List<Promotion> promotions = promotionDAO.findAllById(promotionTemplate.getId());
            updatePromotionTemplateStatus(promotionTemplate, promotions);
            List<Promotion> updatedPromotions = promotionDAO.findAllById(promotionTemplate.getId());
            list.add(PromotionTemplateMapper.toPromotionTemplateGetResponse(updatedPromotions));
        }
        return list;
    }

    @Override
    public void updatePromotionTemplate(PromotionTemplateUpdateRequest promotionTemplateUpdateRequest) {
        PromotionTemplate promotionTemplate = PromotionTemplateMapper.toPromotionTemplate(promotionTemplateUpdateRequest);
        promotionTemplateDAO.update(promotionTemplate);
    }


    @Override
    public PromotionTemplateResponse insertPromotionTemplate(PromotionTemplateInsertRequest promotionTemplateInsertRequest) {
        PromotionTemplate promotionTemplate = promotionTemplateDAO.save(PromotionTemplateMapper.toPromotionTemplate(promotionTemplateInsertRequest));
        return PromotionTemplateMapper.toPromotionTemplateResponse(promotionTemplate);
    }

    @Override
    public Boolean isCodeExisted(String code) {
        return promotionTemplateDAO.existsByCode(code);
    }

    @Override
    public Double percentDiscountOfBook(Long bookTemplateId) {
        List<PromotionTemplate> promotionTemplates = promotionTemplateDAO.findAll();
        Double percentDiscount = 0.0;
        for (PromotionTemplate promotionTemplate : promotionTemplates) {
            BookTemplate book = bookTemplateDAO.findOneForDetails(bookTemplateId);
            Book singlebook = book.getBooks().iterator().next();

            if (promotionTemplate.getType() == EPromotionTemplateType.DISCOUNT) {
                for (Promotion promotion : promotionTemplate.getPromotions()) {
                    if (promotion.getStatus() == EPromotionStatus.NOT_USE &&
                            (promotion.getEffectiveDate().isBefore(LocalDateTime.now()) || promotion.getEffectiveDate().isEqual(LocalDateTime.now())) &&
                            (promotion.getExpirationDate().isAfter(LocalDateTime.now()) || promotion.getExpirationDate().isEqual(LocalDateTime.now()))) {
                        for (PromotionTarget promotionTarget : promotion.getPromotionTargets()) {
                            switch (promotionTarget.getType()) {
                                case SUBCATEGORY:
                                    if (Objects.equals(singlebook.getSubCategory().getId(), promotionTarget.getApplicableObjectId())) {
                                        percentDiscount = Math.max(percentDiscount, promotion.getPercentDiscount());
                                    }
                                    break;
                                case CATEGORY:
                                    if (Objects.equals(singlebook.getSubCategory().getCategory().getId(), promotionTarget.getApplicableObjectId())) {
                                        percentDiscount = Math.max(percentDiscount, promotion.getPercentDiscount());
                                    }
                                    break;
                                case BOOK:
                                    if (Objects.equals(bookTemplateId, promotionTarget.getApplicableObjectId())) {
                                        percentDiscount = Math.max(percentDiscount, promotion.getPercentDiscount());
                                    }
                                    break;

                                    default:
                                        percentDiscount = Math.max(percentDiscount, promotion.getPercentDiscount());
                                        break;
                            }
                        }
                    }
                }
            }
        }
        return percentDiscount;
    }

    @Override
    public ApplyCodePromotionResponse applyCodePromotion(String code, Double amount, EPromotionTemplateType type) {
        ApplyCodePromotionResponse applyCodePromotionResponse = new ApplyCodePromotionResponse();
        PromotionTemplate promotionTemplateNonUpdate = promotionTemplateDAO.findSingleByJPQL(code);


        if (promotionTemplateNonUpdate == null || promotionTemplateNonUpdate.getType() != type) {
            applyCodePromotionResponse.setMessage("Mã khuyến mãi không tồn tại!");
        }
        else {
            List<Promotion> promotions = promotionDAO.findAllById(promotionTemplateNonUpdate.getId());
            updatePromotionTemplateStatus(promotionTemplateNonUpdate, promotions);

            PromotionTemplate promotionTemplate = promotionTemplateDAO.findSingleByJPQL(code);

            if (promotionTemplate.getStatus() == EPromotionTemplateStatus.COMING_SOON) {
                applyCodePromotionResponse.setMessage("Chương trình khuyến mãi chưa diễn ra!");
            } else if (promotionTemplate.getStatus() == EPromotionTemplateStatus.EXPIRED) {
                applyCodePromotionResponse.setMessage("Mã khuyến mãi đã hết hạn");
            } else if (promotionTemplate.getStatus() == EPromotionTemplateStatus.USED_OUT) {
                applyCodePromotionResponse.setMessage("Mã khuyến mãi đã hết lượt sử dụng!");
            } else {
                for (Promotion promotion : promotionTemplate.getPromotions()) {

                    if (amount < promotion.getMinValueToBeApplied()) {
                        applyCodePromotionResponse.setMessage("Hóa đơn không đạt yêu cầu!");
                        break;
                    }

                    if (promotion.getStatus() == EPromotionStatus.NOT_USE) {
                        applyCodePromotionResponse.setPromotionId(promotion.getId());
                        applyCodePromotionResponse.setPromotionCode(promotion.getPromotionTemplate().getCode());
                        applyCodePromotionResponse.setMinValueToBeApplied(promotion.getMinValueToBeApplied());
                        applyCodePromotionResponse.setDiscountLimit(promotion.getDiscountLimit());
                        applyCodePromotionResponse.setType(promotionTemplate.getType());
                        applyCodePromotionResponse.setMessage("Áp dụng mã khuyến mãi thành công!");

                        Promotion promotionUpdate = promotionDAO.findById(promotion.getId());
                        if (!promotionTemplate.isInfinite()) {
                            promotionUpdate.setStatus(EPromotionStatus.USED);
                        } else {
                            promotionUpdate.setStatus(EPromotionStatus.NOT_USE);
                        }
                        promotionDAO.update(promotionUpdate);
                        break;
                    }
                }
            }
        }
        return applyCodePromotionResponse;
    }

    @Override
    public Boolean stopPromotionByCode(String code) {
        PromotionTemplate promotionTemplate = promotionTemplateDAO.findSingleByJPQL(code);
        for (Promotion promotion : promotionTemplate.getPromotions()) {
            promotion.setStatus(EPromotionStatus.USED);
            String currentDateTime = LocalDateTime.now().toString();
            promotion.setExpirationDate(LocalDateTime.parse(currentDateTime));
        }

        promotionTemplate.setStatus(EPromotionTemplateStatus.EXPIRED);
        return promotionTemplateDAO.update(promotionTemplate) != null;
    }



    private void updatePromotionTemplateStatus(PromotionTemplate promotionTemplate, List<Promotion> promotions) {
        long countUsed = promotions.stream()
                .filter(promotion -> promotion.getStatus() == EPromotionStatus.USED)
                .count();

        if (!promotionTemplate.isInfinite() && promotions.size() == countUsed) {
            promotionTemplate.setStatus(EPromotionTemplateStatus.USED_OUT);
        } else {
            promotions.stream()
                    .filter(promotion -> promotion.getStatus() == EPromotionStatus.NOT_USE)
                    .findFirst()
                    .ifPresent(promotion -> {
                        if (!promotion.getEffectiveDate().isAfter(LocalDateTime.now()) &&
                                !promotion.getExpirationDate().isBefore(LocalDateTime.now())) {
                            promotionTemplate.setStatus(EPromotionTemplateStatus.EFFECTIVE);
                        } else if (!promotion.getExpirationDate().isAfter(LocalDateTime.now())) {
                            promotionTemplate.setStatus(EPromotionTemplateStatus.EXPIRED);
                        }
                    });
        }
        promotionTemplateDAO.update(promotionTemplate);
    }

}
