package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.sql.Date;
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
    private Date fecha;

    @OneToMany(mappedBy = "solicitud" )
    @JsonManagedReference
    private List<LineaSolicitud> lineasSolicitud;

    @ManyToOne
    @JsonBackReference
    private Profesor profesor;
}
