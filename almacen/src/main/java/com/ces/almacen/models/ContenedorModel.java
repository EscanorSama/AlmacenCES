package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContenedorModel {
    private long contenedorId;
    private String zona;
    private String descripcion;
    private int numero;
}
