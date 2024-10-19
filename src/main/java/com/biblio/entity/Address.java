package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    // region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nation", nullable = false, columnDefinition = "nvarchar(255)")
    private String nation;

    @Column(name = "province", nullable = false, columnDefinition = "nvarchar(255)")
    private String province;

    @Column(name = "district", nullable = false, columnDefinition = "nvarchar(255)")
    private String district;

    @Column(name = "village", nullable = false, columnDefinition = "nvarchar(255)")
    private String village;

    @Column(name = "detail", nullable = false, columnDefinition = "nvarchar(255)")
    private String detail;
    // endregion

    // region Relationships
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    @OneToOne(mappedBy = "address")
    private Order order;
    // endregion

    // region Constructors
    public Address() {}

    public Address(String nation, String province, String district, String village, String detail) {
        this.nation = nation;
        this.province = province;
        this.district = district;
        this.village = village;
        this.detail = detail;
    }
    // endregion

    // region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    // endregion
}
