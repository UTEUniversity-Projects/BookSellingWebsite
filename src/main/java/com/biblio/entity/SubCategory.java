package com.biblio.entity;

import java.io.Serializable;

public class SubCategory extends Classification implements Serializable {
    private Category category;

    public SubCategory() {
        super();
    }

    public SubCategory(String id, String code, String name, Category category) {
        super(id, code, name);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
