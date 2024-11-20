package com.biblio.entity;

import com.biblio.enumeration.EBookTemplateStatus;
import com.biblio.enumeration.EReasonReturn;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "return_book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReturnBook implements Serializable {
    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason", nullable = false)
    private EReasonReturn reason;

    @Lob
    @Column(name = "description", nullable = false, columnDefinition = "longtext")
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // endregion

    // region Relationships

    @OneToMany(mappedBy = "returnBook", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<LineItem> lineItems = new HashSet<>();

    @OneToMany
    @JoinTable(
            name = "return_boook_media_file",
            joinColumns = @JoinColumn(name = "book_template_id"),
            inverseJoinColumns = @JoinColumn(name = "media_file_id")
    )
    private List<MediaFile> proof = new ArrayList<>();

    // endregion
}