package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContenedorModel {
    private long contenedorId;
    private String zona;
    private String descripcion;
    private int numero;
    List<LineaAlmacenModel> lineasAlmacen;
    private String tipo;
}
