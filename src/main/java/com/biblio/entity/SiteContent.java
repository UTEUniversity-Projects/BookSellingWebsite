package com.biblio.entity;

import javax.persistence.*;

@Entity
@Table(name = "site_content")
public class SiteContent {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public SiteContent(Long id, String title, String content, boolean isEffective) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isEffective = isEffective;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
