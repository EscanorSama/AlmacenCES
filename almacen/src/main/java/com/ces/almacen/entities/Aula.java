package com.ces.almacen.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @OneToMany (mappedBy = "aula")
    @JsonManagedReference
    private List<Prestamo> prestamos;

}
