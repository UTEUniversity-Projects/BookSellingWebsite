package com.biblio.service.impl;

import com.biblio.dao.IAuthorDAO;
import com.biblio.dto.request.AuthorRequest;
import com.biblio.dto.response.AuthorResponse;
import com.biblio.entity.Author;
import com.biblio.mapper.AuthorMapper;
import com.biblio.service.IAuthorService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements IAuthorService {
    @Inject
    IAuthorDAO authorDAO;

    @Override
    public List<AuthorResponse> findAll() {
        List<AuthorResponse> list = new ArrayList<AuthorResponse>();
        for (Author author : authorDAO.findAll()) {
            list.add(AuthorMapper.toAuthorResponse(author));
        }
        return list;
    }

    @Override
    public AuthorResponse findById(Long id) {
        Author author = authorDAO.findById(id);
        return AuthorMapper.toAuthorResponse(author);
    }

    @Override
    public void addAuthor(AuthorRequest authorRequest) {
        Author author = AuthorMapper.toAuthorEntity(authorRequest);
        authorDAO.addAuthor(author);
    }

    @Override
    public void updateAuthor(AuthorRequest authorRequest) {
        Author author = AuthorMapper.toAuthorEntity(authorRequest);
        authorDAO.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorDAO.deleteAuthor(id);
    }
}
