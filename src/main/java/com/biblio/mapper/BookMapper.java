package com.biblio.mapper;

import com.biblio.dto.response.BookGetListResponse;
import com.biblio.dto.response.BookResponse;
import com.biblio.entity.Author;
import com.biblio.entity.Book;
import com.biblio.enumeration.EBookLanguage;

import java.util.stream.Collectors;

import static com.biblio.mapper.CategoryMapper.toCategoryResponse;
import static com.biblio.mapper.PublisherMapper.toPublisherResponse;
import static com.biblio.mapper.BookMetadataMapper.toBookMetadataResponse;
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
}
