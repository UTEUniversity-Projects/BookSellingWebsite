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
    private Set<Book> books = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar_id", nullable = false)
    private MediaFile avatar;

    // endregion

    // region Constructors

    public Translator() {
        super();
    }

    public Translator(Long id, String name, String introduction, LocalDateTime joinAt) {
        super(id, name, introduction, joinAt);
    }

    // endregion

    // region Getters & Setters

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public MediaFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MediaFile avatar) {
        this.avatar = avatar;
    }


    // endregion
}
