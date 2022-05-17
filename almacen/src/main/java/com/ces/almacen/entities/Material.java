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
import java.sql.Date;
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

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "marca")
    private String marca;

    @Column(name = "proveedor")
    private String proveedor;

    @Column(name = "numUnidades")
    private int numUnidades;

    @Column(name = "minimoStock")
    private int minimoStock;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "precio")
    private double precio;

    @Column(name = "fungible")
    private boolean fungible;

    @Column(name = "fechaUso")
    private Date fechaUso;

    @Column(name = "fechaFinUso")
    private Date fechaFinUso;


    @ManyToMany()
    @JsonIgnoreProperties({"materiales"})
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "material", cascade={CascadeType.PERSIST})
    private List<LineaPedido> lineasPedidos;

    @OneToMany(mappedBy = "material",cascade={CascadeType.REMOVE} )
    @JsonIgnoreProperties({"material"})
    private List<LineaAlmacen> lineasAlmacen;


    @OneToMany(mappedBy = "material", cascade={CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    private List<LineaSolicitud> lineasSolicitud;

    @PreRemove
    private void preRemove(){
        lineasSolicitud.forEach(lineaSolicitud -> lineaSolicitud.setMaterial(null));
        lineasPedidos.forEach(lineaPedido -> lineaPedido.setMaterial(null));
        categorias.forEach(categoria -> categoria.setMateriales(null));
    }

    @OneToMany(mappedBy = "material", cascade={CascadeType.PERSIST})
    private List<LineaPrestamo> lineasPrestamo;

}
