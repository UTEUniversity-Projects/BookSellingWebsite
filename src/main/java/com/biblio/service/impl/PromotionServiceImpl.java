package com.biblio.service.impl;

import com.biblio.dao.IPromotionDAO;
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
}
