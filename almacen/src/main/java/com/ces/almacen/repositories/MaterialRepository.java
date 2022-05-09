package com.ces.almacen.repositories;

import com.ces.almacen.entities.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Page<Material> findByMarca(String marca, Pageable pageable);

    Page<Material> findByProveedor(String proveedor, Pageable pageable);




}
