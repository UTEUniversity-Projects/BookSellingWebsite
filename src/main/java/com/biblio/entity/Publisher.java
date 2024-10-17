package com.biblio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "publisher")
public class Publisher extends ContributorProfile implements Serializable {

    // region Constructors

    public Publisher() {
        super();
    }

    public Publisher(Long id, String name, String introduction, Timestamp joinAt) {
        super(id, name, introduction, joinAt);
    }

    // endregion
}
