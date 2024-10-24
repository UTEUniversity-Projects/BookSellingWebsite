package com.biblio.entity;

import com.biblio.enumeration.EGender;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff extends User implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "staff")
    private Set<Support> supports;

    @ManyToMany(mappedBy = "staffs")
    private Set<Notification> notifications;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "media_file_id")
    private MediaFile avatar;

    // endregion

    // region Constructors

    public Staff() {
        super();
    }

    public Staff(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, LocalDateTime joinAt) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, joinAt);
    }

    public Set<Support> getSupports() {
        return supports;
    }

    public void setSupports(Set<Support> supports) {
        this.supports = supports;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public MediaFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MediaFile avatar) {
        this.avatar = avatar;
    }

    // endregion
}
