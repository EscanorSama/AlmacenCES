package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.ContenedorModel;
import com.ces.almacen.services.ContenedorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
public class ContenedorController {

    Logger LOG = Logger.getLogger(ContenedorController.class.getCanonicalName());

    @Autowired
    private ContenedorService contenedorService;

    @PostMapping(path = "/contenedor")
    public void postContenedor(@RequestBody ContenedorModel contenedorModel){
        contenedorService.insertContenedor(contenedorModel);
    }

    @GetMapping(path = "/contenedores")
    public List<ContenedorModel> getContenedores(){
        return contenedorService.getContenedores();
    }



    @GetMapping(path = "/contenedor/{id}")
    public ContenedorModel getContenedor(@PathVariable(name = "id")Long id){
        Optional<ContenedorModel> result = contenedorService.getContenedor(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path = "/contenedor/{id}")
    public ContenedorModel deleteContenedor(@PathVariable(name = "id")Long id){
        LOG.info("***** deleteContenedor -> ID: "+id);
        Optional<ContenedorModel> result = contenedorService.getContenedor(id);
        if(result.isPresent()){
            LOG.info("***** deleteContenedor -> CONTENEDOR: "+result.get().getContenedorId());
        }
        result = contenedorService.deleteContenedor(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
