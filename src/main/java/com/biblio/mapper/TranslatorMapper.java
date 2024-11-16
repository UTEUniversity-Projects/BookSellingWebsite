package com.biblio.mapper;

import com.biblio.dto.request.TranslatorRequest;
import com.biblio.dto.response.TranslatorResponse;
import com.biblio.entity.Translator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TranslatorMapper {
    public static Translator toTranslatorEntity(TranslatorRequest translatorRequest) {
        return Translator.builder()
                .id(Long.parseLong(translatorRequest.getId()))
                .name(translatorRequest.getName())
                .avatar(translatorRequest.getAvatar())
                .introduction(translatorRequest.getIntroduction())
                .joinAt(LocalDateTime.parse(translatorRequest.getJoinAt()))
                .build();
    }

    public static TranslatorResponse toTranslatorResponse(Translator translator) {
        return TranslatorResponse.builder()
                .id(translator.getId().toString())
                .name(translator.getName())
                .avatar(translator.getAvatar())
                .introduction(translator.getIntroduction())
                .joinAt(translator.getJoinAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();
    }
}
