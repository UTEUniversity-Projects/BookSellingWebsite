package com.biblio.entity;

import com.biblio.enumeration.EPromotionTargetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promotion_target")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "quantity")
    private int quantity;

    // endregion

    // region Relationships

    @ManyToMany(mappedBy = "promotionTargets")
    private Set<Promotion> promotions = new HashSet<Promotion>();

    // endregion

}
