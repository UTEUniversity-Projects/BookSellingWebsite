package com.biblio.service;

import com.biblio.dto.response.ReturnBookManagementResponse;

public interface IReturnBookService {
    ReturnBookManagementResponse findReturnBookByOrderId(Long orderId);
}
