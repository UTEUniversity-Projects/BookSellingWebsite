package com.biblio.mapper;

import com.biblio.dao.impl.BookTemplateDAOImpl;
import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookResponse;
import com.biblio.dto.response.BookSoldResponse;
import com.biblio.dto.response.CountBookSoldResponse;
import com.biblio.entity.Book;
import com.biblio.enumeration.EBookAgeRecommend;
import com.biblio.enumeration.EBookCondition;
import com.biblio.enumeration.EBookFormat;
import com.biblio.utils.EnumUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookMapper {
    // region EntityToDTO

    public static BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId().toString())
                .title(book.getTitle())
                .description(book.getDescription())
                .sellingPrice(Double.toString(book.getSellingPrice()))
                .publicationDate(book.getPublicationDate().toString())
                .edition(Integer.toString(book.getEdition()))
                .codeISBN10(book.getCodeISBN10())
                .codeISBN13(book.getCodeISBN13())
                .format(EnumUtil.toDisplayName(book.getFormat()))
                .handCover(Integer.toString(book.getHandcover()))
                .length(Double.toString(book.getLength()))
                .width(Double.toString(book.getWidth()))
                .height(Double.toString(book.getHeight()))
                .weight(Double.toString(book.getWeight()))
                .condition(EnumUtil.toDisplayName(book.getCondition()))
                .recommendedAge(EnumUtil.toDisplayName(book.getRecommendedAge()))
                .languages(book.getBookTemplate().getLanguages())
                .build();
    }

    // endregion

    // region DTOtoEntity

    public static Book toBookEntity(BookRequest bookRequest) {
        return Book.builder()
                .id(Long.parseLong(bookRequest.getId()))
                .title(bookRequest.getTitle())
                .description(bookRequest.getDescription())
                .sellingPrice(Double.parseDouble(bookRequest.getSellingPrice()))
                .publicationDate(LocalDateTime.parse(bookRequest.getPublicationDate()))
                .edition(Integer.parseInt(bookRequest.getEdition()))
                .codeISBN10(bookRequest.getCodeISBN10())
                .codeISBN13(bookRequest.getCodeISBN13())
                .format(EnumUtil.fromDisplayName(EBookFormat.class, bookRequest.getFormat()))
                .handcover(Integer.parseInt(bookRequest.getHandCover()))
                .length(Double.parseDouble(bookRequest.getLength()))
                .width(Double.parseDouble(bookRequest.getWidth()))
                .height(Double.parseDouble(bookRequest.getHeight()))
                .weight(Double.parseDouble(bookRequest.getWeight()))
                .condition(EnumUtil.fromDisplayName(EBookCondition.class, bookRequest.getCondition()))
                .recommendedAge(EnumUtil.fromDisplayName(EBookAgeRecommend.class, bookRequest.getRecommendedAge()))
                .build();
    }

    public static BookSoldResponse toBookSoldResponse(Book book) {
        BookTemplateDAOImpl bookTemplateDAO = new BookTemplateDAOImpl();
        return BookSoldResponse.builder()
                .id(book.getBookTemplate().getId())
                .title(book.getTitle())
                .srcImg(book.getBookTemplate()
                        .getMediaFiles()
                        .get(0)
                        .getStoredCode())
                .category(book.getSubCategory().getCategory().getName())
                .countInStock(bookTemplateDAO.countInstockById(book.getBookTemplate().getId()))// or provide a default value like "" if you prefer
                .build();
    }
    public static List<CountBookSoldResponse> toCountBookSoldResponse (List<BookSoldResponse> bookSoldResponses) {
        Map<String, Long> countMap = bookSoldResponses.stream()
                .collect(Collectors.groupingBy(book -> book.getId() + "-" + book.getSrcImg() + "-" + book.getTitle() + "-" + book.getCategory() + "-" + book.getCountInStock(), Collectors.counting()));

        return countMap.entrySet().stream()
                .map(entry -> {
                    String[] parts = entry.getKey().split("-");
                    return new CountBookSoldResponse(
                            Long.parseLong(parts[0]),      // id
                            parts[1],                     // srcImg
                            parts[2],                     // title
                            parts[3],                     // category
                            Long.parseLong(parts[4]),     // countInStock
                            entry.getValue()              // count
                    );
                })
                .collect(Collectors.toList());
    }
    // endregion
}
