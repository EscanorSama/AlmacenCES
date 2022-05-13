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
    private boolean estado;
    private int cantidad;

    private MaterialModel material;
    private long solicitudId;

    private ArmarioModel armario;


}
