package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author extends ContributorProfile implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar_id", nullable = false, referencedColumnName = "id")
    private MediaFile avatar;

    // endregion

    // region Constructors

    public Author() {
        super();
    }

    public Author(Long id, String name, String introduction, Timestamp joinAt) {
        super(id, name, introduction, joinAt);
    }

    // endregion Constructors
}
