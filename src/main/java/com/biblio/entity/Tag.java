package com.biblio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
@NoArgsConstructor
@Getter
@Setter
public class Tag extends Classification implements Serializable {

    // region Relationships

    @ManyToMany(mappedBy = "tags")
    private Set<BookMetadata> metadatas = new HashSet<BookMetadata>();

    // endregion

}
