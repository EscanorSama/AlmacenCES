package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MaterialModel {
    private long id;
    private String nombre;
    private String descripcion;
    private String marca;
    private String proveedor;
    private int minimoStock;
    private String observaciones;
    private double precio;
    private List<CategoriaModel> categorias;
    private boolean fungible;
    private Date fechaUso;
    private Date fechaFinUso;
    private List<LineaAlmacenModel> lineasAlmacen;


}
