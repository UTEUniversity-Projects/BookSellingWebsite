package com.biblio.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category extends Classification implements Serializable {


    // region Relationships

    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<Book>();

    @OneToMany(mappedBy = "category")
    private Set<SubCategory> subCategories;

    // endregion

    // region Constructors

    public Category() {
        super();
    }

    public Category(Long id, String code, String name) {
        super(id, code, name);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    // endregion
}
