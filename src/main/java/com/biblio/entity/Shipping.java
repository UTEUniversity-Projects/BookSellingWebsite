package com.biblio.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "[shipping]")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Shipping implements Serializable {
    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipping_fee", nullable = false)
    private double shippingFee;

    @Column(name = "shipping_unit", nullable = false)
    private String shippingUnit;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToOne(mappedBy = "shipping")
    private Order order;

    // endregion
}