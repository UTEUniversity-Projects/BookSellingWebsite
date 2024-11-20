package com.biblio.entity;

import com.biblio.enumeration.EBookLanguage;
import com.biblio.enumeration.EBookTemplateStatus;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "book_template")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookTemplate {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EBookTemplateStatus status;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "book_template_languages",
            joinColumns = @JoinColumn(name = "book_template_id", nullable = false))
    @Column(name = "language", nullable = false)
    private Set<EBookLanguage> languages = new HashSet<>();

    // endregion

    // region Relationships

    @ManyToMany(mappedBy = "bookTemplates", fetch = FetchType.LAZY)
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(mappedBy = "bookTemplates", fetch = FetchType.LAZY)
    private Set<Translator> translators = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @OneToMany(mappedBy = "bookTemplate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MediaFile> mediaFiles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "bookTemplate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    @OneToMany(mappedBy = "bookTemplate", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new HashSet<>();

    @OneToMany(mappedBy = "bookTemplate", fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();

    // endregion

    // region Methods

    public double calculateReviewRate() {
        if (reviews == null || reviews.isEmpty()) {
            return 0;
        }

        return reviews.stream()
                .filter(review -> !review.isHidden())
                .mapToDouble(Review::getRate)
                .average()
                .orElse(0);
    }

    // endregion

}
