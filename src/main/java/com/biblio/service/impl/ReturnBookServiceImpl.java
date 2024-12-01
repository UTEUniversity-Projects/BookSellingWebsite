package com.biblio.service.impl;

import com.biblio.dao.IReturnBookDAO;
import com.biblio.dto.request.ReturnBookRequest;
import com.biblio.dto.request.ReturnOrderRequest;
import com.biblio.dto.response.ReturnBookManagementResponse;
import com.biblio.entity.Book;
import com.biblio.entity.ReturnBook;
import com.biblio.entity.ReturnBookItem;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EReasonReturn;
import com.biblio.mapper.ReturnBookMapper;
import com.biblio.service.IBookTemplateService;
import com.biblio.service.IReturnBookService;


import javax.inject.Inject;

public class ReturnBookServiceImpl implements IReturnBookService {

    @Inject
    IReturnBookDAO returnBookDAO;

    @Inject
    IBookTemplateService bookTemplateService;

    @Override
    public ReturnBookManagementResponse findReturnBookByOrderId(Long orderId) {
        ReturnBook returnBook = returnBookDAO.findByOrderId(orderId);
        return ReturnBookMapper.toReturnBookManagementResponse(returnBook);
    }

    @Override
    public void save(ReturnBookRequest request) {
        ReturnBook returnBook = ReturnBookMapper.toEntity(request);
        returnBookDAO.save(returnBook);
    }

    @Override
    public boolean update(Long returnBookId) {
        ReturnBook returnBook = returnBookDAO.findById(returnBookId);
        if (returnBook == null) {
            return false;
        }
        EBookMetadataStatus newStatus = (returnBook.getReason() != EReasonReturn.NO_NEEDED)
                ? EBookMetadataStatus.BROKEN
                : EBookMetadataStatus.IN_STOCK;

        for (ReturnBookItem returnBookItem : returnBook.getReturnBookItems()) {
            for (Book book : returnBookItem.getBooks()) {
                book.getBookMetadata().setStatus(newStatus);
            }
            Book book = returnBookItem.getBooks().iterator().next();
            boolean success = bookTemplateService.verifyBookTemplateQuantity(book.getBookTemplate().getId());
            if (!success) {
                return false;
            }
        }
        return returnBookDAO.update(returnBook) != null;
    }
}