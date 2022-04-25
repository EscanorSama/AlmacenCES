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
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JsonBackReference
    private Aula aula;

    @OneToMany(mappedBy = "prestamo")
    @JsonManagedReference
    private List<LineaPrestamo> lineasPrestamo;

    @OneToOne
    @JsonBackReference
    private Profesor profesor;


}
