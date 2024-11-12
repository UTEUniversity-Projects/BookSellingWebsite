package com.biblio.mapper;

import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookGetListResponse;
import com.biblio.dto.response.BookResponse;
import com.biblio.entity.Author;
import com.biblio.entity.Book;
import com.biblio.enumeration.EBookAgeRecommend;
import com.biblio.enumeration.EBookCondition;
import com.biblio.enumeration.EBookFormat;
import com.biblio.enumeration.EBookLanguage;
import com.biblio.utils.EnumUtil;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static com.biblio.mapper.BookMetadataMapper.toBookMetadataResponse;
import static com.biblio.mapper.CategoryMapper.toCategoryResponse;
import static com.biblio.mapper.PublisherMapper.toPublisherResponse;
import static com.biblio.utils.DateTimeUtil.formatDateTime;

public class BookMapper {
    public static BookGetListResponse toBookGetListResponse(Book book) {
        BookGetListResponse bookGetListResponse = new BookGetListResponse();
        bookGetListResponse.setId(book.getId());
        bookGetListResponse.setTitle(book.getTitle());
        bookGetListResponse.setDescription(book.getDescription());
        bookGetListResponse.setSellingPrice(book.getSellingPrice());

        bookGetListResponse.setCategory(toCategoryResponse(book.getCategory()));
        bookGetListResponse.setMetadata(toBookMetadataResponse(book.getMetadata()));
        bookGetListResponse.setReviewRate(book.calculateReviewRate());

        return bookGetListResponse;
    }

    public static BookResponse toBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setDescription(book.getDescription());
        bookResponse.setSellingPrice(book.getSellingPrice());
        bookResponse.setPublicationDate(formatDateTime(book.getPublicationDate(), "dd-MM-yyyy"));
        bookResponse.setEdition(book.getEdition());
        bookResponse.setCodeISBN10(book.getCodeISBN10());
        bookResponse.setCodeISBN13(book.getCodeISBN13());
        bookResponse.setFormat(book.getFormat().getBookFormat());
        bookResponse.setHandcover(book.getHandcover());
        bookResponse.setLength(book.getLength());
        bookResponse.setWidth(book.getWidth());
        bookResponse.setHeight(book.getHeight());
        bookResponse.setWeight(book.getWeight());
        bookResponse.setCondition(book.getCondition().toString());
        bookResponse.setRecommendedAge(book.getRecommendedAge().getBookAgeRecommend());
        String languages = book.getLanguages().stream()
                .map(EBookLanguage::getDescription)
                .collect(Collectors.joining(", "));
        bookResponse.setLanguages(languages);

        bookResponse.setCategory(toCategoryResponse(book.getCategory()));
        bookResponse.setPublisher(toPublisherResponse(book.getPublisher()));
        bookResponse.setMetadata(toBookMetadataResponse(book.getMetadata()));
        for(Author author : book.getAuthors()) {
            bookResponse.getAuthors().add(AuthorMapper.toAuthorResponse(author));
        }
        return bookResponse;
    }
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
                .languages(bookRequest.getLanguages())
                .build();
    }

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
                .languages(book.getLanguages())
                .build();
    }
}
