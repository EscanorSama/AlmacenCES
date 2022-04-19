package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaSolicitud;
import com.ces.almacen.entities.Material;
import com.ces.almacen.entities.Solicitud;
import com.ces.almacen.models.LineaSolicitudModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LineaSolicitudConverter {
    public LineaSolicitudModel entityToModel(LineaSolicitud lineaSolicitud){
        LineaSolicitudModel lineaSolicitudModel = new LineaSolicitudModel();
        lineaSolicitudModel.setId(lineaSolicitud.getId());
        lineaSolicitudModel.setEstado(lineaSolicitud.getEstado());
        lineaSolicitudModel.setCantidad(lineaSolicitud.getCantidad());
        lineaSolicitudModel.setMaterialId(lineaSolicitud.getMaterial().getId());
        return lineaSolicitudModel;
    }

    public LineaSolicitud modelToEntity(LineaSolicitudModel lineaSolicitudModel){
        LineaSolicitud lineaSolicitud = new LineaSolicitud();
        lineaSolicitud.setId(lineaSolicitudModel.getId());
        lineaSolicitud.setEstado(lineaSolicitudModel.getEstado());
        lineaSolicitud.setCantidad(lineaSolicitudModel.getCantidad());

        Solicitud solicitud = new Solicitud();
        solicitud.setId(lineaSolicitudModel.getSolicitudId());
        lineaSolicitud.setSolicitud(solicitud);

        Material material = new Material();
        material.setId(lineaSolicitudModel.getMaterialId());
        lineaSolicitud.setMaterial(material);
        return lineaSolicitud;
    }

    public List<LineaSolicitud> listLineaSolicitudModelToListLineaSolicitud(List<LineaSolicitudModel> lineasSolicitudModel){
        List<LineaSolicitud> lineasSolicitud = new ArrayList<>();
        for (LineaSolicitudModel lineaSolicitudModel: lineasSolicitudModel) {
            LineaSolicitud lineaSolicitud = this.modelToEntity(lineaSolicitudModel);
            lineasSolicitud.add(lineaSolicitud);
        }
        return lineasSolicitud;
    }

    public List<LineaSolicitudModel> listLineaSolicitudToListLineaSolicitudModel(List<LineaSolicitud> lineasSolicitud){
        List<LineaSolicitudModel> lineasSolicitudModel = new ArrayList<>();
        for (LineaSolicitud lineaSolicitud: lineasSolicitud) {
            LineaSolicitudModel lineaSolicitudModel = this.entityToModel(lineaSolicitud);
            lineasSolicitudModel.add(lineaSolicitudModel);
        }
        return lineasSolicitudModel;
    }
}
