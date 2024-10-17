package com.biblio.entity;

import com.biblio.enumeration.ENotificationStatus;
import com.biblio.enumeration.ENotificationType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notification")
public class Notification implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Timestamp createdAt;

    @Column(name = "sent_time", nullable = false, columnDefinition = "datetime")
    private Timestamp sentTime;

    @Column(name = "title", nullable = false, columnDefinition = "nvarchar(255)")
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "nvarchar(255)")
    private String content;

    @Column(name = "hyper_link", nullable = false, columnDefinition = "nvarchar(255)")
    private String hyperlink;

    @Column(name = "type", nullable = false, columnDefinition = "nvarchar(255)")
    private ENotificationType type;

    @Column(name = "status", nullable = false, columnDefinition = "nvarchar(255)")
    private String status;

    //endregion

    // region Constructors

    public Notification() {
    }

    public Notification(Long id, Timestamp createdAt, Timestamp sentTime, String title, String content, String hyperlink, ENotificationType type, String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.sentTime = sentTime;
        this.title = title;
        this.content = content;
        this.hyperlink = hyperlink;
        this.type = type;
        this.status = status;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getSentTime() {
        return sentTime;
    }

    public void setSentTime(Timestamp sentTime) {
        this.sentTime = sentTime;
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

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public ENotificationType getType() {
        return type;
    }

    public void setType(ENotificationType type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // endregion
}
