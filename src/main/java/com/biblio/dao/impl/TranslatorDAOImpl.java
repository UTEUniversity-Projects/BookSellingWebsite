package com.biblio.dao.impl;

import com.biblio.dao.ITranslatorDAO;
import com.biblio.entity.Author;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.Translator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslatorDAOImpl extends GenericDAOImpl<Translator> implements ITranslatorDAO {

    public TranslatorDAOImpl() {
        super(Translator.class);
    }

    @Override
    public List<Translator> findAll() {
        return super.findAll();
    }

    @Override
    public Translator findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Translator> findByBookTemplate(BookTemplate bookTemplate) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT DISTINCT t ")
                .append("FROM Translator t ")
                .append("JOIN t.bookTemplates bt ")
                .append("WHERE bt = :bookTemplate");

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplate", bookTemplate);
        return super.findByJPQL(jpql.toString(), params);
    }

    @Override
    public void addTranslator(Translator translator) {
        super.save(translator);
    }

    @Override
    public void updateTranslator(Translator translator) {
        super.update(translator);
    }

    @Override
    public void deleteTranslator(Long id) {
        super.delete(id);
    }

}
