package com.biblio.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class ContributorProfile implements Serializable {
    private Long id;
    private String name;
    private MediaFile avatar;
    private String introduction;
    private Date joinAt;

    public ContributorProfile() {
    }

    public ContributorProfile(Long id, String name, MediaFile avatar, Date joinAt, String introduction) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.joinAt = joinAt;
        this.introduction = introduction;
    }

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

    public MediaFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MediaFile avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(Date joinAt) {
        this.joinAt = joinAt;
    }
}
