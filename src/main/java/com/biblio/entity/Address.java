package com.biblio.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "nation", nullable = false)
    private String nation;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "village", nullable = false)
    private String village;

    @Column(name = "detail", nullable = false)
    private String detail;

    // endregion

    // region Relationships

    @OneToOne(mappedBy = "address")
    private Order order;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> customers = new HashSet<Customer>();

    @ManyToMany(mappedBy = "addresses")
    private Set<Staff> staffs = new HashSet<Staff>();

    @ManyToMany(mappedBy = "addresses")
    private Set<Owner> owners = new HashSet<Owner>();

    // endregion

    // region Constructors

    public Address() {}

    public Address(String id, String nation, String province, String district, String village, String detail) {
        this.id = id;
        this.nation = nation;
        this.province = province;
        this.district = district;
        this.village = village;
        this.detail = detail;
    }

    // endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

    // endregion
}
