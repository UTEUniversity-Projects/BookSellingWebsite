package com.biblio.mapper;

import com.biblio.dto.response.*;
import com.biblio.entity.*;
import com.biblio.enumeration.EBookLanguage;
import com.biblio.enumeration.EBookMetadataStatus;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookTemplateMapper {
    // region EntityToDTO

    public static BookManagementResponse toBookManagementResponse(BookTemplate bookTemplate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        Book singlebook = bookTemplate.getBooks().iterator().next();
        return BookManagementResponse.builder()
                .id(bookTemplate.getId())
                .imageUrl(singlebook
                        .getBookTemplate()
                        .getMediaFiles()
                        .iterator().next()
                        .getStoredCode()
                        .replaceAll("image\\d+\\.jpg", "image1.jpg"))
                .title(singlebook.getTitle())
                .price(singlebook.getSellingPrice())
                .quantity(bookTemplate.getBooks().stream().
                        filter(book -> book.getBookMetadata().getStatus() == EBookMetadataStatus.IN_STOCK).count())
                .soldCount(bookTemplate.getBooks().stream().
                        filter(book -> book.getBookMetadata().getStatus() == EBookMetadataStatus.SOLD).count())
                .publicationDate(singlebook.getPublicationDate().format(formatter))
                .statusDisplay(bookTemplate.getStatus().getDescription())
                .statusStyle(bookTemplate.getStatus().getStatusStyle())
                .build();
    }

    public static BookDetailsManagementResponse toBookDetailsManagementResponse(BookTemplate bookTemplate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Book singlebook = bookTemplate.getBooks().iterator().next();

        List<String> fileNames = bookTemplate.getMediaFiles().stream()
                .sorted(Comparator.comparing(MediaFile::getId))
                .map(MediaFile::getStoredCode)
                .toList();

        String languages = singlebook.getBookTemplate() != null && singlebook.getBookTemplate().getLanguages() != null
                ? singlebook.getBookTemplate().getLanguages().stream()
                .map(EBookLanguage::getDescription)
                .collect(Collectors.joining(", "))
                : "N/A";


        List<AuthorResponse> authors = new ArrayList<>();
        for (Author author : bookTemplate.getAuthors()) {
            authors.add(AuthorMapper.toAuthorResponse(author));
        }

        List<ReviewResponse> reviews = bookTemplate.getReviews().stream()
                .sorted(Comparator.comparingInt(Review::getRate).reversed()
                        .thenComparing(Review::getCreatedAt, Comparator.reverseOrder()))
                .map(ReviewMapper::toReviewResponse)
                .toList();


        return BookDetailsManagementResponse.builder()
                .imagesUrl(fileNames)
                .title(singlebook.getTitle())
                .description(singlebook.getDescription())
                .totalRating(bookTemplate.calculateReviewRate())
                .publicationDate(singlebook.getPublicationDate() != null
                        ? singlebook.getPublicationDate().format(formatter)
                        : "N/A")
                .languages(languages)
                .sellingPrice(singlebook.getSellingPrice())
                .edition(singlebook.getEdition())
                .condition(singlebook.getCondition().getBookCondition())
                .authors(authors)
                .publisher(bookTemplate.getPublisher().getName())
                .quantity(bookTemplate.getBooks().stream().
                        filter(book -> book.getBookMetadata().getStatus() == EBookMetadataStatus.IN_STOCK).count())
                .size(String.format("%.1f x %.1f x %.1f cm",
                        singlebook.getLength(), singlebook.getWidth(), singlebook.getHeight()))
                .weight(singlebook.getWeight())
                .hardcover(singlebook.getHandcover())
                .format(singlebook.getFormat().getBookFormat())
                .codeISBN10(singlebook.getCodeISBN10())
                .codeISBN13(singlebook.getCodeISBN13())
                .ageRecommend(singlebook.getRecommendedAge().getBookAgeRecommend())
                .reviews(reviews)
                .build();
    }

    public static BookTemplatePromotionResponse toBookTemplatePromotionResponse(BookTemplate bookTemplate) {
        Book singlebook = bookTemplate.getBooks().iterator().next();
        return BookTemplatePromotionResponse.builder()
                .id(bookTemplate.getId())
                .title(singlebook.getTitle())
                .build();
    }
    // endregion

}
