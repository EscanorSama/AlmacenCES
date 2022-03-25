package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @ManyToMany
    private ArrayList<Material> materiales;
}
