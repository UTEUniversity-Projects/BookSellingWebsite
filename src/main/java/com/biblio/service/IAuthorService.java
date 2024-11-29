package com.biblio.service;

import com.biblio.dto.request.AuthorCreateRequest;
import com.biblio.dto.request.AuthorDeleteRequest;
import com.biblio.dto.request.AuthorUpdateRequest;
import com.biblio.dto.response.AuthorAnalysisResponse;
import com.biblio.dto.response.AuthorLineResponse;
import com.biblio.dto.response.AuthorProfileResponse;

import java.util.List;

public interface IAuthorService {
    List<AuthorLineResponse> getAll();
    AuthorProfileResponse getProfileById(Long id);
    AuthorAnalysisResponse getAnalysisById(Long id);
    void createAuthor(AuthorCreateRequest authorRequest);
    void updateAuthor(AuthorUpdateRequest authorRequest);
    void deleteAuthor(AuthorDeleteRequest id);
    Integer countBookTemplate(AuthorDeleteRequest id);
}
