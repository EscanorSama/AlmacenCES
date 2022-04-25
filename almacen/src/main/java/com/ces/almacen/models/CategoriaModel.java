package com.ces.almacen.models;

import com.ces.almacen.entities.Material;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoriaModel {
    private long id;
    private String nombre;

}
