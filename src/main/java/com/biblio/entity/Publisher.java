package com.biblio.entity;

import java.io.Serializable;
import java.util.Date;

public class Publisher extends ContributorProfile implements Serializable {
    public Publisher() {
        super();
    }

    public Publisher(String id, String name, MediaFile avatar, Date joinAt, String introduction) {
        super(id, name, avatar, joinAt, introduction);
    }
}
