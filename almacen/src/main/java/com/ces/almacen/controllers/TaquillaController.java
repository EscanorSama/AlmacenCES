package com.ces.almacen.controllers;

import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.TaquillaModel;
import com.ces.almacen.services.TaquillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaquillaController {
    @Autowired
    private TaquillaService taquillaService;

    @PostMapping(path = "/taquilla")
    public void postTaquilla(@RequestBody TaquillaModel taquillaModel){
        taquillaService.insertTaquilla(taquillaModel);
    }

    @DeleteMapping(path = "/taquilla/{id}")
    public TaquillaModel deleteTaquilla(@PathVariable(name = "id") Long id){
        Optional<TaquillaModel> result = taquillaService.deleteTaquilla(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

}
