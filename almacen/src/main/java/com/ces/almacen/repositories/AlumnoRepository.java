package com.ces.almacen.repositories;

import com.ces.almacen.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByNumExpediente(String numExpediente);
    List<Alumno> findByCodigoPostal(String codigoPostal);

}
