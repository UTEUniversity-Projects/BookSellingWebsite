package com.biblio.entity;

import com.biblio.enumeration.EGender;

import java.io.Serializable;
import java.util.Date;

public class Staff extends User implements Serializable {
    public Staff() {
        super();
    }

    public Staff(String id, String userName, String fullName, String password, String emailAddress, String dateOfBirth, EGender gender, String phoneNumber, MediaFile avatar, Date joinAt) {
        super(id, userName, fullName, password, emailAddress, dateOfBirth, gender, phoneNumber, avatar, joinAt);
    }
}
