package com.biblio.entity;

import com.biblio.enumeration.EPromotionTargetType;

import java.io.Serializable;

public class PromotionTarget implements Serializable {
    private String id;
    private String applicableObjectId;
    private EPromotionTargetType type;

    public PromotionTarget() {}

    public PromotionTarget(String id, String applicableObjectId, EPromotionTargetType type) {
        this.id = id;
        this.applicableObjectId = applicableObjectId;
        this.type = type;
    }

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
}
