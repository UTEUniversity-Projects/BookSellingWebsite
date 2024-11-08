package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class ContributorProfile implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "introduction", nullable = false)
    protected String introduction;

    @Column(name = "join_at", nullable = false)
    protected LocalDateTime joinAt;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    // endregion

    // region Relationships

    // endregion

    // region Constructors

    public ContributorProfile() {
    }

    public ContributorProfile(Long id, String name, String introduction, LocalDateTime joinAt, String avatar) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.joinAt = joinAt;
        this.avatar = avatar;
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

    public LocalDateTime getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(LocalDateTime joinAt) {
        this.joinAt = joinAt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // endregion
}
