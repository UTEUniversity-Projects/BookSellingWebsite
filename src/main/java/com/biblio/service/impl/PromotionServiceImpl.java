package com.biblio.service.impl;

import com.biblio.dao.IPromotionDAO;
import com.biblio.dto.request.PromotionInsertRequest;
import com.biblio.dto.response.PromotionGetResponse;
import com.biblio.entity.Promotion;
import com.biblio.mapper.PromotionMapper;
import com.biblio.service.IPromotionService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class PromotionServiceImpl implements IPromotionService {
    @Inject
    IPromotionDAO promotionDAO;
    @Override
    public List<PromotionGetResponse> findAll() {
        List<PromotionGetResponse> list = new ArrayList<PromotionGetResponse>();
        for (Promotion promotion : promotionDAO.findAll()) {
            list.add(PromotionMapper.toPromotionGetResponse(promotion));
        }
        return list;
    }

    @Override
    public PromotionGetResponse findById(Long id) {
        PromotionGetResponse promotion = PromotionMapper.toPromotionGetResponse(promotionDAO.findById(id));
        return promotion;
    }

    @Override
    public void insert(PromotionInsertRequest promotionInsertRequest) {
        Promotion promotion = PromotionMapper.toPromotion(promotionInsertRequest);
        promotionDAO.insert(promotion);
    }
}
