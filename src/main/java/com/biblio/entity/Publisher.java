package com.biblio.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Publisher extends ContributorProfile implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<Book>();

    // endregion
}
