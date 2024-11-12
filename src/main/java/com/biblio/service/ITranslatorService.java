package com.biblio.service;

import com.biblio.dto.request.TranslatorRequest;
import com.biblio.dto.response.TranslatorResponse;

import java.util.List;

public interface ITranslatorService {
    List<TranslatorResponse> findAll();
    TranslatorResponse findById(Long id);
    void addTranslator(TranslatorRequest translatorRequest);
    void updateTranslator(TranslatorRequest translatorRequest);
    void deleteTranslator(Long id);
}
