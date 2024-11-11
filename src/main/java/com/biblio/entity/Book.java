package com.biblio.entity;

import com.biblio.enumeration.EBookAgeRecommend;
import com.biblio.enumeration.EBookCondition;
import com.biblio.enumeration.EBookFormat;
import com.biblio.enumeration.EBookLanguage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Getter
@Setter
public class Book implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description", nullable = false, columnDefinition = "longtext")
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
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "book_languages",
            joinColumns = @JoinColumn(name = "book_id", nullable = false))
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

    // endregion

    // region Relationships

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
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
}
