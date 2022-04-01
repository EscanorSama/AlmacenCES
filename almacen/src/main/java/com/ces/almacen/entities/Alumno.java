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
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;


    @OneToOne(cascade={CascadeType.REMOVE})
    @JsonBackReference
    private Persona persona;

    @OneToOne(mappedBy = "alumno")
    @JsonManagedReference
    private Taquilla taquilla;


}
