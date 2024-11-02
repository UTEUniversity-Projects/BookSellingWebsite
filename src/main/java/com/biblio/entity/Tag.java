package com.biblio.entity;

import com.biblio.enumeration.EClassificationStatus;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag extends Classification implements Serializable {

    // region Relationships

    @ManyToMany(mappedBy = "tags")
    private Set<BookMetadata> metadatas = new HashSet<BookMetadata>();

    // endregion

    // region Constructors

    public Tag() {
        super();
    }

    public Tag(String id, String name, String shortScript, String fullScript, EClassificationStatus status) {
        super(id, name, shortScript, fullScript, status);
    }

    // endregion

    // region Getters & Setters

    public Set<BookMetadata> getMetadatas() {
        return metadatas;
    }

    public void setMetadatas(Set<BookMetadata> metadatas) {
        this.metadatas = metadatas;
    }

    // endregion
}
