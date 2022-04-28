package com.ces.almacen.repositories;

import com.ces.almacen.entities.LineaAlmacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LineaAlmacenRepository  extends JpaRepository<LineaAlmacen, Long> {
}
