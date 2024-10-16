package com.biblio.entity;

import java.io.Serializable;
import java.util.Date;

public class Author extends ContributorProfile implements Serializable {

    // region Constructors

    public Author() {}

    public Author(Long id, String name, MediaFile avatar, Date joinAt, String introduction) {
        super(id, name, avatar, joinAt, introduction);
    }

    // endregion Constructors
}
