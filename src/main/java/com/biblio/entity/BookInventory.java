package com.biblio.entity;

import com.biblio.enumeration.EBookInventoryStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_inventory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EBookInventoryStatus status;

    @Column(name = "opening_date", nullable = false)
    private LocalDateTime openingDate;

    @OneToMany(mappedBy = "bookInventory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MediaFile> mediaFiles = new HashSet<>();

    @OneToMany(mappedBy = "bookInventory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    @ManyToMany(mappedBy = "bookInventories")
    private Set<Cart> carts;

}
