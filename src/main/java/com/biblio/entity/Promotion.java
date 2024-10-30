package com.biblio.entity;

import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promotion")
public class Promotion implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "effective_date", nullable = false)
    private LocalDateTime effectiveDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "percent_discount", nullable = false)
    private double percentDiscount;

    @Column(name = "discount_limit", nullable = false)
    private double discountLimit;

    @Column(name = "min_value_to_be_applied", nullable = false)
    private double minValueToBeApplied;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EPromotionType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EPromotionStatus status;

    // endregion

    // region Relationships

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "promotion_promotion_target",
            joinColumns = @JoinColumn(name = "promotion_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "promotion_target_id", nullable = false))
    private Set<PromotionTarget> promotionTargets = new HashSet<PromotionTarget>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // endregion

    // region Constructors

    public Promotion() {
    }

    public Promotion(String id, LocalDateTime createdAt, String code, LocalDateTime effectiveDate, LocalDateTime expirationDate, String title, String description, double percentDiscount, double discountLimit, double minValueToBeApplied, EPromotionType type, EPromotionStatus status) {
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

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
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

    public EPromotionType getType() {
        return type;
    }

    public void setType(EPromotionType type) {
        this.type = type;
    }

    public EPromotionStatus getStatus() {
        return status;
    }

    public void setStatus(EPromotionStatus status) {
        this.status = status;
    }

    public Set<PromotionTarget> getPromotionTargets() {
        return promotionTargets;
    }

    public void setPromotionTargets(Set<PromotionTarget> promotionTargets) {
        this.promotionTargets = promotionTargets;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // endregion
}
