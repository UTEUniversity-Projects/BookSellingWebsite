package com.biblio.service;

import com.biblio.dto.request.SearchBookRequest;
import com.biblio.dto.response.*;

import java.util.List;

public interface IBookTemplateService {

    List<BookManagementResponse> getAllBookManagementResponse();

    List<BookCardResponse> getAllBookCardResponse();

    BookDetailsResponse getBookDetailsResponse(Long bookTemplateId);

    List<BookTemplatePromotionResponse> getAllBookBookTemplatePromotionResponse();

    List<BookCardResponse> getBookTemplateByCriteria(SearchBookRequest request);

    long getBookTemplateQuantityByCriteria(SearchBookRequest request);
  
    List<BookSoldAllTimeResponse> getListCountBookSoldAllTime();


}
