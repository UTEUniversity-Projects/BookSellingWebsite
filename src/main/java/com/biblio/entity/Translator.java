package com.biblio.entity;

import java.io.Serializable;
import java.util.Date;

public class Translator extends ContributorProfile implements Serializable {
    public Translator() {
        super();
    }

    public Translator(String id, String name, MediaFile avatar, Date joinAt, String introduction) {
        super(id, name, avatar, joinAt, introduction);
    }
}
