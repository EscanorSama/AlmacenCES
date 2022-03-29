package com.ces.almacen.repositories;

import com.ces.almacen.entities.Contenedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenedorRepository extends JpaRepository<Contenedor, Long> {
    List<Contenedor> findByZona(String zona);

    List<Contenedor> findByDescripcion(String descripcion);

    List<Contenedor> findByNumero(Integer numero);
}
