package com.biblio.dao;

import com.biblio.entity.Promotion;

import java.util.List;

public interface IPromotionDAO extends IGenericDAO<Promotion>  {
    List<Promotion> findAll();
}
