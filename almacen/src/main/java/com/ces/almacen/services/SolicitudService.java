package com.ces.almacen.services;

import com.ces.almacen.converters.LineaSolicitudConverter;
import com.ces.almacen.converters.SolicitudConverter;
import com.ces.almacen.entities.LineaSolicitud;
import com.ces.almacen.entities.Solicitud;
import com.ces.almacen.models.LineaSolicitudModel;
import com.ces.almacen.models.ProfesorModel;
import com.ces.almacen.models.SolicitudModel;
import com.ces.almacen.repositories.LineaSolicitudRepository;
import com.ces.almacen.repositories.SolicitudRepository;
import com.ces.almacen.utils.UtilsDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SolicitudService {




    @Autowired
    private SolicitudConverter solicitudConverter;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private LineaSolicitudService lineaSolicitudService;

    @Autowired
    private LineaSolicitudRepository lineaSolicitudRepository;

    @Autowired
    private LineaSolicitudConverter lineaSolicitudConverter;

    @Autowired
    private UtilsDate utilsDate;

    public void  insertSolicitud(SolicitudModel solicitudModel) {
        List<LineaSolicitudModel> lineasSolicitudModel = solicitudModel.getLineasSolicitud();

        solicitudModel.setFecha(utilsDate.getSqlSysDate());//fecha del sistema
        Solicitud solicitud = solicitudRepository.save(solicitudConverter.modelToEntity(solicitudModel));
        log.info("^***************"+ solicitud.getId());
        java.sql.Date date = utilsDate.getSqlSysDate();

        for (LineaSolicitudModel lineaSolicitudModel: lineasSolicitudModel) {

            lineaSolicitudModel.setSolicitudId(solicitud.getId());
            lineaSolicitudService.insertLineaSolicitud(lineaSolicitudModel);
        }
    }



    public Optional<SolicitudModel> getSolicitudId(Long id) {
        Optional<SolicitudModel> resultSm = Optional.empty();
        Optional<Solicitud> solicitud = solicitudRepository.findById(id);
        log.info("*******"+ id);
        if (solicitud.isPresent()){
            SolicitudModel solicitudModel = solicitudConverter.entityToModel(solicitud.get());
            resultSm = Optional.of(solicitudModel);
        }
        return resultSm;
    }

    public Optional<SolicitudModel> deleteSolicitud(Long id) {
        Optional<SolicitudModel> resultSm = Optional.empty();
        log.info("******"+ id);
        Optional<Solicitud> result = solicitudRepository.findById(id);

        if (result.isPresent()){
            Solicitud solicitud = result.get();
            List<LineaSolicitud> lineasSolicitud = solicitud.getLineasSolicitud();
            for (LineaSolicitud lineaSolicitud: lineasSolicitud) {
                lineaSolicitudRepository.delete(lineaSolicitud);
            }
            SolicitudModel solicitudModel = solicitudConverter.entityToModel(solicitud);
            resultSm = Optional.of(solicitudModel);
            solicitudRepository.delete(solicitud);
        }
        return resultSm;
    }


    public boolean updateSolicitudFecha(Long id, Date fecha) {
        Optional<Solicitud> result = solicitudRepository.findById(id);
        if (result.isPresent()){
            result.get().setFecha(fecha);
            solicitudRepository.save(result.get());
            return true;
        }
        return false;
    }

    public List<SolicitudModel> getSolicitudes() {
        List<SolicitudModel> solicitudesModel = new ArrayList<>();
        List<Solicitud> solicitudes = solicitudRepository.findAll();
        for (Solicitud solicitud: solicitudes) {
            SolicitudModel solicitudModel = solicitudConverter.entityToModel(solicitud);
            solicitudesModel.add(solicitudModel);
        }
        return solicitudesModel;
    }

    public Optional<SolicitudModel> updateSolicitud(SolicitudModel solicitudModel) {
        Optional<SolicitudModel> resultSm = Optional.empty();
        Optional<Solicitud> result = solicitudRepository.findById(solicitudModel.getId());
        if (result.isPresent()){
            List<LineaSolicitud> lineasSolicitud = new ArrayList<>();
            for (LineaSolicitudModel lineaSolicitudModel: solicitudModel.getLineasSolicitud()) {
                    lineaSolicitudModel.setSolicitudId(solicitudModel.getId());
                    lineasSolicitud.add(lineaSolicitudRepository.save(lineaSolicitudConverter.modelToEntity(lineaSolicitudModel)));


            }
            solicitudModel.setLineasSolicitud(lineaSolicitudConverter.listLineaSolicitudToListLineaSolicitudModel(lineasSolicitud));
            Solicitud solicitud = solicitudRepository.save(solicitudConverter.modelToEntity(solicitudModel));
            resultSm = Optional.of(solicitudConverter.entityToModel(solicitud));
        }
        return resultSm;
    }
}
