package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfesorModel extends PersonaModel{
    private long profesorId;
    private String numSs;
    private double salario;


}
