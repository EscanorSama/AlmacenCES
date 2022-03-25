package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @ManyToMany(mappedBy = "material")
    @JsonIgnoreProperties({"materiales"})
    private ArrayList<Categoria> categorias;

    @OneToMany(mappedBy = "material")
    @JsonManagedReference
    private Pedido pedido;



}
