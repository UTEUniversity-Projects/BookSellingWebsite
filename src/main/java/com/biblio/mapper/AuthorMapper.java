package com.biblio.mapper;

import com.biblio.dto.request.AuthorRequest;
import com.biblio.dto.response.AuthorAnalysisResponse;
import com.biblio.dto.response.AuthorLineResponse;
import com.biblio.dto.response.AuthorProfileResponse;
import com.biblio.entity.Author;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AuthorMapper {

    public static Author toAuthorEntity(AuthorRequest authorRequest) {
        return Author.builder()
                .id(Long.parseLong(authorRequest.getId() != null ? authorRequest.getId() : "1"))
                .name(authorRequest.getName() != null ? authorRequest.getName() : "")
                .avatar(authorRequest.getAvatar() != null ? authorRequest.getAvatar() : "")
                .introduction(authorRequest.getIntroduction() != null ? authorRequest.getIntroduction() : "")
                .joinAt(LocalDateTime.parse(authorRequest.getJoinAt() != null ? authorRequest.getJoinAt() : ""))
                .build();
    }

    public static AuthorProfileResponse toAuthorProfileResponse(Author author) {
        return AuthorProfileResponse.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .avatar(author.getAvatar())
                .introduction(author.getIntroduction())
                .joinAt(author.getJoinAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();
    }

    public static AuthorLineResponse toAuthorLineResponse(Author author, Integer works, Double avgRate, Double perValueBooksSold) {
        DecimalFormat percentFormatter = new DecimalFormat("#.0");

        return AuthorLineResponse.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .avatar(author.getAvatar())
                .introduction(author.getIntroduction())
                .joinAt(author.getJoinAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .works(works != null ? works.toString() : "0")
                .avgRate(avgRate != null ? String.format("%.1f", avgRate) : "N/A")
                .perValueBooksSold(perValueBooksSold != null ? Double.parseDouble(percentFormatter.format(perValueBooksSold)) : 0.0D)
                .build();
    }

    public static AuthorAnalysisResponse toAuthorAnalysisResponse(
            Author author,
            Integer works,
            Double avgRate,
            Integer sales,
            Double perSales,
            Integer booksSold,
            Double perBooksSold,
            Long valueBooksSold,
            Double perValueBooksSold,
            Integer booksInStock,
            Integer booksCancelled,
            Integer booksReturned,
            Integer salesThisMonth,
            Integer booksThisMonth,
            Long revenueThisMonth,
            Integer ordersCompleted,
            Long valueOrdersCompleted,
            Integer ordersWaiting,
            Long valueOrdersWaiting,
            Integer orderPacking,
            Long valueOrderPacking,
            Integer orderShipping,
            Long valueOrderShipping,
            Integer ordersCancelled,
            Long valueOrdersCancelled,
            Integer ordersRequestRefund,
            Long valueOrdersRequestRefund,
            Integer ordersRefunded,
            Long valueOrdersRefunded,
            List<String> topSubCategory
    ) {
        DecimalFormat formatter = new DecimalFormat("#,###,###,###,###,###,###");
        DecimalFormat percentFormatter = new DecimalFormat("#.0");

        return AuthorAnalysisResponse.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .avatar(author.getAvatar())
                .introduction(author.getIntroduction())
                .joinAt(author.getJoinAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .works(works != null ? works.toString() : "0")
                .avgRate(avgRate != null ? String.format("%.1f", avgRate) : "N/A")
                .sales(sales != null ? sales.toString() : "0")
                .perSales(perSales != null ? Double.parseDouble(percentFormatter.format(perSales)) : 0.0D)
                .booksSold(booksSold != null ? String.format("%,d", booksSold) : "0")
                .perBooksSold(perBooksSold != null ? Double.parseDouble(percentFormatter.format(perBooksSold)) : 0.0D)
                .valueBooksSold(valueBooksSold != null ? formatter.format(valueBooksSold).replace(",", ".") : "0")
                .perValueBooksSold(perValueBooksSold != null ? Double.parseDouble(percentFormatter.format(perValueBooksSold)) : 0.0D)
                .booksInStock(booksInStock != null ? booksInStock.toString() : "0")
                .booksCancelled(booksCancelled != null ? booksCancelled.toString() : "0")
                .booksReturned(booksReturned != null ? booksReturned.toString() : "0")
                .salesThisMonth(salesThisMonth != null ? salesThisMonth.toString() : "0")
                .booksThisMonth(booksThisMonth != null ? booksThisMonth.toString() : "0")
                .revenueThisMonth(revenueThisMonth != null ? formatter.format(revenueThisMonth).replace(",", ".") : "0")
                .ordersCompleted(ordersCompleted != null ? ordersCompleted.toString() : "0")
                .valueOrdersCompleted(valueOrdersCompleted != null ? formatter.format(valueOrdersCompleted).replace(",", ".") : "0")
                .ordersWaiting(ordersWaiting != null ? ordersWaiting.toString() : "0")
                .valueOrdersWaiting(valueOrdersWaiting != null ? formatter.format(valueOrdersWaiting).replace(",", ".") : "0")
                .orderPacking(orderPacking != null ? orderPacking.toString() : "0")
                .valueOrderPacking(valueOrderPacking != null ? formatter.format(valueOrderPacking).replace(",", ".") : "0")
                .orderShipping(orderShipping != null ? orderShipping.toString() : "0")
                .valueOrderShipping(valueOrderShipping != null ? formatter.format(valueOrderShipping).replace(",", ".") : "0")
                .ordersCancelled(ordersCancelled != null ? ordersCancelled.toString() : "0")
                .valueOrdersCancelled(valueOrdersCancelled != null ? formatter.format(valueOrdersCancelled).replace(",", ".") : "0")
                .ordersRequestRefund(ordersRequestRefund != null ? ordersRequestRefund.toString() : "0")
                .valueOrdersRequestRefund(valueOrdersRequestRefund != null ? formatter.format(valueOrdersRequestRefund).replace(",", ".") : "0")
                .ordersRefunded(ordersRefunded != null ? ordersRefunded.toString() : "0")
                .valueOrdersRefunded(valueOrdersRefunded != null ? formatter.format(valueOrdersRefunded).replace(",", ".") : "0")
                .topSubCategory(topSubCategory != null ? topSubCategory : List.of())
                .build();
    }
}
