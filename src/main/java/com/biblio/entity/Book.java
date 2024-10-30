package com.biblio.entity;


import com.biblio.enumeration.EBookAgeRecommend;
import com.biblio.enumeration.EBookCondition;
import com.biblio.enumeration.EBookFormat;
import com.biblio.enumeration.EBookLanguage;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "selling_price", nullable = false)
    private double sellingPrice;

    @Column(name = "publication_date", nullable = false)
    private LocalDateTime publicationDate;

    @Column(name = "edition", nullable = false)
    private int edition;

    @Column(name = "code_ISBN10", nullable = false)
    private String codeISBN10;

    @Column(name = "code_ISBN13", nullable = false)
    private String codeISBN13;

    @Enumerated(EnumType.STRING)
    @Column(name = "format", nullable = false)
    private EBookFormat format;

    @Column(name = "hand_cover", nullable = false)
    private int handcover;

    @Column(name = "length", nullable = false)
    private double length;

    @Column(name = "width", nullable = false)
    private double width;

    @Column(name = "height", nullable = false)
    private double height;

    @ElementCollection
    @CollectionTable(name = "book_languages", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "language", nullable = false)
    private Set<EBookLanguage> languages = new HashSet<>();

    @Column(name = "weight", nullable = false)
    private double weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "[condition]")
    private EBookCondition condition;

    @Enumerated(EnumType.STRING)
    @Column(name = "recommended_age", nullable = false)
    private EBookAgeRecommend recommendedAge;

    // endregion Attributes

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_metadata_id", nullable = false)
    private BookMetadata metadata;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<Translator> translators = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<OrderItem> orderItems = new HashSet<>();

    // endregion

    // region Constructors

    public Book() {
    }

    public Book(String id, String title, String description, double sellingPrice, LocalDateTime publicationDate, int edition, String codeISBN10, String codeISBN13, EBookFormat format, int handcover, double length, double width, double height, Set<EBookLanguage> languages, double weight, EBookCondition condition, EBookAgeRecommend recommendedAge) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.publicationDate = publicationDate;
        this.edition = edition;
        this.codeISBN10 = codeISBN10;
        this.codeISBN13 = codeISBN13;
        this.format = format;
        this.handcover = handcover;
        this.length = length;
        this.width = width;
        this.height = height;
        this.languages = languages;
        this.weight = weight;
        this.condition = condition;
        this.recommendedAge = recommendedAge;
    }

    // endregion

    // region Getters & Setters

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

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
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

    public Set<EBookLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<EBookLanguage> languages) {
        this.languages = languages;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Translator> getTranslators() {
        return translators;
    }

    public void setTranslators(Set<Translator> translators) {
        this.translators = translators;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    // endregion
}
