package com.ces.almacen.repositories;

import com.ces.almacen.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
