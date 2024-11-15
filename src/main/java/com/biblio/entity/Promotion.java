package com.biblio.entity;

import com.biblio.enumeration.EPromotionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promotion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Promotion implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "effective_date", nullable = false)
    private LocalDateTime effectiveDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "percent_discount", nullable = false)
    private double percentDiscount;

    @Column(name = "discount_limit", nullable = false)
    private double discountLimit;

    @Column(name = "min_value_to_be_applied", nullable = false)
    private double minValueToBeApplied;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EPromotionStatus status;

    // endregion

    // region Relationships

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promotion_template_id", nullable = false)
    private PromotionTemplate promotionTemplate;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PromotionTarget> promotionTargets = new HashSet<>();

    @ManyToMany(mappedBy = "promotions", fetch = FetchType.LAZY)
    private Set<Order> orders;

    // endregion

}
