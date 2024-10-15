package com.biblio.entity;

import com.biblio.enumeration.EBookAgeRecommend;
import com.biblio.enumeration.EBookCondition;
import com.biblio.enumeration.EBookFormat;
import com.biblio.enumeration.EBookLanguage;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.List;

public class Book implements Serializable {
    private String id;
    private String title;
    private List<Author> authors;
    private List<Translator> translators;
    private Category category;
    private SubCategory subCategory;
    private String description;
    private double sellingPrice;
    private Publisher publisher;
    private DateTimeException publicationDate;
    private int edition;
    private String codeISBN10;
    private String codeISBN13;
    private EBookFormat format;
    private int handcover;
    private double length;
    private double width;
    private double height;
    private List<EBookLanguage> language;
    private double weight;
    private EBookCondition condition;
    private EBookAgeRecommend recommendedAge;
    private BookMetadata metadata;

    public Book() {}

    public Book(String id, String title, List<Author> authors, List<Translator> translators,
                Category category, SubCategory subCategory, String description,
                double sellingPrice, Publisher publisher, DateTimeException publicationDate,
                int edition, String codeISBN10, String codeISBN13,
                EBookFormat format, int handcover, double length,
                double width, double height, List<EBookLanguage> language,
                double weight, EBookCondition condition,
                EBookAgeRecommend recommendedAge, BookMetadata metadata) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.translators = translators;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.edition = edition;
        this.codeISBN10 = codeISBN10;
        this.codeISBN13 = codeISBN13;
        this.format = format;
        this.handcover = handcover;
        this.length = length;
        this.width = width;
        this.height = height;
        this.language = language;
        this.weight = weight;
        this.condition = condition;
        this.recommendedAge = recommendedAge;
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Translator> getTranslators() {
        return translators;
    }

    public void setTranslators(List<Translator> translators) {
        this.translators = translators;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public DateTimeException getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(DateTimeException publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getCodeISBN10() {
        return codeISBN10;
    }

    public void setCodeISBN10(String codeISBN10) {
        this.codeISBN10 = codeISBN10;
    }

    public String getCodeISBN13() {
        return codeISBN13;
    }

    public void setCodeISBN13(String codeISBN13) {
        this.codeISBN13 = codeISBN13;
    }

    public EBookFormat getFormat() {
        return format;
    }

    public void setFormat(EBookFormat format) {
        this.format = format;
    }

    public int getHandcover() {
        return handcover;
    }

    public void setHandcover(int handcover) {
        this.handcover = handcover;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<EBookLanguage> getLanguage() {
        return language;
    }

    public void setLanguage(List<EBookLanguage> language) {
        this.language = language;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public EBookCondition getCondition() {
        return condition;
    }

    public void setCondition(EBookCondition condition) {
        this.condition = condition;
    }

    public EBookAgeRecommend getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(EBookAgeRecommend recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public BookMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(BookMetadata metadata) {
        this.metadata = metadata;
    }
}
