package com.ces.almacen.repositories;

import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.entities.Material;
import org.aspectj.weaver.ArrayReferenceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Page<Material> findByMarca(String marca, Pageable pageable);

    Page<Material> findByProveedor(String proveedor, Pageable pageable);

    //Page<Material> findAllByLineasAlmacen(List<Material> materiales , Pageable pageable);



    /*@Query(value = "SELECT material.lineasAlmacen FROM Material WHERE material.lineasAlmacen: lineasAlmacen IS EMPTY")
    Page<Material> findAll(@Param("lineasAlmacen") List<LineaAlmacen> linea ,Pageable pageable);*/



}
