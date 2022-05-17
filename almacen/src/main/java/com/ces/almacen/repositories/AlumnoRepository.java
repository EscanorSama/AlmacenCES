package com.ces.almacen.repositories;

import com.ces.almacen.entities.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Page<Alumno> findByNumExpediente(String numExpediente, Pageable pageable);
    Page<Alumno> findByCodigoPostal(String codigoPostal, Pageable pageable);

}
