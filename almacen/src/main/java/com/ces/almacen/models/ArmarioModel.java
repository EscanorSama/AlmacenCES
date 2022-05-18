package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArmarioModel extends ContenedorModel{
    private long armarioId;
    private ProfesorModel profesor;
}
