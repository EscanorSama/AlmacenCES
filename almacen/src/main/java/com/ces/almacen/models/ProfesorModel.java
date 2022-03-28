package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfesorModel {
    private long id;
    private int numSs;
    private double salario;
}
