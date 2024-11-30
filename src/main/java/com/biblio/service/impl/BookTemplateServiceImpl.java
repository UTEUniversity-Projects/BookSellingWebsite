package com.biblio.service.impl;

import com.biblio.dao.IBookTemplateDAO;

import com.biblio.dto.request.SearchBookRequest;
import com.biblio.dto.response.*;

import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.enumeration.EBookMetadataStatus;
import com.biblio.enumeration.EBookTemplateStatus;
import com.biblio.enumeration.EOrderStatus;
import com.biblio.mapper.BookTemplateMapper;
import com.biblio.service.IBookTemplateService;
import net.bytebuddy.asm.Advice;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookTemplateServiceImpl implements IBookTemplateService {

    @Inject
    IBookTemplateDAO bookTemplateDAO;

    @Override
    public List<BookManagementResponse> getAllBookManagementResponse() {
        List<BookTemplate> bookTemplates = bookTemplateDAO.findAllForManagement();
        List<BookManagementResponse> bookManagementResponseList = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookManagementResponseList.add(BookTemplateMapper.toBookManagementResponse(bookTemplate));
        }
        return bookManagementResponseList;
    }

    @Override
    public List<BookCardResponse> getAllBookCardResponse() {
        List<BookTemplate> bookTemplates = bookTemplateDAO.findAllForHome();
        List<BookCardResponse> bookCardResponseList = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookCardResponseList.add(BookTemplateMapper.toBookCardResponse(bookTemplate));
        }
        return bookCardResponseList;
    }

    @Override
    public BookDetailsResponse getBookDetailsResponse(Long bookTemplateId) {
        BookTemplate bookTemplate = bookTemplateDAO.findOneForDetails(bookTemplateId);
        return BookTemplateMapper.toBookDetailsResponse(bookTemplate);
    }

    @Override
    public List<BookTemplatePromotionResponse> getAllBookBookTemplatePromotionResponse() {
        List<BookTemplate> bookTemplates = bookTemplateDAO.findAll();
        List<BookTemplatePromotionResponse> bookTemplatePromotionResponse = new ArrayList<>();
        for (BookTemplate bookTemplate : bookTemplates) {
            bookTemplatePromotionResponse.add(BookTemplateMapper.toBookTemplatePromotionResponse(bookTemplate));
        }
        return bookTemplatePromotionResponse;
    }

    @Override
    public List<BookCardResponse> getBookTemplateByCriteria(SearchBookRequest request) {

        List<BookTemplate> bookTemplates = bookTemplateDAO.findByCriteria(request.getTitle().trim(), request.getCategoryId(), request.getSortBy(), 1);
        List<BookCardResponse> bookCardResponseList = new ArrayList<>();
        for (BookTemplate bt : bookTemplates) {
            bookCardResponseList.add(BookTemplateMapper.toBookCardResponse(bt));
        }
        return bookCardResponseList;

    }
    @Override
    public List<BookSoldAllTimeResponse> getListCountBookSoldAllTime() {
        List<BookSoldAllTimeResponse> listBookSold = new ArrayList<>();
        List<BookTemplate> bookTemplateList = bookTemplateDAO.findAllForHome();
        for (BookTemplate bookTemplate : bookTemplateList) {
            BookTemplate book = bookTemplateDAO.findOneForDetails(bookTemplate.getId());
            listBookSold.add(BookTemplateMapper.toBookSoldAllTimeResponse(book));
        }

        listBookSold.sort(Comparator.comparingLong(BookSoldAllTimeResponse::getCountSold).reversed());
        return listBookSold;
    }

    @Override
    public Long getTotalBookTemplateQuantity() {
        return bookTemplateDAO.countAll();
    }

    @Override
    public Long getBookTemplateQuantityByCriteria(SearchBookRequest request) {
        return bookTemplateDAO.countByCriteria(request.getTitle(), request.getCategoryId(), request.getSortBy());
    }

    @Override
    public List<BookLineResponse> getAllBookLineResponse() {
        List<BookTemplate> bookTemplates = bookTemplateDAO.findAllForManagement();
        List<BookLineResponse> bookLineResponseList = new ArrayList<>();

        for (BookTemplate bookTemplate : bookTemplates) {
            Double perValueBooksSold = calculateValueBooksSoldGrowth(bookTemplate.getId());
            bookLineResponseList.add(BookTemplateMapper.toBookLineResponse(bookTemplate, perValueBooksSold));
        }

        return bookLineResponseList;
    }

    @Override
    public BookAnalysisResponse getBookAnalysisResponse(Long bookTemplateId) {
        BookTemplate bookTemplate = bookTemplateDAO.findOneForDetails(bookTemplateId);
        Integer salesCount = bookTemplateDAO.countOrdersByStatus(bookTemplateId, EOrderStatus.COMPLETE_DELIVERY);
        Integer booksCount = bookTemplateDAO.countBooksInOrderByStatus(bookTemplateId, EBookMetadataStatus.SOLD, EOrderStatus.COMPLETE_DELIVERY);
        Long revenue = bookTemplateDAO.calculateValueBooksSold(bookTemplateId, EOrderStatus.COMPLETE_DELIVERY);
        Integer salesCountThisMonth = countSalesCountThisMonth(bookTemplateId);
        Double perSalesCountThisMonth = calculateSalesCountGrowth(bookTemplateId);
        Integer booksCountThisMonth = countBooksCountThisMonth(bookTemplateId);
        Double perBooksCountThisMonth = calculateBooksCountGrowth(bookTemplateId);
        Long revenueThisMonth = calculateRevenueThisMonth(bookTemplateId);
        Double perRevenueThisMonth = calculateValueBooksSoldGrowth(bookTemplateId);

        return BookTemplateMapper.toBookAnalysisResponse(bookTemplate, salesCount, booksCount, revenue,
                salesCountThisMonth, perSalesCountThisMonth,
                booksCountThisMonth, perBooksCountThisMonth,
                revenueThisMonth, perRevenueThisMonth);
    }

    private Double calculateSalesCountGrowth(Long id) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfThisMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();
        LocalDateTime endOfThisMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        LocalDateTime startOfLastMonth = startOfThisMonth.minusMonths(1);
        LocalDateTime endOfLastMonth = endOfThisMonth.minusMonths(1);

        Integer currentMonth = countSalesCountThisMonth(id);
        Integer lastMonth = bookTemplateDAO.countOrdersInRangeByStatus(id, startOfLastMonth, endOfLastMonth, EOrderStatus.COMPLETE_DELIVERY);

        if (lastMonth != 0) {
            return ((double) (currentMonth - lastMonth) / lastMonth) * 100.0D;
        } else {
            if (currentMonth != 0) return 100.0D;
            else return 0.0D;
        }
    }
    private Integer countSalesCountThisMonth(Long id) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfThisMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();
        LocalDateTime endOfThisMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        return bookTemplateDAO.countOrdersInRangeByStatus(id, startOfThisMonth, endOfThisMonth, EOrderStatus.COMPLETE_DELIVERY);
    }

    private Double calculateBooksCountGrowth(Long id) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfThisMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();
        LocalDateTime endOfThisMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        LocalDateTime startOfLastMonth = startOfThisMonth.minusMonths(1);
        LocalDateTime endOfLastMonth = endOfThisMonth.minusMonths(1);

        Integer currentMonth = countBooksCountThisMonth(id);
        Integer lastMonth = bookTemplateDAO.countBooksInRangeByStatus(id, startOfLastMonth, endOfLastMonth, EBookMetadataStatus.SOLD, EOrderStatus.COMPLETE_DELIVERY);

        if (lastMonth != 0) {
            return ((double) (currentMonth - lastMonth) / lastMonth) * 100.0D;
        } else {
            if (currentMonth != 0) return 100.0D;
            else return 0.0D;
        }
    }
    private Integer countBooksCountThisMonth(Long id) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfThisMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();
        LocalDateTime endOfThisMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        return bookTemplateDAO.countBooksInRangeByStatus(id, startOfThisMonth, endOfThisMonth, EBookMetadataStatus.SOLD, EOrderStatus.COMPLETE_DELIVERY);
    }

    private Double calculateValueBooksSoldGrowth(Long id) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfThisMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();
        LocalDateTime endOfThisMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        LocalDateTime startOfLastMonth = startOfThisMonth.minusMonths(1);
        LocalDateTime endOfLastMonth = endOfThisMonth.minusMonths(1);

        Long currentMonth = calculateRevenueThisMonth(id);
        Long lastMonth = bookTemplateDAO.calculateValueBooksSoldInRange(id, startOfLastMonth, endOfLastMonth, EOrderStatus.COMPLETE_DELIVERY);

        if (lastMonth != 0) {
            return ((double) (currentMonth - lastMonth) / lastMonth) * 100.0D;
        } else {
            if (currentMonth != 0) return 100.0D;
            else return 0.0D;
        }
    }
    private Long calculateRevenueThisMonth(Long id) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfThisMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();
        LocalDateTime endOfThisMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        return bookTemplateDAO.calculateValueBooksSoldInRange(id, startOfThisMonth, endOfThisMonth, EOrderStatus.COMPLETE_DELIVERY);
    }
}
