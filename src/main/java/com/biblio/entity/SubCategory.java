package com.biblio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sub_category")
public class SubCategory extends Classification implements Serializable {

    //region Attributes

    //endregion

    //region Constructors

    public SubCategory() {
        super();
    }

    public SubCategory(Long id, String code, String name) {
        super(id, code, name);
    }

    //endregion

    //region Getters & Setters

    //endregion
}
