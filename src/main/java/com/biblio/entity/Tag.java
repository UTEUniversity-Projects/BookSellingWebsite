package com.biblio.entity;

import java.io.Serializable;

public class Tag extends Classification implements Serializable {
    public Tag() {
        super();
    }

    public Tag(String id, String code, String name) {
        super(id, code, name);
    }
}
