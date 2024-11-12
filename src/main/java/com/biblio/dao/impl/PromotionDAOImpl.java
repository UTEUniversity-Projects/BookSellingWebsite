package com.biblio.dao.impl;

import com.biblio.dao.IPromotionDAO;
import com.biblio.entity.Promotion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionDAOImpl extends GenericDAOImpl<Promotion> implements IPromotionDAO {
    public PromotionDAOImpl() {
        super(Promotion.class);
    }
    @Override
    public List<Promotion> findAll() {
        return super.findAll();
    }
    public Promotion findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void insert(Promotion promotion) {
        System.out.println(promotion.getCode());
        super.save(promotion);
    }

    @Override
    public void updatePromotion(Promotion promotion) {
        super.update(promotion);
    }


    @Override
    public Promotion findLastPromotion() {
        String jpql = "SELECT p FROM Promotion p ORDER BY p.id DESC";
        Map<String, Object> params = new HashMap<>();
        return super.findSingleByJPQL(jpql, params);
    }
    @Override
    public boolean isCodeExist(String code) {
        String jpql = "SELECT p FROM Promotion p WHERE p.code = :code";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", code);
        return super.findSingleByJPQL(jpql, params) != null;
    }


    public static void main(String[] args) {
        PromotionDAOImpl dao = new PromotionDAOImpl();
//        Promotion promotion = dao.findLastPromotion();
//        System.out.println(promotion.getCode());
//        for (Promotion promotion : promotions) {
//            Set<PromotionTarget> promotionTargets = promotion.getPromotionTargets();
//            for (PromotionTarget promotionTarget : promotionTargets) {
//                System.out.println(promotionTarget.getApplicableObjectId());
//            }
//        }
        Boolean check = dao.isCodeExist("1");
        System.out.println(check);
    }
}
