package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public abstract class ContributorProfile implements Serializable {

    // region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(255)")
    private String name;

    @Column(name = "introduction", nullable = false, columnDefinition = "nvarchar(255)")
    private String introduction;

    @Column(name = "joinAt", nullable = false, columnDefinition = "datetime")
    private Timestamp joinAt;
    // endregion

    // region Constructors

    public ContributorProfile() {}

    public ContributorProfile(Long id, String name, String introduction, Timestamp joinAt) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.joinAt = joinAt;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Timestamp getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(Timestamp joinAt) {
        this.joinAt = joinAt;
    }

    // endregion
}
