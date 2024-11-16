package com.biblio.service.impl;

import com.biblio.dao.IPromotionDAO;
import com.biblio.dao.IPromotionTemplateDao;
import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.request.PromotionTemplateInsertRequest;
import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.dto.response.PromotionTemplateGetResponse;
import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTemplate;
import com.biblio.enumeration.EPromotionStatus;
import com.biblio.mapper.PromotionMapper;
import com.biblio.mapper.PromotionTemplateMapper;
import com.biblio.service.IPromotionService;
import com.biblio.service.IPromotionTemplateService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
public class PromotionTemplateServiceImpl implements IPromotionTemplateService {
    @Inject
    IPromotionDAO promotionDAO;
    @Inject
    IPromotionTemplateDao promotionTemplateDAO;
    @Override
    public List<PromotionTemplateGetResponse> getAllPromotionTemplates() {
       List<PromotionTemplateGetResponse> list = new ArrayList<>();
       List<PromotionTemplate> promotionTemplates = promotionTemplateDAO.findByJPQL();

       for (PromotionTemplate promotionTemplate : promotionTemplates) {
           list.add(PromotionTemplateMapper.toPromotionTemplateGetResponse(promotionDAO.findAllByIdAndStatus(promotionTemplate.getId(), EPromotionStatus.NOT_USE)));
       }
       return list;
    }

    @Override
    public void insertPromotionTemplate(PromotionTemplateInsertRequest promotionTemplateInsertRequest) {
        PromotionTemplate promotionTemplate = promotionTemplateDAO.save(PromotionTemplateMapper.toPromotionTemplate(promotionTemplateInsertRequest));
    }

    @Override
    public Boolean isCodeExisted(String code) {
        return promotionTemplateDAO.existsByCode(code);
    }
}
