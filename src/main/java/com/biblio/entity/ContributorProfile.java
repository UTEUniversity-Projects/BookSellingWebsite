package com.biblio.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class ContributorProfile implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    protected String id;

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

    public ContributorProfile(String id, String name, String introduction, LocalDateTime joinAt, String avatar) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.joinAt = joinAt;
        this.avatar = avatar;
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
