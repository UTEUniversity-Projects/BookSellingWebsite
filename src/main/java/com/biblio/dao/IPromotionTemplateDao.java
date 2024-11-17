package com.biblio.dao;

import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTemplate;

import java.util.List;


public interface IPromotionTemplateDao extends IGenericDAO<PromotionTemplate>  {
    PromotionTemplate findById(Long id);
    List<PromotionTemplate> findByJPQL();
    PromotionTemplate findSingleByJPQL(String code);
    boolean existsByCode(String code);
    PromotionTemplate save(PromotionTemplate promotionTemplate);
    PromotionTemplate update(PromotionTemplate promotionTemplate);
}
