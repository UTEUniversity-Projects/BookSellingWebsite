package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promotion_target")
public class PromotionTarget implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicable_object_id", nullable = false, columnDefinition = "nvarchar(255)")
    private String applicableObjectId;

    @Column(name = "type", nullable = false, columnDefinition = "nvarchar(255)")
    private String type;

    // endregion

    // region Constructors

    public PromotionTarget() {
    }

    public PromotionTarget(Long id, String applicableObjectId, String type) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // endregion
}
