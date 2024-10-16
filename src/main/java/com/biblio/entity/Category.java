package com.biblio.entity;

import java.io.Serializable;

public class Category extends Classification implements Serializable {

    //region Constructors
    public Category() {
        super();
    }

    public Category(Long id, String code, String name) {
        super(id, code, name);
    }
    //endregion
}
