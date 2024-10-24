package com.biblio.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag extends Classification implements Serializable {

    // region Relationships

    @ManyToMany(mappedBy = "tags")
    private Set<BookMetadata> metadatas;

    // endregion

    // region Constructors

    public Tag() {
        super();
    }

    public Tag(Long id, String code, String name) {
        super(id, code, name);
    }

    // endregion Constructors

    // region Getters & Setters

    public Set<BookMetadata> getMetadatas() {
        return metadatas;
    }

    public void setMetadatas(Set<BookMetadata> metadatas) {
        this.metadatas = metadatas;
    }

    // endregion
}
