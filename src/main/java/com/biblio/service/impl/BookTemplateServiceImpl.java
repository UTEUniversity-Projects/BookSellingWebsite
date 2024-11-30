package com.biblio.service.impl;

import com.biblio.dao.IBookTemplateDAO;

import com.biblio.dto.request.CheckoutItemRequest;
import com.biblio.dto.request.SearchBookRequest;
import com.biblio.dto.response.*;

import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.mapper.BookTemplateMapper;
import com.biblio.service.IBookTemplateService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookTemplateServiceImpl implements IBookTemplateService {

    @Inject
    IBookTemplateDAO bookTemplateDAO;

    @Override
    public List<BookManagementResponse> getAllBookManagementResponse() {
        List<BookTemplate> bookTemplates = bookTemplateDAO.findAllForManagement();
        List<BookManagementResponse> bookManagementResponseList = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookManagementResponseList.add(BookTemplateMapper.toBookManagementResponse(bookTemplate));
        }
        return bookManagementResponseList;
    }

    @Override
    public List<BookCardResponse> getAllBookCardResponse() {
        List<BookTemplate> bookTemplates = bookTemplateDAO.findAllForHome();
        List<BookCardResponse> bookCardResponseList = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookCardResponseList.add(BookTemplateMapper.toBookCardResponse(bookTemplate));
        }
        return bookCardResponseList;
    }

    @Override
    public BookDetailsResponse getBookDetailsResponse(Long bookTemplateId) {
        BookTemplate bookTemplate = bookTemplateDAO.findOneForDetails(bookTemplateId);
        return BookTemplateMapper.toBookDetailsResponse(bookTemplate);
    }

    @Override
    public List<BookTemplatePromotionResponse> getAllBookBookTemplatePromotionResponse() {
        List<BookTemplate> bookTemplates = bookTemplateDAO.findAll();
        List<BookTemplatePromotionResponse> bookTemplatePromotionResponse = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookTemplatePromotionResponse.add(BookTemplateMapper.toBookTemplatePromotionResponse(bookTemplate));
        }
        return bookTemplatePromotionResponse;
    }

    @Override
    public List<BookCardResponse> getBookTemplateByCriteria(SearchBookRequest request) {

        List<BookTemplate> bookTemplates = bookTemplateDAO.findByCriteria(request);
        List<BookCardResponse> bookCardResponseList = new ArrayList<>();
        for (BookTemplate bt : bookTemplates) {
            bookCardResponseList.add(BookTemplateMapper.toBookCardResponse(bt));
        }
        return bookCardResponseList;

    }
    @Override
    public List<BookSoldAllTimeResponse> getListCountBookSoldAllTime() {
        List<BookSoldAllTimeResponse> listBookSold = new ArrayList<>();
        List<BookTemplate> bookTemplateList = bookTemplateDAO.findAllForHome();
        for (BookTemplate bookTemplate : bookTemplateList) {
            BookTemplate book = bookTemplateDAO.findOneForDetails(bookTemplate.getId());
            listBookSold.add(BookTemplateMapper.toBookSoldAllTimeResponse(book));
        }

        listBookSold.sort(Comparator.comparingLong(BookSoldAllTimeResponse::getCountSold).reversed());
        return listBookSold;
    }

    @Override
    public Long getTotalBookTemplateQuantity() {
        return bookTemplateDAO.countAll();
    }

    @Override
    public CheckoutItemResponse getCheckoutItemResponse(CheckoutItemRequest request) {
        BookTemplate bookTemplate = bookTemplateDAO.findOneForDetails(request.getProductId());
        Book book = bookTemplate.getBooks().iterator().next();
        return CheckoutItemResponse.builder()
                .bookTemplateId(bookTemplate.getId())
                .title(book.getTitle())
                .imagePath(bookTemplate.getMediaFiles().get(0).getStoredCode())
                .quantity(request.getQuantity())
                .sellingPrice(book.getSellingPrice())
                .build();
    }

    @Override
    public Long getBookTemplateQuantityByCriteria(SearchBookRequest request) {
        return bookTemplateDAO.countByCriteria(request);
    }

}
