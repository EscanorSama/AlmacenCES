package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @ManyToOne
    @JsonBackReference
    private ArrayList<Material> materiales;
}
