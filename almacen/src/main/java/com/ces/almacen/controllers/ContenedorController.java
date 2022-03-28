package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.ContenedorModel;
import com.ces.almacen.services.ContenedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ContenedorController {
    @Autowired
    private ContenedorService contenedorService;

    @PostMapping(path = "/contenedor")
    public void postContenedor(@RequestBody ContenedorModel contenedorModel){
        contenedorService.insertContenedor(contenedorModel);
    }

    @DeleteMapping(path = "/contenedor/{id}")
    public ContenedorModel deleteContenedor(@PathVariable(name = "id")Long id){
        Optional<ContenedorModel> result = contenedorService.deleteContenedor(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
