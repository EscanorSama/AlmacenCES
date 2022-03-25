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
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "idSolicitud")
    private long idSolicitud;
    @Column(name = "idPersona")
    private long idPersona;
    @Column(name = "numSs")
    private int numSs;
    @Column(name = "salario")
    private double salario;

    @OneToOne
    @JsonBackReference
    Persona persona;

}
