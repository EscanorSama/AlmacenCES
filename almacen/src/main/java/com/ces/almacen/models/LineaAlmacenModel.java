package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LineaAlmacenModel {
    private long id;
    private int cantidad;
    private Date fecha;
    //private long contenedorId;
    private ContenedorModel contenedor;
    private long materialId;
}
