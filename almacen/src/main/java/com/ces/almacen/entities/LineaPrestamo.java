package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lineaPrestamo")
public class LineaPrestamo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JsonBackReference
    private Prestamo prestamo;

    @ManyToOne
    @JsonBackReference
    private Material material;
}
