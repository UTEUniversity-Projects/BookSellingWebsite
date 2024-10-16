package com.biblio.entity;

import com.biblio.enumeration.ENotificationStatus;
import com.biblio.enumeration.ENotificationType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Notification implements Serializable {
    //region Attributes
    private Long id;
    private Date createdAt;
    private Date sentTime;
    private List<User> receiver;
    private String title;
    private String content;
    private String hyperlink;
    private ENotificationType type;
    private ENotificationStatus status;
    //endregion

    //region Contructors
    public Notification(Long id, Date createdAt, Date sentTime, List<User> receiver, String title, String content, String hyperlink, ENotificationType type, ENotificationStatus status) {
        this.id = id;
        this.createdAt = createdAt;
        this.sentTime = sentTime;
        this.receiver = receiver;
        this.title = title;
        this.content = content;
        this.hyperlink = hyperlink;
        this.type = type;
        this.status = status;
    }
    //endregion

    //region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public List<User> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<User> receiver) {
        this.receiver = receiver;
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

    public ENotificationStatus getStatus() {
        return status;
    }

    public void setStatus(ENotificationStatus status) {
        this.status = status;
    }

    //endregion
}
