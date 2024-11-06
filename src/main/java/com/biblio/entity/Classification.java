package com.biblio.entity;

import com.biblio.enumeration.EClassificationStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Classification implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    protected String id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "short_script", nullable = false)
    protected String shortScript;

    @Column(name = "full_script", nullable = false)
    protected String fullScript;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    protected EClassificationStatus status;

    // endregion

    // region Constructors

    public Classification() {}

    public Classification(String id, String name, String shortScript, String fullScript, EClassificationStatus status) {
        this.id = id;
        this.name = name;
        this.shortScript = shortScript;
        this.fullScript = fullScript;
        this.status = status;
    }

    // endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortScript() {
        return shortScript;
    }

    public void setShortScript(String shortScript) {
        this.shortScript = shortScript;
    }

    public String getFullScript() {
        return fullScript;
    }

    public void setFullScript(String fullScript) {
        this.fullScript = fullScript;
    }

    public EClassificationStatus getStatus() {
        return status;
    }

    public void setStatus(EClassificationStatus status) {
        this.status = status;
    }

    // endregion
}
