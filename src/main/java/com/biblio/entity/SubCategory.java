package com.biblio.entity;

import com.biblio.enumeration.EClassificationStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sub_category")
public class SubCategory extends Classification implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "subCategory")
    private Set<Book> books = new HashSet<Book>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // endregion

    // region Constructors

    public SubCategory() {
        super();
    }

    public SubCategory(String id, String name, String shortScript, String fullScript, EClassificationStatus status, Set<Book> books, Category category) {
        super(id, name, shortScript, fullScript, status);
        this.books = books;
        this.category = category;
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
