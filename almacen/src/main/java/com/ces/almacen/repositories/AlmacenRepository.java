package com.ces.almacen.repositories;

import com.ces.almacen.entities.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen, Long> {
}
