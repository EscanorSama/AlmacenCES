package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(name = "tipo")
    private String tipo;




    @OneToMany(mappedBy = "contenedor")
    @JsonIgnoreProperties({"contenedor"})
    private List<LineaAlmacen> lineasAlmacen;



}
