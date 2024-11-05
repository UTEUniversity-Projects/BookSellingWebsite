package com.biblio.entity;

import com.biblio.enumeration.EGender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    protected String id;

    @Column(name = "full_name", nullable = false)
    protected String fullName;

    @Column(name = "email_address", nullable = false)
    protected String emailAddress;

    @Column(name = "date_of_birth", nullable = false)
    protected String dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    protected EGender gender;

    @Column(name = "phone_number", nullable = false)
    protected String phoneNumber;

    @Column(name = "avatar", nullable = false)
    protected String avatar;

    @Column(name = "join_at", nullable = false)
    protected LocalDateTime joinAt;

    // endregion

    // region Relationships

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "address_id", nullable = false))
    private Set<Address> addresses = new HashSet<Address>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_notification",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "notification_id"))
    private Set<Notification> notifications = new HashSet<Notification>();

    // endregion

    // region Constructors

    public User() {
    }

    public User(String id, String fullName, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt, Account account, Set<Address> addresses, Set<Notification> notifications) {
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.joinAt = joinAt;
        this.account = account;
        this.addresses = addresses;
        this.notifications = notifications;
    }

    // endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(LocalDateTime joinAt) {
        this.joinAt = joinAt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }


    // endregion
}
