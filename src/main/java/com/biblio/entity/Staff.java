package com.biblio.entity;

import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EUserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff extends User implements Serializable {

    // region Relationships

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "staff_address",
            joinColumns = @JoinColumn(name = "staff_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "address_id", nullable = false))
    private Set<Address> addresses;

    @OneToMany(mappedBy = "staff")
    private Set<Support> supports = new HashSet<Support>();

    @ManyToMany(mappedBy = "staffs")
    private Set<Notification> notifications = new HashSet<Notification>();

    // endregion

    // region Constructors

    public Staff() {
        super();
    }

    public Staff(String id, String username, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt, EUserRole role) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt, role);
    }

    // endregion

    // region Getters & Setters

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

    // endregion
}
