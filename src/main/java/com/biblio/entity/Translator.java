package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "translator")
public class Translator extends ContributorProfile implements Serializable {

    // region Relationships

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "translator_book",
                joinColumns = @JoinColumn(name = "translator_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "book_id", nullable = false))
    private Set<Book> books = new HashSet<Book>();

    // endregion

    // region Constructors

    public Translator() {
        super();
    }

    public Translator(String id, String name, String introduction, LocalDateTime joinAt, String avatar, Set<Book> books) {
        super(id, name, introduction, joinAt, avatar);
        this.books = books;
    }

    // endregion

    // region Getters & Setters

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }


    // endregion
}
