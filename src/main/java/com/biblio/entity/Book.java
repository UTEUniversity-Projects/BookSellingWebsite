package com.biblio.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "nvarchar(255)")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "nvarchar(255)")
    private String description;

    @Column(name = "selling_price", nullable = false)
    private double sellingPrice;

    @Column(name = "publication_date", nullable = false, columnDefinition = "datetime")
    private Timestamp publicationDate;

    @Column(name = "edition", nullable = false)
    private int edition;

    @Column(name = "code_ISBN10", nullable = false, columnDefinition = "nvarchar(255)")
    private String codeISBN10;

    @Column(name = "code_ISBN13", nullable = false, columnDefinition = "nvarchar(255)")
    private String codeISBN13;

    @Column(name = "format", nullable = false, columnDefinition = "nvarchar(255)")
    private String format;

    @Column(name = "hand_cover", nullable = false)
    private int handcover;

    @Column(name = "length", nullable = false)
    private double length;

    @Column(name = "width", nullable = false)
    private double width;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "[condition]", nullable = false, columnDefinition = "nvarchar(255)")
    private String condition;

    @Column(name = "recommended_age", nullable = false, columnDefinition = "nvarchar(255)")
    private String recommendedAge;

    // endregion Attributes

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private BookMetadata metadata;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id", nullable = false, referencedColumnName = "id")
    private SubCategory subCategory;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false, referencedColumnName = "id")
    private Publisher publisher;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false, referencedColumnName = "id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "translator_id", nullable = false, referencedColumnName = "id")
    private Translator translator;

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "book")
    private Set<OrderItem> orderItems;

    // endregion

    // region Constructors

    public Book() {
    }

    public Book(Long id, String title, String description, double sellingPrice, Timestamp publicationDate, int edition, String codeISBN10, String codeISBN13, String format, int handcover, double length, double width, double height, double weight, String condition, String recommendedAge) {
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
        this.weight = weight;
        this.condition = condition;
        this.recommendedAge = recommendedAge;
    }

    // endregion Constructors

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(String recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    // endregion Getters & Setters
}
