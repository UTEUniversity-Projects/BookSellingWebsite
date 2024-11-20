package com.biblio.dao;

import com.biblio.entity.BookTemplate;
import com.biblio.entity.Translator;

import java.util.List;

public interface ITranslatorDAO {

    List<Translator> findAll();

    Translator findById(Long id);

    public List<Translator> findByBookTemplate(BookTemplate bookTemplate);

    void addTranslator(Translator translator);

    void updateTranslator(Translator translator);

    void deleteTranslator(Long id);

}
