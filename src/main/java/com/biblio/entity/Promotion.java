package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "promotion")
public class Promotion implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Timestamp createdAt;

    @Column(name = "code", nullable = false, columnDefinition = "nvarchar(255)")
    private String code;

    @Column(name = "effective_date", nullable = false, columnDefinition = "datetime")
    private Timestamp effectiveDate;

    @Column(name = "expiration_date", nullable = false, columnDefinition = "datetime")
    private Timestamp expirationDate;

    @Column(name = "title", nullable = false, columnDefinition = "nvarchar(255)")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "nvarchar(255)")
    private String description;

    @Column(name = "percent_discount", nullable = false)
    private double percentDiscount;

    @Column(name = "discount_limit", nullable = false)
    private double discountLimit;

    @Column(name = "min_value_to_be_applied", nullable = false)
    private double minValueToBeApplied;

    @Column(name = "type", nullable = false, columnDefinition = "nvarchar(255)")
    private String type;

    @Column(name = "status", nullable = false, columnDefinition = "nvarchar(255)")
    private String status;

    // endregion

    // region Relationships

    @OneToMany(mappedBy = "promotion")
    private Set<PromotionTarget> promotionTargets;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "id")
    private Order order;

    // endregion

    // region Constructors

    public Promotion() {
    }

    public Promotion(Long id, Timestamp createdAt, String code, Timestamp effectiveDate, Timestamp expirationDate, String title, String description, double percentDiscount, double discountLimit, double minValueToBeApplied, String type, String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.code = code;
        this.effectiveDate = effectiveDate;
        this.expirationDate = expirationDate;
        this.title = title;
        this.description = description;
        this.percentDiscount = percentDiscount;
        this.discountLimit = discountLimit;
        this.minValueToBeApplied = minValueToBeApplied;
        this.type = type;
        this.status = status;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public double getDiscountLimit() {
        return discountLimit;
    }

    public void setDiscountLimit(double discountLimit) {
        this.discountLimit = discountLimit;
    }

    public double getMinValueToBeApplied() {
        return minValueToBeApplied;
    }

    public void setMinValueToBeApplied(double minValueToBeApplied) {
        this.minValueToBeApplied = minValueToBeApplied;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // endregion
}
