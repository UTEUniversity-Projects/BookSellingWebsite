package com.biblio.entity;

import com.biblio.enumeration.EOrderStatus;
import com.biblio.enumeration.EPaymentType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "[order]")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false)
    private String note;

    @Column(name = "vat", nullable = false)
    private double vat;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EOrderStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private EPaymentType paymentType;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_id", referencedColumnName = "id")
    private Shipping shipping;

//    @OneToOne(mappedBy = "order")
//    private BankTransfer bankTransfer;
//
//    @OneToOne(mappedBy = "order")
//    private CreditCard creditCard;
//
//    @OneToOne(mappedBy = "order")
//    private Cash cash;
//
//    @OneToOne(mappedBy = "order")
//    private EWallet wallet;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<LineItem> lineItems = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "order_promotion",
            joinColumns = @JoinColumn(name = "order_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "promotion_id", nullable = false))
    private Set<Promotion> promotions = new HashSet<>();

    // endregion

    // region Methods

    public double calTotalPrice() {
        double totalPrice = 0.0;
        for (LineItem item : lineItems) {
            totalPrice += item.calPriceItem();
        }
        BigDecimal roundedTotal = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
        return roundedTotal.doubleValue();
    }

    // endregion
}
