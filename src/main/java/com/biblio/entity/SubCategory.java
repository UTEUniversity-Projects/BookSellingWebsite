package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sub_category")
public class SubCategory extends Classification implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "subCategory")
    private Set<Book> books;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // endregion

    // region Constructors

    public SubCategory() {
        super();
    }

    public SubCategory(Long id, String code, String name) {
        super(id, code, name);
    }

    // endregion

    // region Getters & Setters

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    // endregion

}
