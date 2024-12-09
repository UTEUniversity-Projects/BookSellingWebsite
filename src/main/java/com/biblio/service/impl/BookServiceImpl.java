package com.biblio.service.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.dao.IBookTemplateDAO;
import com.biblio.dao.IOrderDAO;
import com.biblio.dao.ISubCategoryDAO;
import com.biblio.dto.request.BookCreateGlobalRequest;
import com.biblio.dto.request.BookRequest;
import com.biblio.dto.request.BookUpdateGlobalRequest;
import com.biblio.dto.response.BookResponse;
import com.biblio.entity.Book;
import com.biblio.entity.BookMetadata;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.SubCategory;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.mapper.BookMapper;
import com.biblio.service.IBookMetadataService;
import com.biblio.service.IBookService;
import com.biblio.service.IBookTemplateService;
import com.biblio.service.ISubCategoryService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

public class BookServiceImpl implements IBookService {
    @Inject
    private IBookDAO bookDAO;

    @Inject
    private IBookTemplateDAO bookTemplateDAO;

    @Inject
    private IOrderDAO orderDAO;

    @Inject
    private ISubCategoryService subCategoryService;

    @Inject
    private IBookTemplateService bookTemplateService;

    @Inject
    private IBookMetadataService bookMetadataService;

    @Override
    public List<BookResponse> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public BookTemplate createBookSeries(BookCreateGlobalRequest bookCreateRequest) {
        BookTemplate bookTemplate = bookTemplateService.createBookTemplate(bookCreateRequest);

        long quantity = Long.parseLong(bookCreateRequest.getQuantity());
        SubCategory subCategory = subCategoryService.getEntityById(Long.valueOf(bookCreateRequest.getSubCategoryId()));

        for (int i = 0; i < quantity; i++) {
            BookMetadata bookMetadata = bookMetadataService.createBookMetadata(bookCreateRequest);
            bookDAO.createBook(BookMapper.toBookEntityCreate(bookCreateRequest,
                    bookTemplate, subCategory, bookMetadata));
        }

        return bookTemplate;
    }

    @Override
    @Transactional
    public BookTemplate updateBookSeries(BookUpdateGlobalRequest bookUpdateRequest) {
        BookTemplate oldBookTemplate = bookTemplateDAO.findOneForDetails(Long.valueOf(bookUpdateRequest.getId()));
        BookTemplate newBookTemplate = bookTemplateService.updateBookTemplate(bookUpdateRequest);
        SubCategory subCategory = subCategoryService.getEntityById(Long.valueOf(bookUpdateRequest.getSubCategoryId()));

        int oldQuantity = Math.toIntExact(bookTemplateDAO.countInstockById(oldBookTemplate.getId()));
        int newQuantity = (int) Long.parseLong(bookUpdateRequest.getQuantity());

        List<Book> books = oldBookTemplate.getBooks().stream()
                .filter(book -> book.getBookMetadata().getStatus() == EBookMetadataStatus.IN_STOCK).toList();

        if (oldQuantity < newQuantity) {
            for (Book book : books) {
                BookMetadata bookMetadata = book.getBookMetadata();
                bookDAO.updateBook(BookMapper.toBookEntityUpdate(bookUpdateRequest,
                        newBookTemplate, subCategory, bookMetadata, book));
            }

            long quantity = newQuantity - oldQuantity;

            for (int i = 0; i < quantity; i++) {
                BookMetadata bookMetadata = bookMetadataService.createBookMetadata(bookUpdateRequest);
                bookDAO.createBook(BookMapper.toBookEntity(bookUpdateRequest,
                        newBookTemplate, subCategory, bookMetadata));
            }
        } else {
            for (int i = 0; i < newQuantity; i++) {
                BookMetadata bookMetadata = books.get(i).getBookMetadata();
                bookDAO.updateBook(BookMapper.toBookEntityUpdate(bookUpdateRequest,
                        newBookTemplate, subCategory, bookMetadata, books.get(i)));
            }

            for (int i = newQuantity; i < oldQuantity; i++) {
                bookMetadataService.deleteBookMetadata(books.get(i).getBookMetadata().getId());
                bookDAO.deleteBook(books.get(i).getId());
            }
        }

        return newBookTemplate;
    }

    @Override
    public Long getMinBookPrice() {
        return bookDAO.findMinBookPrice();
    }

    @Override
    public Long getMaxBookPrice() {
        return bookDAO.findMaxBookPrice();
    }

}
