package com.ces.almacen.services;

import com.ces.almacen.converters.LineaSolicitudConverter;
import com.ces.almacen.entities.LineaSolicitud;
import com.ces.almacen.models.LineaSolicitudModel;
import com.ces.almacen.repositories.LineaSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineaSolicitudService {
    @Autowired
    private LineaSolicitudConverter lineaSolicitudConverter;

    @Autowired
    private LineaSolicitudRepository lineaSolicitudRepository;

    public LineaSolicitud insertLineaSolicitud(LineaSolicitudModel lineaSolicitudModel){
        LineaSolicitud lineaSolicitud = lineaSolicitudConverter.modelToEntity(lineaSolicitudModel);
        lineaSolicitud = lineaSolicitudRepository.save(lineaSolicitud);
        return lineaSolicitud;
    }
}
