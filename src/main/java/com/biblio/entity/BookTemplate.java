package com.biblio.entity;

import com.biblio.enumeration.EBookTemplateStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_template")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EBookTemplateStatus status;

    @Column(name = "opening_date", nullable = false)
    private LocalDateTime openingDate;

    @ManyToMany(mappedBy = "bookTemplates", fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(mappedBy = "bookTemplates")
    private Set<Translator> translators = new HashSet<>();

    @OneToMany(mappedBy = "bookTemplate", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MediaFile> mediaFiles = new HashSet<>();

    @OneToMany(mappedBy = "bookTemplate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    @ManyToMany(mappedBy = "bookTemplates")
    private Set<Cart> carts = new HashSet<>();

    @OneToMany(mappedBy = "bookTemplate", fetch = FetchType.EAGER)
    private Set<Review> reviews = new HashSet<>();

    // region Methods
    public double calculateReviewRate() {
        if (reviews == null || reviews.isEmpty()) {
            return 0;
        }

        double totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRate();
        }

        return totalRating / reviews.size();
    }
    // endregion
}
