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
@Table(name = "lineaAlmacen")
public class LineaAlmacen {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha")
    private int fecha;

    @ManyToOne
    @JsonBackReference
    private Material material;
    @ManyToOne
    @JsonBackReference
    private Contenedor contenedor;
}
