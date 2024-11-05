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

    @OneToMany(mappedBy = "staff")
    private Set<Support> supports = new HashSet<Support>();

    // endregion

    // region Constructors

    public Staff() {
        super();
    }

    public Staff(String id, String fullName, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt, Account account, Set<Address> addresses, Set<Notification> notifications, Set<Support> supports) {
        super(id, fullName, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt, account, addresses, notifications);
        this.supports = supports;
    }

    // endregion

    // region Getters & Setters

    public Set<Support> getSupports() {
        return supports;
    }

    public void setSupports(Set<Support> supports) {
        this.supports = supports;
    }

    // endregion
}
