package com.ces.almacen.models;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PersonaModel {
    private long personaId;
    private String mail;
    private String nombre;
    private String apellido;
    private String dni;
    private String tipo;
}
