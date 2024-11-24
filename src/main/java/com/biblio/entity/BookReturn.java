package com.biblio.entity;

import com.biblio.enumeration.EReasonReturn;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_return")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookReturn implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(name = "reason", nullable = false)
    private EReasonReturn reason;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    // endregion

    // region Relationships

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @OneToMany(mappedBy = "bookReturn", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReturnItem> returnItems = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MediaFile> proofs = new HashSet<>();

    // endregion
}
