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
public class ProfesorModel extends PersonaModel{
    private long profesorId;
    private String numSs;
    private double salario;
    private String domicilio;
    private String poblacion;
    private String provincia;
    private String codigoPostal;
    private String telefono;
    private String movil;
    private String formaPago;
    private String entidadDeCargo;
    private String cuentaBancaria;
    private List<ArmarioModel> armarios;

}
