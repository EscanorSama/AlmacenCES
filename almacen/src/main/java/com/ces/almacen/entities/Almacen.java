package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "almacen")
public class Almacen {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;



    @OneToOne(cascade={CascadeType.REMOVE})
    @JsonBackReference
    private Contenedor contenedor;




}
