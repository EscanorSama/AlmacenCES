package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaSolicitud;
import com.ces.almacen.models.LineaSolicitudModel;
import org.springframework.stereotype.Component;

@Component
public class LineaSolicitudConverter {
    public LineaSolicitudModel entityToModel(LineaSolicitud lineaSolicitud){
        LineaSolicitudModel lineaSolicitudModel = new LineaSolicitudModel();
        lineaSolicitudModel.setId(lineaSolicitud.getId());
        lineaSolicitudModel.setEstado(lineaSolicitud.getEstado());
        lineaSolicitudModel.setCantidad(lineaSolicitud.getCantidad());
        return lineaSolicitudModel;
    }

    public LineaSolicitud modelToEntity(LineaSolicitudModel lineaSolicitudModel){
        LineaSolicitud lineaSolicitud = new LineaSolicitud();
        lineaSolicitud.setId(lineaSolicitudModel.getId());
        lineaSolicitud.setEstado(lineaSolicitudModel.getEstado());
        lineaSolicitud.setCantidad(lineaSolicitud.getCantidad());
        return lineaSolicitud;
    }
}
