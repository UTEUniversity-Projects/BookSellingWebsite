package com.biblio.entity;

import com.biblio.enumeration.EGender;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "staff")
public class Staff extends User implements Serializable {

    // region Constructors

    public Staff() {
        super();
    }

    public Staff(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, String gender, String phoneNumber, Timestamp joinAt) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, joinAt);
    }

    // endregion
}
