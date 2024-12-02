package com.biblio.service;

import com.biblio.dto.request.TranslatorCreateRequest;
import com.biblio.dto.request.TranslatorDeleteRequest;
import com.biblio.dto.request.TranslatorUpdateRequest;
import com.biblio.dto.response.TranslatorAnalysisResponse;
import com.biblio.dto.response.TranslatorLineResponse;
import com.biblio.dto.response.TranslatorProfileResponse;
import com.biblio.entity.Translator;

import java.util.List;

public interface ITranslatorService {
    List<TranslatorLineResponse> getAll();
    TranslatorProfileResponse getProfileById(Long id);
    TranslatorAnalysisResponse getAnalysisById(Long id);
    Translator create(TranslatorCreateRequest translatorRequest);
    void update(TranslatorUpdateRequest translatorRequest);
    void delete(TranslatorDeleteRequest translatorDeleteRequest);
    Integer countBookTemplate(TranslatorDeleteRequest id);
}
