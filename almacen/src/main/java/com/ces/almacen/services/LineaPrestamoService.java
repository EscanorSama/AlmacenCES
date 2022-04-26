package com.ces.almacen.services;

import com.ces.almacen.converters.LineaPrestamoConverter;
import com.ces.almacen.entities.LineaPrestamo;
import com.ces.almacen.models.LineaPrestamoModel;
import com.ces.almacen.repositories.LineaPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineaPrestamoService {

    @Autowired
    private LineaPrestamoConverter lineaPrestamoConverter;

    @Autowired
    private LineaPrestamoRepository lineaPrestamoRepository;

    public LineaPrestamo insertLineaPrestamo (LineaPrestamoModel lineaPrestamoModel){
        LineaPrestamo lineaPrestamo = lineaPrestamoConverter.modelToEntity(lineaPrestamoModel);
        lineaPrestamo = lineaPrestamoRepository.save(lineaPrestamo);
        return lineaPrestamo;
    }

}
