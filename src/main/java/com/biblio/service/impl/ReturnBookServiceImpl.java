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
import com.biblio.service.IReturnBookService;


import javax.inject.Inject;

public class ReturnBookServiceImpl implements IReturnBookService {

    @Inject
    IReturnBookDAO returnBookDAO;

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
        if (returnBook.getReason() != EReasonReturn.NO_NEEDED) {
            for (ReturnBookItem returnBookItem : returnBook.getReturnBookItems()) {
                for (Book book : returnBookItem.getBooks()) {
                    book.getBookMetadata().setStatus(EBookMetadataStatus.BROKEN);
                }
            }
        }
        return returnBookDAO.update(returnBook) != null;
    }
}