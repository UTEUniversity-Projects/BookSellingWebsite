package com.biblio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Address> addresses;

    // endregion

}
