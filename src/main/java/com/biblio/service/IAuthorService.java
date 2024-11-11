package com.biblio.service;

import com.biblio.dto.request.AuthorRequest;
import com.biblio.dto.response.AuthorResponse;

import java.util.List;

public interface IAuthorService {
    List<AuthorResponse> findAll();
    AuthorResponse findById(Long id);
    void addAuthor(AuthorRequest authorRequest);
    void updateAuthor(AuthorRequest authorRequest);
    void deleteAuthor(Long id);
}
