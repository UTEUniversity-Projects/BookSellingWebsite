package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author extends ContributorProfile implements Serializable {

    // region Relationships

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "book_id", nullable = false))
    private Set<Book> books = new HashSet<Book>();

    // endregion

    // region Constructors

    public Author() {
    }

    public Author(String id, String name, String introduction, LocalDateTime joinAt, String avatar, Set<Book> books) {
        super(id, name, introduction, joinAt, avatar);
        this.books = books;
    }

    // endregion Getters & Setters

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    // endregion Constructors
}
