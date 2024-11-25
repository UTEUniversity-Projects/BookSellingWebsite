package com.biblio.service;

import com.biblio.dto.response.ReturnBookManagementResponse;
import com.biblio.entity.ReturnBook;

public interface IReturnBookService {
  
    ReturnBookManagementResponse findReturnBookByOrderId(Long orderId);

    void save(ReturnBook returnBook);
}
