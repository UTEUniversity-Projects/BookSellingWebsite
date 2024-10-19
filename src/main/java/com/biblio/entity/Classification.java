package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Classification implements Serializable {

    //region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, columnDefinition = "nvarchar(255)")
    private String code;

    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(255)")
    private String name;

    //endregion

    //region Constructors
    public Classification() {}

    public Classification(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    //endregion

    //region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion
}
