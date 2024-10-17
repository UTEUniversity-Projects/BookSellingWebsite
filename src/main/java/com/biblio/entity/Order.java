package com.biblio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String note;

    private String status;

    // endregion

    // region Relationships

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
