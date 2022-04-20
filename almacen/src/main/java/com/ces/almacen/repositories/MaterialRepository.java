package com.ces.almacen.repositories;

import com.ces.almacen.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByMarca(String marca);

    List<Material> findByProveedor(String proveedor);


}
