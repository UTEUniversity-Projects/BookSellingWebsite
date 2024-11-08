package com.biblio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sub_category")
@NoArgsConstructor
@Getter
@Setter
public class SubCategory extends Classification implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "subCategory")
    private Set<Book> books = new HashSet<Book>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // endregion

}
