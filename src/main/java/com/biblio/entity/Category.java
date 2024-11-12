package com.biblio.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Classification implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<Book>();

    @OneToMany(mappedBy = "category")
    private Set<SubCategory> subCategories;

    // endregion
}
