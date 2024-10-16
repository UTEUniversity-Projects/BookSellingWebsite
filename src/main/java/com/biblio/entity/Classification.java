package com.biblio.entity;

import java.io.Serializable;

public abstract class Classification implements Serializable {

    //region Attributes
    private Long id;
    private String code;
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
