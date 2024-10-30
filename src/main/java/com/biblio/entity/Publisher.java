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

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "avatar_id", nullable = false)
   private MediaFile avatar;

    // endregion

    // region Constructors

    public Publisher() {
        super();
    }

    public Publisher(String id, String name, String introduction, LocalDateTime joinAt) {
        super(id, name, introduction, joinAt);
    }

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
