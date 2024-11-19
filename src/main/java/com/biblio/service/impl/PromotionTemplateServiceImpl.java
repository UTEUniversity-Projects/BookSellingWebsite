package com.biblio.service.impl;

import com.biblio.dao.IPromotionDAO;
import com.biblio.dao.IPromotionTemplateDao;
import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.request.PromotionTemplateUpdateRequest;
import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.dto.response.PromotionTemplateGetDetailsResponse;
import com.biblio.dto.response.PromotionTemplateGetResponse;
import com.biblio.dto.response.PromotionTemplateResponse;
import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTemplate;
import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionTemplateStatus;
import com.biblio.mapper.PromotionMapper;
import com.biblio.mapper.PromotionTemplateMapper;
import com.biblio.service.IPromotionService;
import com.biblio.service.IPromotionTemplateService;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class PromotionTemplateServiceImpl implements IPromotionTemplateService {
    @Inject
    IPromotionDAO promotionDAO;
    @Inject
    IPromotionTemplateDao promotionTemplateDAO;

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
    public void insertPromotionTemplate(PromotionTemplateInsertRequest promotionTemplateInsertRequest) {
        PromotionTemplate promotionTemplate = promotionTemplateDAO.save(PromotionTemplateMapper.toPromotionTemplate(promotionTemplateInsertRequest));
    }

    @Override
    public Boolean isCodeExisted(String code) {
        return promotionTemplateDAO.existsByCode(code);
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
