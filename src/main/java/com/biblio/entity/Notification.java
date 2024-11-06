package com.biblio.entity;

import com.biblio.enumeration.ENotificationStatus;
import com.biblio.enumeration.ENotificationType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notification")
public class Notification implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "sent_time", nullable = false)
    private LocalDateTime sentTime;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "hyper_link", nullable = false)
    private String hyperlink;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ENotificationType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ENotificationStatus status;

    //endregion

    // region Relationships

    @ManyToMany(mappedBy = "notifications")
    private Set<Customer> customers = new HashSet<Customer>();

    @ManyToMany(mappedBy = "notifications")
    private Set<Staff> staff = new HashSet<Staff>();

    @ManyToMany(mappedBy = "notifications")
    private Set<Owner> owner = new HashSet<Owner>();

    // endregion

    // region Constructors

    public Notification() {
    }

    public Notification(String id, LocalDateTime createdAt, LocalDateTime sentTime, String title, String content, String hyperlink, ENotificationType type, ENotificationStatus status) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
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

    public ENotificationStatus getStatus() {
        return status;
    }

    public void setStatus(ENotificationStatus status) {
        this.status = status;
    }

    // endregion
}
