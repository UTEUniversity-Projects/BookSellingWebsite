package com.biblio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tag")
public class Tag extends Classification implements Serializable {

    // region Constructors
    public Tag() {
        super();
    }

    public Tag(Long id, String code, String name) {
        super(id, code, name);
    }
    // endregion
}
