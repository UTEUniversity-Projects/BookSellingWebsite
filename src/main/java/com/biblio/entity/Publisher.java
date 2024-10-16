package com.biblio.entity;

import java.io.Serializable;
import java.util.Date;

public class Publisher extends ContributorProfile implements Serializable {
    //region Constructors
    public Publisher() {
        super();
    }

    public Publisher(Long id, String name, MediaFile avatar, Date joinAt, String introduction) {
        super(id, name, avatar, joinAt, introduction);
    }
    //endregion
}
