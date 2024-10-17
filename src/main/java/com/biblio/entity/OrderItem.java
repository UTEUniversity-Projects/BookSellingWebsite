package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity", nullable = false, columnDefinition = "int")
    private int quantity;

    // endregion

    // region Constructors

    public OrderItem() {
    }

    public OrderItem(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    // endregion

    // region Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // endregion
}
