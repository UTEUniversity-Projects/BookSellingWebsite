package com.biblio.entity;

import com.biblio.enumeration.EPromotionTargetType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promotion_target")
public class PromotionTarget implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicable_object_id", nullable = false)
    private String applicableObjectId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EPromotionTargetType type;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id", nullable = false)
    private Promotion promotion;

    // endregion

    // region Constructors

    public PromotionTarget() {
    }

    public PromotionTarget(Long id, String applicableObjectId, EPromotionTargetType type) {
        this.id = id;
        this.applicableObjectId = applicableObjectId;
        this.type = type;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicableObjectId() {
        return applicableObjectId;
    }

    public void setApplicableObjectId(String applicableObjectId) {
        this.applicableObjectId = applicableObjectId;
    }

    public EPromotionTargetType getType() {
        return type;
    }

    public void setType(EPromotionTargetType type) {
        this.type = type;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    // endregion
}
