package com.biblio.entity;

import java.io.Serializable;
import java.util.Date;

public class Translator extends ContributorProfile implements Serializable {

    //region Constructors
    public Translator() {
        super();
    }

    public Translator(Long id, String name, MediaFile avatar, Date joinAt, String introduction) {
        super(id, name, avatar, joinAt, introduction);
    }
    //endregion
}
