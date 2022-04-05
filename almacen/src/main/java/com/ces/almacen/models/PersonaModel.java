package com.ces.almacen.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonaModel {
    private long personaId;
    private String mail;
    private String nombre;
    private String apellido;
    private String dni;
}
