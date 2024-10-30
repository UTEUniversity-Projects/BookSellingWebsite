package com.biblio.entity;

import com.biblio.enumeration.EGender;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends User implements Serializable {

    // region Relationships

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "owner_address",
            joinColumns = @JoinColumn(name = "owner_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "address_id", nullable = false))
    private Set<Address> addresses; 

    @ManyToMany(mappedBy = "owners")
    private Set<Notification> notifications = new HashSet<Notification>();

    // endregion

    // region Constructors

    public Owner() {
        super();
    }

    public Owner(String id, String username, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt);
    }

    // endregion

    // region Getters & Setters

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    // endregion
}
