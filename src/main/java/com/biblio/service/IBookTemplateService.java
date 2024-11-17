package com.biblio.service;

import com.biblio.dto.response.BookCardResponse;
import com.biblio.dto.response.BookDetailsManagementResponse;
import com.biblio.dto.response.BookDetailsResponse;
import com.biblio.dto.response.BookManagementResponse;

import java.util.List;

public interface IBookTemplateService {
    public BookDetailsManagementResponse getBookDetailsManagementResponse(Long bookTemplateId);
    public List<BookManagementResponse> getAllBookManagementResponse();
    List<BookCardResponse> getAllBookCardResponse();
    BookDetailsResponse getBookDetailsResponse(Long bookTemplateId);
}
