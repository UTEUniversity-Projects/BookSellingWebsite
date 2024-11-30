package com.biblio.service;

import com.biblio.dto.request.CheckoutItemRequest;
import com.biblio.dto.request.SearchBookRequest;
import com.biblio.dto.response.*;
import com.biblio.enumeration.EBookTemplateStatus;

import java.util.List;

public interface IBookTemplateService {

    List<BookManagementResponse> getAllBookManagementResponse();

    List<BookCardResponse> getAllBookCardResponse();

    List<BookCardResponse> getPopularBookCard();

    BookDetailsResponse getBookDetailsResponse(Long bookTemplateId);

    List<BookTemplatePromotionResponse> getAllBookBookTemplatePromotionResponse();

    List<BookCardResponse> getBookTemplateByCriteria(SearchBookRequest request);

    Long getBookTemplateQuantityByCriteria(SearchBookRequest request);
  
    List<BookSoldAllTimeResponse> getListCountBookSoldAllTime();

    Long getTotalBookTemplateQuantity();

    CheckoutItemResponse getCheckoutItemResponse(CheckoutItemRequest request);

    boolean verifyBookTemplateQuantity(Long bookTemplateId);

}
