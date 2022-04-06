package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "stock")
    private String stock;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "numSerie")
    private String numSerie;

    @Column(name = "estado")
    private String estado;

    @ManyToMany
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "material")
    private List<LineaPedido> lineasPedidos;

    @OneToMany(mappedBy = "material")
    private List<LineaAlmacen> lineasAlmacen;

    @OneToMany(mappedBy = "material")
    private List<LineaSolicitud> lineasSolicitud;

}
