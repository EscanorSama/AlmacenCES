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
@Table(name = "persona")
public class
Persona {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "mail")
    private String mail;
    @Column(name="nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;

    @OneToOne(mappedBy = "persona")
    @JsonManagedReference
    Alumno alumno;

    @OneToOne(mappedBy = "persona")
    @JsonManagedReference
    Profesor profesor;

}
