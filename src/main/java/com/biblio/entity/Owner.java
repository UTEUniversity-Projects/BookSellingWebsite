package com.biblio.entity;

import com.biblio.enumeration.EGender;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "owner")
public class Owner extends User implements Serializable {

    //region Constructors

    public Owner() {
        super();
    }

    public Owner(Long id, String username, String fullName, String password, String emailAddress, String dateOfBirth, String gender, String phoneNumber, Timestamp joinAt) {
        super(id, username, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, joinAt);
    }

    //endregion
}
