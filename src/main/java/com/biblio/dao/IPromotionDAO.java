package com.biblio.dao;

import com.biblio.entity.Promotion;
import com.biblio.enumeration.EPromotionStatus;

import java.util.List;

public interface IPromotionDAO extends IGenericDAO<Promotion> {

    List<Promotion> findAll();

    List<Promotion> findAllByIdAndStatus(Long id, EPromotionStatus status);

    Promotion findById(Long id);

    void insert(Promotion promotion);

    void updatePromotion(Promotion promotion);

    Promotion findLastPromotion();

    boolean existsByCode(String code);

}
