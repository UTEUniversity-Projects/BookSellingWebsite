package com.biblio.service.impl;

import com.biblio.dao.ITranslatorDAO;
import com.biblio.dto.request.TranslatorRequest;
import com.biblio.dto.response.TranslatorResponse;
import com.biblio.entity.Translator;
import com.biblio.mapper.TranslatorMapper;
import com.biblio.service.ITranslatorService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TranslatorServiceImpl implements ITranslatorService {
    @Inject
    ITranslatorDAO translatorDAO;

    @Override
    public List<TranslatorResponse> findAll() {
        List<TranslatorResponse> list = new ArrayList<>();
        for (Translator translator : translatorDAO.findAll()) {
            list.add(TranslatorMapper.toTranslatorResponse(translator));
        }
        return list;
    }

    @Override
    public TranslatorResponse findById(Long id) {
        return TranslatorMapper.toTranslatorResponse(translatorDAO.findById(id));
    }

    @Override
    public void addTranslator(TranslatorRequest translatorRequest) {
        translatorDAO.addTranslator(TranslatorMapper.toTranslatorEntity(translatorRequest));
    }

    @Override
    public void updateTranslator(TranslatorRequest translatorRequest) {
        translatorDAO.updateTranslator(TranslatorMapper.toTranslatorEntity(translatorRequest));
    }

    @Override
    public void deleteTranslator(Long id) {
        translatorDAO.deleteTranslator(id);
    }
}
