package com.biblio.dao.impl;

import com.biblio.dao.IPromotionTemplateDao;
import com.biblio.entity.PromotionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionTemplateDaoImpl extends GenericDAOImpl<PromotionTemplate> implements IPromotionTemplateDao {
    public PromotionTemplateDaoImpl() {
        super(PromotionTemplate.class);
    }

    @Override
    public PromotionTemplate findById(Long id) {
        return super.findById(id);
    }

    public List<PromotionTemplate> findByJPQL() {
        String jpql = "SELECT p FROM PromotionTemplate p ORDER BY p.createdAt DESC";
        Map<String, Object> params = new HashMap<>();
        return super.findByJPQL(jpql, params);
    }
    public PromotionTemplate findSingleByJPQL(String code) {
        String jpql = "SELECT p FROM PromotionTemplate p WHERE p.code = :code";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", code);
        return super.findSingleByJPQL(jpql, params);
    }
    public PromotionTemplate save(PromotionTemplate promotionTemplate) {
        return super.save(promotionTemplate);
    }
    public PromotionTemplate update(PromotionTemplate promotionTemplate) {
        return super.update(promotionTemplate);
    }
    public boolean existsByCode(String code) {
        String jpql = "SELECT p FROM PromotionTemplate p WHERE p.code = :code";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", code);
        return super.findSingleByJPQL(jpql, params) != null;
    }

    public static void main(String[] args) {
        PromotionTemplateDaoImpl dao = new PromotionTemplateDaoImpl();
//        List<PromotionTemplate> list = dao.findByJPQL();
//        for (PromotionTemplate p : list) {
//            System.out.println(p.getCode());
//        }
//        Boolean check = dao.existsByCode("VOUCHER_11");
//        System.out.println(check);
        PromotionTemplate promotionTemplate = dao.findSingleByJPQL("VOUCHER_7");
        System.out.println(promotionTemplate.getCreatedAt());
    }
}
