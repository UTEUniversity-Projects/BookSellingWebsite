package com.biblio.dao;

import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTemplate;

import java.util.List;


public interface IPromotionTemplateDao extends IGenericDAO<PromotionTemplate>  {
    List<PromotionTemplate> findByJPQL();
    boolean existsByCode(String code);
    PromotionTemplate save(PromotionTemplate promotionTemplate);
}
