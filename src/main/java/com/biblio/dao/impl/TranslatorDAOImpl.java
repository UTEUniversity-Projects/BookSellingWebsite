package com.biblio.dao.impl;

import com.biblio.dao.ITranslatorDAO;
import com.biblio.entity.Translator;

import java.util.List;

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
