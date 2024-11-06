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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "owner_notification",
            joinColumns = @JoinColumn(name = "owner_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "notification_id", nullable = false))
    private Set<Notification> notifications = new HashSet<Notification>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "owner_address",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses;

    public Set<Address> getAddresses() {
        return addresses;
    }

    // endregion

    // region Constructors

    public Owner() {
        super();
    }

    public Owner(Long id, String fullName, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt, Account account, Set<Notification> notifications, Set<Address> addresses) {
        super(id, fullName, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt);
        this.account = account;
        this.notifications = notifications;
        this.addresses = addresses;
    }

    // endregion

    // region Getters & Setters

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    // endregion
}
