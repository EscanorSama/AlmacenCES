package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AlumnoModel extends PersonaModel{
    private long alumnoId;
    private String numExpediente;
    private String domicilio;
    private String poblacion;
    private String provincia;
    private String codigoPostal;
    private String telefono;
    private String movil;
    private TaquillaModel taquilla;



}
