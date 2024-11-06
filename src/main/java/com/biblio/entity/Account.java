package com.biblio.entity;

import com.biblio.enumeration.EUserRole;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Account(Long id, String username, String password, EUserRole userRole, Customer customer, Staff staff, Owner owner) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.customer = customer;
        this.staff = staff;
        this.owner = owner;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public EUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(EUserRole userRole) {
        this.userRole = userRole;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    // endregion
}
