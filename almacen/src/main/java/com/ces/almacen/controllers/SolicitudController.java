package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.SolicitudModel;
import com.ces.almacen.services.SolicitudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @PostMapping(path = "/solicitud")
    public void postSolicitud(@RequestBody SolicitudModel solicitudModel){
        log.info(solicitudModel.toString());
        solicitudService.insertSolicitud(solicitudModel);
    }

    @GetMapping(path="/solicitud/{id}")
    public Optional<SolicitudModel> getSolicitudId(@PathVariable(name = "id") Long id){
        return solicitudService.getSolicitudId(id);
    }

    @PutMapping(path = "/solicitud/fecha")
    public boolean putSolicitud(@RequestParam(name = "id") Long id,@RequestParam(name = "fecha") Date fecha){
        if (solicitudService.updateSolicitudFecha(id, fecha)){
            return true;
        }
        return false;
    }

    @DeleteMapping(path="/solicitud/{id}")
    public SolicitudModel deleteSolicitud(@PathVariable(name="id") Long id){
        Optional<SolicitudModel> result = solicitudService.deleteSolicitud(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @GetMapping(path = "/solicitudes")
    public List<SolicitudModel> getSolicitudes(){
        return solicitudService.getSolicitudes();
    }
}
