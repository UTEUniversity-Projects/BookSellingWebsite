package com.biblio.mapper;

import com.biblio.dto.response.*;
import com.biblio.entity.*;
import com.biblio.enumeration.EBookLanguage;
import com.biblio.enumeration.EBookMetadataStatus;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import static com.biblio.utils.DateTimeUtil.formatDateTime;

public class BookTemplateMapper {
    // region Entity to DTO

    public static BookManagementResponse toBookManagementResponse(BookTemplate bookTemplate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        Book singlebook = bookTemplate.getBooks().iterator().next();
        return BookManagementResponse.builder()
                .id(bookTemplate.getId())
                .imageUrl(bookTemplate
                        .getMediaFiles()
                        .get(0)
                        .getStoredCode())
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

    public static BookCardResponse toBookCardResponse(BookTemplate bookTemplate) {

        DecimalFormat decimalFormat = new DecimalFormat("#.###");

        Book singlebook = bookTemplate.getBooks().iterator().next();
        return BookCardResponse.builder()
                .id(bookTemplate.getId())
                .title(singlebook.getTitle())
                .sellingPrice(decimalFormat.format(singlebook.getSellingPrice()))
                .condition(singlebook.getCondition().getBookCondition())
                .categoryName(singlebook.getSubCategory().getCategory().getName())
                .imageUrl(bookTemplate
                        .getMediaFiles()
                        .get(0)
                        .getStoredCode())
                .reviewRate(bookTemplate.calculateReviewRate())
                .numberOfReviews(bookTemplate.getReviews().stream().filter(review -> !review.isHidden()).count())
                .build();
    }

    public static BookDetailsResponse toBookDetailsResponse(BookTemplate bookTemplate) {
        Book singlebook = bookTemplate.getBooks().iterator().next();

        String languages = bookTemplate.getLanguages() != null
                ? bookTemplate.getLanguages().stream()
                .map(EBookLanguage::getDescription)
                .collect(Collectors.joining(", ")) : "N/A";

        List<String> fileNames = bookTemplate.getMediaFiles().stream()
                .sorted(Comparator.comparing(MediaFile::getId))
                .map(MediaFile::getStoredCode)
                .toList();

        List<AuthorResponse> authors = new ArrayList<>();
        for (Author author : bookTemplate.getAuthors()) {
            authors.add(AuthorMapper.toAuthorResponse(author));
        }

        List<TranslatorResponse> translators = new ArrayList<>();
        for (Translator translator : bookTemplate.getTranslators()) {
            translators.add(TranslatorMapper.toTranslatorResponse(translator));
        }

        List<ReviewResponse> reviews = bookTemplate.getReviews().stream()
                .filter(review -> !review.isHidden())
                .sorted(Comparator.comparingInt(Review::getRate).reversed()
                        .thenComparing(Review::getCreatedAt, Comparator.reverseOrder()))
                .map(ReviewMapper::toReviewResponse)
                .toList();

        return BookDetailsResponse.builder()
                .id(bookTemplate.getId())
                .title(singlebook.getTitle())
                .description(singlebook.getDescription())
                .sellingPrice(singlebook.getSellingPrice())
                .publicationDate(formatDateTime(singlebook.getPublicationDate(), "dd-MM-yyyy"))
                .edition(singlebook.getEdition())
                .codeISBN10(singlebook.getCodeISBN10())
                .codeISBN13(singlebook.getCodeISBN13())
                .format(singlebook.getFormat().getBookFormat())
                .hardcover(singlebook.getHandcover())
                .size(String.format("%.1f x %.1f x %.1f cm",
                        singlebook.getHeight(), singlebook.getLength(), singlebook.getWidth()))
                .weight(singlebook.getWeight())
                .condition(singlebook.getCondition().getBookCondition())
                .recommendedAge(singlebook.getRecommendedAge().getBookAgeRecommend())
                .category(singlebook.getSubCategory().getCategory().getName())
                .languages(languages)
                .quantity(bookTemplate.getBooks().stream().
                        filter(book -> book.getBookMetadata().getStatus() == EBookMetadataStatus.IN_STOCK).count())
                .avgRating(bookTemplate.calculateReviewRate())
                .imageUrls(fileNames)
                .publisher(bookTemplate.getPublisher().getName())
                .authors(authors)
                .translators(translators)
                .reviews(reviews)
                .reviewCount(reviews.size())
                .build();
    }
    public static BookTemplatePromotionResponse toBookTemplatePromotionResponse(BookTemplate bookTemplate) {
        Book singlebook = bookTemplate.getBooks().iterator().next();
        return BookTemplatePromotionResponse.builder()
                .id(bookTemplate.getId())
                .title(singlebook.getTitle())
                .subCategoryId(singlebook.getSubCategory().getId())
                .build();
    }
    // endregion

    // region DTO to Entity

    // endregion
}
