package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "[order]")
public class Order implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "note", nullable = false, columnDefinition = "nvarchar(255)")
    private String note;

    @Column(name = "status", nullable = false, columnDefinition = "nvarchar(255)")
    private String status;

    // endregion

    // region Relationships

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, referencedColumnName = "id")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    @OneToOne(mappedBy = "order")
    private BankTransfer bankTransfer;

    @OneToOne(mappedBy = "order")
    private Cash cash;

    @OneToOne(mappedBy = "order")
    private CreditCard creditCard;

    @OneToOne(mappedBy = "order")
    private EWallet ewallet;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "order")
    private Set<Promotion> promotions;

    // endregion

    // region Constructors

    public Order() {
    }

    public Order(Long id, String note, String status) {
        this.id = id;
        this.note = note;
        this.status = status;
    }

    // endregion

    // region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // endregion
}
