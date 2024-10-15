package com.biblio.entity;

import java.io.Serializable;

public class Category extends Classification implements Serializable {
    public Category() {
        super();
    }

    public Category(String id, String code, String name) {
        super(id, code, name);
    }
}
