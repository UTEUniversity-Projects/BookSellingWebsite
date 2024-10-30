package com.biblio.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "site_content")
public class SiteContent {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_effective", nullable = false)
    private boolean isEffective;

    // endregion

    // region Constructors

    public SiteContent() {
    }

    public SiteContent(String id, String title, String content, boolean isEffective) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isEffective = isEffective;
    }

    // endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEffective() {
        return isEffective;
    }

    public void setEffective(boolean effective) {
        isEffective = effective;
    }

    // endregion
}
