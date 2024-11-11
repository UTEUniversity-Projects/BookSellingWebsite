package com.biblio.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "translator")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Translator extends ContributorProfile implements Serializable {

    // region Relationships

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "translator_book",
                joinColumns = @JoinColumn(name = "translator_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "book_id", nullable = false))
    private Set<Book> books = new HashSet<Book>();

    // endregion

}
