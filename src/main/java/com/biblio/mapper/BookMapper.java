package com.biblio.mapper;

import com.biblio.dto.request.BookRequest;
import com.biblio.dto.response.BookCardResponse;
import com.biblio.dto.response.BookDetailsResponse;
import com.biblio.dto.response.BookResponse;
import com.biblio.entity.*;
import com.biblio.enumeration.EBookAgeRecommend;
import com.biblio.enumeration.EBookCondition;
import com.biblio.enumeration.EBookFormat;
import com.biblio.enumeration.EBookLanguage;
import com.biblio.utils.EnumUtil;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static com.biblio.mapper.CategoryMapper.toCategorySidebarResponse;
import static com.biblio.mapper.PublisherMapper.toPublisherResponse;
import static com.biblio.utils.DateTimeUtil.formatDateTime;

public class BookMapper {
    public static BookCardResponse toBookCardResponse(Book book) {
        BookCardResponse bookCardResponse = new BookCardResponse();
        bookCardResponse.setId(book.getId());
        bookCardResponse.setTitle(book.getTitle());
        bookCardResponse.setDescription(book.getDescription());
        bookCardResponse.setSellingPrice(book.getSellingPrice());

        bookCardResponse.setCategory(toCategorySidebarResponse(book.getSubCategory().getCategory()));
        bookCardResponse.setImageUrl(book.getBookTemplate().getMediaFiles().iterator().next().getStoredCode().replaceAll("image\\d+\\.jpg", "image1.jpg"));
        bookCardResponse.setReviewRate(book.getBookTemplate().calculateReviewRate());

        return bookCardResponse;
    }

    public static BookDetailsResponse toBookDetailsResponse(Book book) {
        BookDetailsResponse bookDetailsResponse = new BookDetailsResponse();
        bookDetailsResponse.setId(book.getId());
        bookDetailsResponse.setTitle(book.getTitle());
        bookDetailsResponse.setDescription(book.getDescription());
        bookDetailsResponse.setSellingPrice(book.getSellingPrice());
        bookDetailsResponse.setPublicationDate(formatDateTime(book.getPublicationDate(), "dd-MM-yyyy"));
        bookDetailsResponse.setEdition(book.getEdition());
        bookDetailsResponse.setCodeISBN10(book.getCodeISBN10());
        bookDetailsResponse.setCodeISBN13(book.getCodeISBN13());
        bookDetailsResponse.setFormat(book.getFormat().getBookFormat());
        bookDetailsResponse.setHandcover(book.getHandcover());
        bookDetailsResponse.setLength(book.getLength());
        bookDetailsResponse.setWidth(book.getWidth());
        bookDetailsResponse.setHeight(book.getHeight());
        bookDetailsResponse.setWeight(book.getWeight());
        bookDetailsResponse.setCondition(book.getCondition().getBookCondition());
        bookDetailsResponse.setRecommendedAge(book.getRecommendedAge().getBookAgeRecommend());
        String languages = book.getBookTemplate().getLanguages().stream()
                .map(EBookLanguage::getDescription)
                .collect(Collectors.joining(", "));
        bookDetailsResponse.setLanguages(languages);

        bookDetailsResponse.setCategory(toCategorySidebarResponse(book.getSubCategory().getCategory()));
        int counter = 1;
        for (MediaFile mediaFile : book.getBookTemplate().getMediaFiles()) {
            bookDetailsResponse.getImageUrls().add(mediaFile.getStoredCode().replaceAll("image\\d+\\.jpg", "image" + counter + ".jpg"));
            counter++;
        }
        bookDetailsResponse.setPublisher(toPublisherResponse(book.getBookTemplate().getPublisher()));
////        bookDetailsResponse.setMetadata(toBookMetadataResponse(book.getMetadata()));
        for (Author author : book.getBookTemplate().getAuthors()) {
            bookDetailsResponse.getAuthors().add(AuthorMapper.toAuthorResponse(author));
        }

//        for (Translator translator : book.getBookTemplate().getTranslators()) {
//            bookDetailsResponse.getTranslators().add(TranslatorMapper.toTranslatorResponse(translator));
//        }

        for (Review review : book.getBookTemplate().getReviews()) {
            bookDetailsResponse.getReviews().add(ReviewMapper.toReviewResponse(review));
        }
        return bookDetailsResponse;
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
                .languages(book.getBookTemplate().getLanguages())
                .build();
    }
}
