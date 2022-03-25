package com.ces.almacen.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lineacontenedor")
public class LineaContenedor {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;


}
