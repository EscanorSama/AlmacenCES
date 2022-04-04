package com.ces.almacen.controllers;

import com.ces.almacen.models.SolicitudModel;
import com.ces.almacen.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @PostMapping(path = "/solicitud")
    public void postSolicitud(@RequestBody SolicitudModel solicitudModel){
        solicitudService.insertSolicitud(solicitudModel);
    }

    @GetMapping(path="/solicitud/{id}")
    public Optional<SolicitudModel> getSolicitudId(Long id){
        return solicitudService.getSolicitudId(id);
    }

    @PutMapping(path = "/solicitud/fecha")
    public boolean putSolicitud(@RequestParam(name = "id") Long id,@RequestParam(name = "fecha")Integer fecha){
        if (solicitudService.updateSolicitudFecha(id, fecha)){
            return true;
        }
        return false;
    }

    @DeleteMapping(path="/solicitud/{id}")
    public Optional<SolicitudModel> deleteSolicitud(Long id){
        return solicitudService.deleteSolicitud(id);
    }
}
