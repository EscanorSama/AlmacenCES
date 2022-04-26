package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaPrestamo;
import com.ces.almacen.models.LineaPrestamoModel;
import org.springframework.stereotype.Component;

@Component
public class LineaPrestamoConverter {
    public LineaPrestamoModel entityToModel(LineaPrestamo lineaPrestamo){
        LineaPrestamoModel lineaPrestamoModel = new LineaPrestamoModel();
        lineaPrestamoModel.setId(lineaPrestamo.getId());
        return lineaPrestamoModel;
    }

    public LineaPrestamo modelToEntity(LineaPrestamoModel lineaPrestamoModel){
        LineaPrestamo lineaPrestamo = new LineaPrestamo();
        lineaPrestamo.setId(lineaPrestamoModel.getId());
        return lineaPrestamo;
    }
}
