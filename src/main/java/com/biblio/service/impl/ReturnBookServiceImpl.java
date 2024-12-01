package com.biblio.service.impl;

import com.biblio.dao.IBookDAO;
import com.biblio.dao.IOrderDAO;
import com.biblio.dao.IReturnBookDAO;
import com.biblio.dao.IReturnBookItemDAO;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.Timestamp; // Import thêm nếu chưa có


public class ReturnBookServiceImpl implements IReturnBookService {

    @Inject
    IReturnBookDAO returnBookDAO;

    @Inject
    IReturnBookItemDAO returnBookItemDAO;

    @Inject
    IBookDAO bookDAO;

    @Inject
    IOrderDAO orderDAO;
  
    @Inject
    IBookTemplateService bookTemplateService;

    @Override
    public ReturnBookManagementResponse findReturnBookByOrderId(Long orderId) {
        ReturnBook returnBook = returnBookDAO.findByOrderId(orderId);
        return ReturnBookMapper.toReturnBookManagementResponse(returnBook);
    }

    @Override
    public void save(ReturnOrderRequest request) {
        ReturnBook returnBook = ReturnBookMapper.toEntity(request);
        returnBook.setCreatedAt(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
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

    @Override
    public void saveReturnOrder(ReturnOrderRequest returnOrderRequest, List<ReturnBookRequest> returnBookRequests) {
        // Tạo đối tượng ReturnBook từ yêu cầu ReturnOrderRequest
        ReturnBook returnBook = ReturnBookMapper.toEntity(returnOrderRequest);

        // Lưu ReturnBook vào cơ sở dữ liệu
        returnBookDAO.save(returnBook);

        // Lưu các ReturnBookItems
        for (ReturnBookRequest returnBookRequestItem : returnBookRequests) {
            // Tạo đối tượng ReturnBookItem từ ReturnBookRequest
            ReturnBookItem returnBookItem = new ReturnBookItem();

            Long idTemplate = returnBookRequestItem.getIdTemplate();

            // Truy vấn các sách từ database theo bookTemplateId
            List<Book> books = bookDAO.findBooksByTemplateId(idTemplate);

            // Lọc ra số lượng sách theo yêu cầu
            Set<Book> booksToReturn = new HashSet<>();
            for (int i = 0; i < returnBookRequestItem.getReturnQuantity(); i++) {
                if (i < books.size()) {
                    booksToReturn.add(books.get(i));
                }
            }

            // Gán các sách vào ReturnBookItem
            returnBookItem.setBooks(booksToReturn);

            // Gán ReturnBook vào ReturnBookItem
            returnBookItem.setReturnBook(returnBook);

            // Lưu ReturnBookItem vào cơ sở dữ liệu
            returnBookItemDAO.save(returnBookItem);
        }

    }

}