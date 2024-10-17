package com.biblio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "category")
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
