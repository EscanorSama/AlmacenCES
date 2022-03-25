package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "solicitud")
public class Solicitud {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "fecha")
    private int fecha;

    @OneToMany(mappedBy = "solicitud")
    private List<LineaSolicitud> lineasSolicitud;

    @ManyToOne
    @JsonBackReference
    private Profesor profesor;
}
