package com.biblio.entity;

import com.biblio.enumeration.EPromotionStatus;
import com.biblio.enumeration.EPromotionType;

import java.io.Serializable;
import java.sql.Date;

public class Promotion implements Serializable {
    //region Attributes
    private Long id;
    private Date createdAt; // Using LocalDateTime for date and time
    private String code;
    private Date effectiveDate; // Effective date of promotion
    private Date expirationDate; // Expiration date of promotion
    private String title;
    private String description;
    private double percentDiscount;
    private double discountLimit;
    private double minValueToBeApplied;
    private EPromotionType type; // Enum for promotion type
    private PromotionTarget[] targets; // Array of PromotionTarget
    private EPromotionStatus status;
    //endregion

    //region Constructors
    public Promotion() {
    }

    public Promotion(Long id, Date createdAt, String code, Date effectiveDate, Date expirationDate, String title, String description, double percentDiscount, double minValueToBeApplied, double discountLimit, EPromotionType type, PromotionTarget[] targets, EPromotionStatus status) {
        this.id = id;
        this.createdAt = createdAt;
        this.code = code;
        this.effectiveDate = effectiveDate;
        this.expirationDate = expirationDate;
        this.title = title;
        this.description = description;
        this.percentDiscount = percentDiscount;
        this.minValueToBeApplied = minValueToBeApplied;
        this.discountLimit = discountLimit;
        this.type = type;
        this.targets = targets;
        this.status = status;
    }
    //endregion

    //region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
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

    public PromotionTarget[] getTargets() {
        return targets;
    }

    public void setTargets(PromotionTarget[] targets) {
        this.targets = targets;
    }

    public EPromotionStatus getStatus() {
        return status;
    }

    public void setStatus(EPromotionStatus status) {
        this.status = status;
    }
    //endregion
}
