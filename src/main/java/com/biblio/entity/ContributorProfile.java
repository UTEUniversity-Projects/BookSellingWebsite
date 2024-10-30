package com.biblio.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ContributorProfile implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "introduction", nullable = false)
    private String introduction;

    @Column(name = "join_at", nullable = false)
    private LocalDateTime joinAt;

    // endregion

    // region Constructors

    public ContributorProfile() {
    }

    public ContributorProfile(String id, String name, String introduction, LocalDateTime joinAt) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.joinAt = joinAt;
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

    // endregion
}
