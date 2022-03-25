package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue
    @Column
    private long id;


    @OneToMany(mappedBy = "pedido")
    @JsonManagedReference
    private List<LineaPedido> lineasPedidos;
}
