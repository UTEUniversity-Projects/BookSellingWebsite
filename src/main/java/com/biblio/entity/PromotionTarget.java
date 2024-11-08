package com.biblio.entity;

import com.biblio.enumeration.EPromotionTargetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promotion_target")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "quantity")
    private int quantity;

    // endregion

    // region Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id", nullable = false)
    private Promotion promotion;

    // endregion

}
