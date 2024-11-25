package com.biblio.service.impl;

import com.biblio.dao.IReturnBookDAO;
import com.biblio.dto.response.ReturnBookManagementResponse;
import com.biblio.entity.ReturnBook;
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
}
