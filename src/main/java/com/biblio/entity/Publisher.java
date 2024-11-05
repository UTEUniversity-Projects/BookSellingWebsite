package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher extends ContributorProfile implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<Book>();

    // endregion

    // region Constructors

    public Publisher() {
        super();
    }

    public Publisher(String id, String name, String introduction, LocalDateTime joinAt, String avatar, Set<Book> books) {
        super(id, name, introduction, joinAt, avatar);
        this.books = books;
    }

    // region Getters & Setters

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    // endregion
}
