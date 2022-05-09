package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaSolicitud;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.entities.Solicitud;
import com.ces.almacen.models.LineaSolicitudModel;
import com.ces.almacen.models.ProfesorModel;
import com.ces.almacen.models.SolicitudModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SolicitudConverter {
    @Autowired
    LineaSolicitudConverter lineaSolicitudConverter;

    @Autowired
    ProfesorConverter profesorConverter;

    public SolicitudModel entityToModel(Solicitud solicitud){
        SolicitudModel solicitudModel = new SolicitudModel();
        solicitudModel.setId(solicitud.getId());
        solicitudModel.setFecha(solicitud.getFecha());
        //solicitudModel.setProfesorId(solicitud.getProfesor().getId());
        //solicitudModel.setProfesor(profesorConverter.entityToModel(solicitud.getProfesor()));

        Profesor profesor = solicitud.getProfesor();
        ProfesorModel profesorModel = profesorConverter.entityToModel(profesor);
        solicitudModel.setProfesor(profesorModel);

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
        ProfesorModel profesorModel = solicitudModel.getProfesor();
        Profesor profesor = profesorConverter.modelToEntity(profesorModel);
        solicitud.setProfesor(profesor);
        return solicitud;
    }
}
