package com.ces.almacen.converters;

import com.ces.almacen.entities.Solicitud;
import com.ces.almacen.models.SolicitudModel;
import org.springframework.stereotype.Component;

@Component
public class SolicitudConverter {
    public SolicitudModel entityToModel(Solicitud solicitud){
        SolicitudModel solicitudModel = new SolicitudModel();
        solicitudModel.setId(solicitud.getId());
        solicitudModel.setFecha(solicitud.getFecha());

        return solicitudModel;
    }

    public Solicitud modelToEntity(SolicitudModel solicitudModel){
        Solicitud solicitud = new Solicitud();
        solicitud.setId(solicitudModel.getId());
        solicitud.setFecha(solicitud.getFecha());
        return solicitud;
    }
}
