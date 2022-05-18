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
@Table(name = "catalogo")
public class Catalogo {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private long catalogoId;



    @OneToOne(cascade={CascadeType.REMOVE})
    @JsonBackReference
    private Contenedor contenedor;
}
