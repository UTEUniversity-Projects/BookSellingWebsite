package com.biblio.service.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.dto.response.BookDetailsManagementResponse;
import com.biblio.dto.response.BookManagementResponse;
import com.biblio.entity.BookTemplate;
import com.biblio.mapper.BookTemplateMapper;
import com.biblio.service.IBookService;
import com.biblio.service.IBookTemplateService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BookTemplateServiceImpl implements IBookTemplateService {
    @Inject
    IBookTemplateDAO bokTemplateDAO;

    @Override
    public BookDetailsManagementResponse getBookDetailsManagementResponse(Long bookTemplateId) {
        BookTemplate bookTemplate = bokTemplateDAO.findById(bookTemplateId);
        BookDetailsManagementResponse bookDetailsManagementResponse = BookTemplateMapper.toBookDetailsManagementResponse(bookTemplate);
        return bookDetailsManagementResponse;
    }

    @Override
    public List<BookManagementResponse> getAllBookManagementResponse() {
        List<BookTemplate> bookTemplates = bokTemplateDAO.findAll();
        List<BookManagementResponse> bookManagementResponseList = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookManagementResponseList.add(BookTemplateMapper.toBookManagementResponse(bookTemplate));
        }
        return bookManagementResponseList;
    }
}
