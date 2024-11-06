package com.biblio.entity;

import org.hibernate.annotations.GenericGenerator;

import com.biblio.enumeration.EUserRole;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    // region Attributes

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private EUserRole userRole;

    // endregion

    // region Relationships

    @OneToOne(mappedBy = "account")
    private Customer customer;

    @OneToOne(mappedBy = "account")
    private Staff staff;

    @OneToOne(mappedBy = "account")
    private Owner owner;

    // endregion

    // region Constructors

    public Account() {
    }
    
    public Account(String id, String username, String password, EUserRole userRole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	// endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // endregion
}
