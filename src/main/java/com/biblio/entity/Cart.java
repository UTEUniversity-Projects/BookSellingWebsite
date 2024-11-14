package com.biblio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@Getter
@Setter
public class Cart implements Serializable {

    //region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //endregion

    // region Relationships

    @ManyToMany
    @JoinTable(name = "cart_book_inventory", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "book_inventory_id"))
    private Set<BookInventory> bookInventories;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // endregion

}
