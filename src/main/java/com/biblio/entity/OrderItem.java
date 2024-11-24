package com.biblio.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class OrderItem extends LineItem implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "orderItem")
    private Set<Book> books = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // endregion

    // region Methods

    public double calPriceItem() {
        double price = 0;

        for (Book item : books) {
            price += item.getSellingPrice();
        }

        return price;
    }

    // endregion

}
