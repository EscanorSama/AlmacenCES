package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.models.LineaAlmacenModel;
import org.springframework.stereotype.Component;

@Component
public class LineaAlmacenConverter {
    public LineaAlmacenModel entityToModel(LineaAlmacen lineaAlmacen){
        LineaAlmacenModel lineaAlmacenModel = new LineaAlmacenModel();
        lineaAlmacenModel.setId(lineaAlmacen.getId());
        lineaAlmacenModel.setCantidad(lineaAlmacen.getCantidad());
        lineaAlmacenModel.setFecha(lineaAlmacen.getFecha());
        return lineaAlmacenModel;
    }

    public LineaAlmacen modelToEntity(LineaAlmacenModel lineaAlmacenModel){
        LineaAlmacen lineaAlmacen = new LineaAlmacen();
        lineaAlmacen.setId(lineaAlmacenModel.getId());
        lineaAlmacen.setCantidad(lineaAlmacenModel.getCantidad());
        lineaAlmacen.setFecha(lineaAlmacenModel.getFecha());
        return lineaAlmacen;
    }
}
