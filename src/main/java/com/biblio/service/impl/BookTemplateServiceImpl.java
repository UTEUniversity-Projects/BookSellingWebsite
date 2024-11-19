package com.biblio.service.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.dto.response.BookCardResponse;
import com.biblio.dto.response.BookDetailsResponse;
import com.biblio.dto.response.BookManagementResponse;
import com.biblio.dto.response.BookTemplatePromotionResponse;
import com.biblio.entity.BookTemplate;
import com.biblio.mapper.BookTemplateMapper;
import com.biblio.service.IBookTemplateService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BookTemplateServiceImpl implements IBookTemplateService {
    @Inject
    IBookTemplateDAO bokTemplateDAO;

    @Override
    public List<BookManagementResponse> getAllBookManagementResponse() {
        List<BookTemplate> bookTemplates = bokTemplateDAO.findAllForManagement();
        List<BookManagementResponse> bookManagementResponseList = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookManagementResponseList.add(BookTemplateMapper.toBookManagementResponse(bookTemplate));
        }
        return bookManagementResponseList;
    }

    @Override
    public List<BookCardResponse> getAllBookCardResponse() {
        List<BookTemplate> bookTemplates = bokTemplateDAO.findAll();
        List<BookCardResponse> bookCardResponseList = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookCardResponseList.add(BookTemplateMapper.toBookCardResponse(bookTemplate));
        }
        return bookCardResponseList;
    }

    @Override
    public BookDetailsResponse getBookDetailsResponse(Long bookTemplateId) {
        BookTemplate bookTemplate = bokTemplateDAO.findOneForDetails(bookTemplateId);
        return BookTemplateMapper.toBookDetailsResponse(bookTemplate);
    }

    @Override
    public List<BookTemplatePromotionResponse> getAllBookBookTemplatePromotionResponse() {
        List<BookTemplate> bookTemplates = bokTemplateDAO.findAll();
        List<BookTemplatePromotionResponse> bookTemplatePromotionResponse = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookTemplatePromotionResponse.add(BookTemplateMapper.toBookTemplatePromotionResponse(bookTemplate));
        }
        return bookTemplatePromotionResponse;
    }
}
