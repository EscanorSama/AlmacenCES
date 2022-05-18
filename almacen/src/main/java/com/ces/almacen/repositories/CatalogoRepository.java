package com.ces.almacen.repositories;

import com.ces.almacen.entities.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
}
