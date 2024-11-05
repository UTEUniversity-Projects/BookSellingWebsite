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
    private Set<User> users = new HashSet<User>();

    // endregion

    // region Constructors

    public Address() {}

    public Address(String id, String nation, String province, String district, String village, String detail, Order order, Set<User> users) {
        this.id = id;
        this.nation = nation;
        this.province = province;
        this.district = district;
        this.village = village;
        this.detail = detail;
        this.order = order;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // endregion
}
