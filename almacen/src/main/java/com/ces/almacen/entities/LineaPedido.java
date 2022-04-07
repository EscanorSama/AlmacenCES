package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "lineapedido")
public class LineaPedido {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JsonBackReference
    private Pedido pedido;

    @ManyToOne
    @JsonBackReference
    private Material material;

}
