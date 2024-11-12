package com.biblio.dao;

import com.biblio.entity.Promotion;

import java.util.List;

public interface IPromotionDAO extends IGenericDAO<Promotion>  {
    List<Promotion> findAll();
    Promotion findById(Long id);
    void insert(Promotion promotion);
    void updatePromotion(Promotion promotion);
    Promotion findLastPromotion();
    boolean existsByCode(String code);
}
