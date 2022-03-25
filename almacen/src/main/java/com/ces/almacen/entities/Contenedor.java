package com.ces.almacen.entities;

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
@Table(name = "contenedor")
public class Contenedor {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;


    @OneToOne(mappedBy = "contenedor")
    @JsonManagedReference
    private Almacen almacen;

    @OneToOne(mappedBy = "contenedor")
    @JsonManagedReference
    private Armario armario;

    @OneToOne(mappedBy = "contenedor")
    @JsonManagedReference
    private Taquilla taquilla;



}
