package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LineaSolicitudModel {
    private long id;
    private String estado;
    private int cantidad;
    private long materialId;

    private long solicitudId;

    private long armarioId;


}
