package com.ces.almacen.repositories;

import com.ces.almacen.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
