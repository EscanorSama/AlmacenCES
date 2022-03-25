package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "contenedor")
public class Contenedor {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "zona")
    private String zona;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "numero")
    private int numero;


    @OneToOne(mappedBy = "contenedor")
    @JsonManagedReference
    private Almacen almacen;

    @OneToOne(mappedBy = "contenedor")
    @JsonManagedReference
    private Armario armario;

    @OneToOne(mappedBy = "contenedor")
    @JsonManagedReference
    private Taquilla taquilla;

    @OneToMany(mappedBy = "contenedor")
    @JsonManagedReference
    private List<LineaAlmacen> lineasAlmacen;



}
