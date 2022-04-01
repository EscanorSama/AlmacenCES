package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "numSs")
    private String numSs;
    @Column(name = "salario")
    private double salario;

    @OneToOne(cascade={CascadeType.REMOVE})
    @JsonBackReference
    private Persona persona;

    @OneToMany (mappedBy = "profesor")
    @JsonManagedReference
    private List<Solicitud> solicitudes;

    @OneToMany(mappedBy = "profesor")
    @JsonManagedReference
    private List<Armario> armarios;

}
