package com.biblio.service.impl;

import com.biblio.dao.*;
import com.biblio.dto.request.MediaFileRequest;
import com.biblio.dto.request.ReturnBookRequest;
import com.biblio.dto.request.ReturnOrderRequest;
import com.biblio.dto.response.ReturnBookManagementResponse;
import com.biblio.entity.*;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EOrderHistory;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.enumeration.EReasonReturn;
import com.biblio.mapper.ReturnBookMapper;
import com.biblio.service.IBookTemplateService;
import com.biblio.service.IReturnBookService;


import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.sql.Timestamp; // Import thêm nếu chưa có
import java.util.stream.Collectors;


public class ReturnBookServiceImpl implements IReturnBookService {

    @Inject
    IReturnBookDAO returnBookDAO;

    @Inject
    IMediaFileDAO mediaFileDAO;

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
        EBookMetadataStatus newStatus = (returnBook.getReason() != EReasonReturn.NO_NEEDED) ? EBookMetadataStatus.BROKEN : EBookMetadataStatus.IN_STOCK;

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
    public boolean saveReturnOrder(ReturnOrderRequest returnOrderRequest) {
        ReturnBook returnBook = ReturnBookMapper.toEntity(returnOrderRequest);
        Order order = orderDAO.findOne(returnOrderRequest.getOrderId());

        List<MediaFile> mediaFiles = new ArrayList<>();
        for (MediaFileRequest mediaFileRequest : returnOrderRequest.getMediaFiles()) {
            mediaFiles.add(mediaFileDAO.save(MediaFile.builder()
                    .fileName(mediaFileRequest.getFileName())
                    .storedCode(mediaFileRequest.getStoredCode())
                    .build()));
        }

        returnBook.setProof(mediaFiles);

        OrderStatusHistory completedStatusHistory = order.getStatusHistory().stream()
                .filter(statusHistory -> statusHistory.getStatus() == EOrderHistory.COMPLETED)
                .findFirst()
                .orElse(null);

        if (completedStatusHistory == null) {
            return false;
        }

        LocalDateTime returnBookCreatedAt = returnBook.getCreatedAt();
        LocalDateTime statusChangeDate = completedStatusHistory.getStatusChangeDate();

        if (returnBookCreatedAt == null || statusChangeDate == null) {
            return false;
        }

        long daysDifference = ChronoUnit.DAYS.between(statusChangeDate, returnBookCreatedAt);

        long dayAffect;
        if (returnBook.getReason() != EReasonReturn.NO_NEEDED) {
            dayAffect = 5;
        } else {
            dayAffect = 3;
        }

        if (daysDifference > dayAffect) {
            return false;
        }

        Set<ReturnBookItem> returnBookItems = new HashSet<>();

        for (ReturnBookRequest returnBookRequestItem : returnOrderRequest.getReturnBookItems()) {
            for (OrderItem orderItem : order.getOrderItems()) {
                if (orderItem.getBooks().iterator().next().getBookTemplate().getId() == returnBookRequestItem.getBookTemplateId()) {
                    Set<Book> books = new HashSet<>();
                    int quantityToReturn = returnBookRequestItem.getQuantity();
                    Iterator<Book> bookIterator = orderItem.getBooks().iterator();
                    while (bookIterator.hasNext() && quantityToReturn > 0) {
                        Book book = bookIterator.next();
                        if (book.getBookTemplate().getId() == returnBookRequestItem.getBookTemplateId()) {
                            books.add(book);
                            quantityToReturn--;
                        }
                    }

                    // Chỉ tạo ReturnBookItem khi có sách
                    if (!books.isEmpty()) {
                        ReturnBookItem returnBookItem = new ReturnBookItem();
                        returnBookItem.setBooks(books);
                        returnBookItem.setReturnBook(returnBook); // Gán ReturnBook vào ReturnBookItem
                        returnBookItems.add(returnBookItem);
                    }
                }
            }
        }

        returnBook.setReturnBookItems(returnBookItems);

        order.setStatus(EOrderStatus.REQUEST_REFUND);
        returnBook.setOrder(order);

        boolean success;
        try {
            returnBook = returnBookDAO.save(returnBook);
            if (returnBook == null) {
                throw new Exception("Failed to save ReturnBook");
            }

            order.setReturnBook(returnBook);
            order = orderDAO.update(order);
            if (order == null) {
                throw new Exception("Failed to update Order");
            }

            success = true;
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }

        return success;

//        ReturnBook returnBook = ReturnBookMapper.toEntity(returnOrderRequest);
//        Order order = orderDAO.findOne(returnOrderRequest.getOrderId());
//        Set<ReturnBookItem> returnBookItems = new HashSet<>();
//
//        for (ReturnBookRequest returnBookRequestItem : returnOrderRequest.getReturnBookItems()) {
//            for (OrderItem orderItem : order.getOrderItems()) {
//                if (orderItem.getBooks().iterator().next().getBookTemplate().getId() == returnBookRequestItem.getBookTemplateId()) {
//                    Set<Book> books = new HashSet<>();
//                    int quantityToReturn = returnBookRequestItem.getQuantity();
//                    Iterator<Book> bookIterator = orderItem.getBooks().iterator();
//                    while (bookIterator.hasNext() && quantityToReturn > 0) {
//                        Book book = bookIterator.next();
//                        if (book.getBookTemplate().getId() == returnBookRequestItem.getBookTemplateId()) {
//                            books.add(book);
//                            quantityToReturn--;
//                        }
//                    }
//                    if (!books.isEmpty()) {
//                        ReturnBookItem returnBookItem = new ReturnBookItem();
//                        returnBookItem.setBooks(books);
//                        returnBookItem.setReturnBook(returnBook);
//                        returnBookItems.add(returnBookItem);
//                    }
//                }
//            }
//        }
//        returnBook.setReturnBookItems(returnBookItems);
//        order.setStatus(EOrderStatus.REQUEST_REFUND);
//        returnBook.setOrder(order);
//        boolean success;
//        try {
//            returnBook = returnBookDAO.save(returnBook);
//            if (returnBook == null) {
//                throw new Exception("Failed to save ReturnBook");
//            }
//            order.setReturnBook(returnBook);
//            order = orderDAO.update(order);
//            if (order == null) {
//                throw new Exception("Failed to update Order");
//            }
//            success = true;
//        } catch (Exception e) {
//            success = false;
//            e.printStackTrace();
//        }
//
//        return success;
    }
}