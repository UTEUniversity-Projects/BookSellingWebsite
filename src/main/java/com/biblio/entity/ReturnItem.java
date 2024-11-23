package com.biblio.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "return_item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ReturnItem extends LineItem implements Serializable {

    // region Relationships

    @OneToMany(mappedBy = "returnItem")
    private Set<Book> items = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_return_id", nullable = false)
    private BookReturn bookReturn;

    // endregion

    // region Methods

    public double calPriceItem() {
        double price = 0;

        for (Book item : items) {
            price += item.getSellingPrice();
        }

        return price;
    }

    // endregion

}
