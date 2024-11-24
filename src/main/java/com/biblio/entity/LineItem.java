package com.biblio.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@MappedSuperclass
@Table(name = "line_item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class LineItem {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // endregion

}