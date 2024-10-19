package com.biblio.entity;

import com.biblio.enumeration.EGender;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends User implements Serializable {

    // region Relationships

    @ManyToMany(mappedBy = "owners")
    private Set<Notification> notifications;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "media_file_id")
    private MediaFile avatar;

    // endregion

    //region Constructors

    public Owner() {
        super();
    }

    public Owner(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, String gender, String phoneNumber, Timestamp joinAt) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, joinAt);
    }

    //endregion
}
