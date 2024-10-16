package com.biblio.entity;

import java.io.Serializable;

public class SubCategory extends Classification implements Serializable {
    //region Attributes
    private Category category;
    //endregion

    //region Constructors
    public SubCategory() {
        super();
    }

    public SubCategory(Long id, String code, String name, Category category) {
        super(id, code, name);
        this.category = category;
    }
    //endregion

    //region Getters & Setters
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    //endregion
}
