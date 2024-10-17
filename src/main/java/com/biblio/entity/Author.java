package com.biblio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "author")
public class Author extends ContributorProfile implements Serializable {

    // region Constructors

    public Author() {
        super();
    }

    public Author(Long id, String name, String introduction, Timestamp joinAt) {
        super(id, name, introduction, joinAt);
    }

    // endregion Constructors
}
