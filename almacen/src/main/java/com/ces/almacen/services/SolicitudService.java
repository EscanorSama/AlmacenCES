package com.ces.almacen.services;

import com.ces.almacen.converters.SolicitudConverter;
import com.ces.almacen.entities.Solicitud;
import com.ces.almacen.models.SolicitudModel;
import com.ces.almacen.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudConverter solicitudConverter;

    @Autowired
    private SolicitudRepository solicitudRepository;

    public void insertSolicitud(SolicitudModel solicitudModel) {
        Solicitud solicitud = solicitudConverter.modelToEntity(solicitudModel);
        solicitudRepository.save(solicitud);
    }

    public Optional<SolicitudModel> getSolicitudId(Long id) {
        Optional<SolicitudModel> resultSm = Optional.empty();
        Optional<Solicitud> solicitud = solicitudRepository.findById(id);
        if (solicitud.isPresent()){
            SolicitudModel solicitudModel = solicitudConverter.entityToModel(solicitud.get());
            resultSm = Optional.of(solicitudModel);
        }
        return resultSm;
    }

    public Optional<SolicitudModel> deleteSolicitud(Long id) {
        Optional<SolicitudModel> resultSm = Optional.empty();
        Optional<Solicitud> result = solicitudRepository.findById(id);
        if (result.isPresent()){
            Solicitud solicitud = result.get();
            SolicitudModel solicitudModel = solicitudConverter.entityToModel(solicitud);
            resultSm = Optional.of(solicitudModel);
            solicitudRepository.delete(solicitud);
        }
        return resultSm;
    }


    public boolean updateSolicitudFecha(Long id, Integer fecha) {
        Optional<Solicitud> result = solicitudRepository.findById(id);
        if (result.isPresent()){
            result.get().setFecha(fecha);
            solicitudRepository.save(result.get());
            return true;
        }
        return false;
    }
}
