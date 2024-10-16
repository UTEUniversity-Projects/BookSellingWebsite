package com.biblio.entity;

import java.io.Serializable;

public class Tag extends Classification implements Serializable {
    //region Constructors
    public Tag() {
        super();
    }

    public Tag(Long id, String code, String name) {
        super(id, code, name);
    }
    //endregion
}
