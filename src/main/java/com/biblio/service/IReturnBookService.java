package com.biblio.service;

import com.biblio.dto.request.ReturnBookRequest;
import com.biblio.dto.request.ReturnOrderRequest;
import com.biblio.dto.response.ReturnBookManagementResponse;
import com.biblio.entity.ReturnBook;

public interface IReturnBookService {
  
    ReturnBookManagementResponse findReturnBookByOrderId(Long orderId);

    void save(ReturnBookRequest request);

    boolean update(Long returnBookId);
  
}
