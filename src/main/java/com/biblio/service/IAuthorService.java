package com.biblio.service;

import com.biblio.dto.request.AuthorRequest;
import com.biblio.dto.response.AuthorAnalysisResponse;
import com.biblio.dto.response.AuthorLineResponse;
import com.biblio.dto.response.AuthorProfileResponse;

import java.util.List;

public interface IAuthorService {
    List<AuthorLineResponse> findAll();
    AuthorProfileResponse findProfileById(Long id);
    AuthorAnalysisResponse findAnalysisById(Long id);
    void createAuthor(AuthorRequest authorRequest);
    void updateAuthor(AuthorRequest authorRequest);
    void deleteAuthor(Long id);
}
