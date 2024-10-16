package com.biblio.entity;

import com.biblio.enumeration.EPromotionTargetType;

import java.io.Serializable;

public class PromotionTarget implements Serializable {
    //region Attributes
    private Long id;
    private String applicableObjectId;
    private EPromotionTargetType type;
    //endregion

    //region Constructors
    public PromotionTarget() {}

    public PromotionTarget(Long id, String applicableObjectId, EPromotionTargetType type) {
        this.id = id;
        this.applicableObjectId = applicableObjectId;
        this.type = type;
    }
    //endregion

    //region Getters & Setters
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
    //endregion
}
