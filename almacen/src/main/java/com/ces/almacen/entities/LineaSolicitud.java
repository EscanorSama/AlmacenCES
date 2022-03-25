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
@Table(name = "lineasolicitud")
public class LineaSolicitud {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name="estado")
    private String estado;
    @Column(name = "cantidad")
    private int cantidad;
    @ManyToOne
    @JsonBackReference
    private Solicitud solicitud;

    @ManyToOne
    @JsonBackReference
    private Material material;
}
