package com.biblio.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "line_item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LineItem implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // endregion

    // region Relationships

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "line_item_books",
            joinColumns = @JoinColumn(name = "line_item_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "return_book_id")
    private ReturnBook returnBook;
    
    // region

    public double calPriceItem() {
        double totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getSellingPrice();
        }
        return totalPrice;
    }
}
