package com.biblio.dao.impl;

import com.biblio.dao.IPromotionDAO;
import com.biblio.entity.Promotion;
import com.biblio.entity.PromotionTarget;

import java.util.List;
import java.util.Set;

public class PromotionDAOImpl extends GenericDAOImpl<Promotion> implements IPromotionDAO {
    public PromotionDAOImpl() {
        super(Promotion.class);
    }
    @Override
    public List<Promotion> findAll() {
        return super.findAll();
    }
    public static void main(String[] args) {
        PromotionDAOImpl dao = new PromotionDAOImpl();
        List<Promotion> promotions = dao.findAll();

        for (Promotion promotion : promotions) {
            Set<PromotionTarget> promotionTargets = promotion.getPromotionTargets();
            for (PromotionTarget promotionTarget : promotionTargets) {
                System.out.println(promotionTarget.getApplicableObjectId());
            }
        }
    }
}
