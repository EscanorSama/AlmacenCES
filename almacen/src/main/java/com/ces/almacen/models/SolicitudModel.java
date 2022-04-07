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
public class SolicitudModel {
    private long id;
    private int fecha;
    List<LineaSolicitudModel> lineasSolicitud;
}
