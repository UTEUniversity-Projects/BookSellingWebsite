package com.biblio.entity;

import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EUserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends User implements Serializable {

    // region Relationships

    // endregion

    // region Constructors

    public Owner() {
        super();
    }

    public Owner(String id, String fullName, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, String avatar, LocalDateTime joinAt, Account account, Set<Address> addresses, Set<Notification> notifications) {
        super(id, fullName, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt, account, addresses, notifications);
    }

    // endregion

    // region Getters & Setters

    // endregion
}
