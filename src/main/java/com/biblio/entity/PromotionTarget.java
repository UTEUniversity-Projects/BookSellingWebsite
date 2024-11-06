package com.biblio.entity;

import com.biblio.enumeration.EPromotionTargetType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promotion_target")
public class PromotionTarget implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "applicable_object_id", nullable = false)
    private String applicableObjectId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private EPromotionTargetType type;

    // endregion

    // region Relationships

    @ManyToMany(mappedBy = "promotionTargets")
    private Set<Promotion> promotions = new HashSet<Promotion>();

    // endregion

    // region Constructors

    public PromotionTarget() {
    }

    public PromotionTarget(String id, String applicableObjectId, EPromotionTargetType type, Set<Promotion> promotions) {
        this.id = id;
        this.applicableObjectId = applicableObjectId;
        this.type = type;
        this.promotions = promotions;
    }


    // endregion

    // region Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }


    // endregion
}
