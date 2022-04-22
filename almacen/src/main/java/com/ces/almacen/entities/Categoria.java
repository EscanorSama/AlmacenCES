package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    @Column
    private long id;
    @Column
    private String nombre;

    @ManyToMany(mappedBy = "categorias")
    @JsonIgnoreProperties({"categorias"})
    private List<Material> materiales;
}
