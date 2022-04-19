package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaSolicitud;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.entities.Solicitud;
import com.ces.almacen.models.LineaSolicitudModel;
import com.ces.almacen.models.SolicitudModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SolicitudConverter {
    @Autowired
    LineaSolicitudConverter lineaSolicitudConverter;

    public SolicitudModel entityToModel(Solicitud solicitud){
        SolicitudModel solicitudModel = new SolicitudModel();
        solicitudModel.setId(solicitud.getId());
        solicitudModel.setFecha(solicitud.getFecha());
        solicitudModel.setProfesorId(solicitud.getProfesor().getId());
        List<LineaSolicitudModel> lineasSolicitudModel = lineaSolicitudConverter.listLineaSolicitudToListLineaSolicitudModel(solicitud.getLineasSolicitud());
        solicitudModel.setLineasSolicitud(lineasSolicitudModel);

        return solicitudModel;
    }

    public Solicitud modelToEntity(SolicitudModel solicitudModel){
        Solicitud solicitud = new Solicitud();
        solicitud.setId(solicitudModel.getId());
        solicitud.setFecha(solicitudModel.getFecha());
        List<LineaSolicitud> lineasSolicitud = lineaSolicitudConverter.listLineaSolicitudModelToListLineaSolicitud(solicitudModel.getLineasSolicitud());
        solicitud.setLineasSolicitud(lineasSolicitud);
        Profesor profesor = new Profesor();
        profesor.setId(solicitudModel.getProfesorId());
        solicitud.setProfesor(profesor);
        return solicitud;
    }
}
