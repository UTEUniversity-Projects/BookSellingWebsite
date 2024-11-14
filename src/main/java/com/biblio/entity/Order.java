package com.biblio.entity;

import com.biblio.enumeration.EOrderStatus;
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

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EOrderStatus status;

    // endregion

    // region Relationships

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
  
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "order_promotion",
            joinColumns = @JoinColumn(name = "order_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "promotion_id", nullable = false))
    private Set<Promotion> promotions = new HashSet<Promotion>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    // endregion
    public double calTotalPrice() {
        double totalPrice = 0.0;
        for (Book item : books) {
            totalPrice += item.getSellingPrice();
        }
        BigDecimal roundedTotal = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
        return roundedTotal.doubleValue();
    }
}
