package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LineaAlmacenModel {
    private long id;
    private int cantidad;
    private int fecha;
    private long contenedorId;
    private long materialId;
}
