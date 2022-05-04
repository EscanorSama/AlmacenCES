package com.ces.almacen.controllers;

import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.TaquillaModel;
import com.ces.almacen.services.TaquillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaquillaController {
    @Autowired
    private TaquillaService taquillaService;

    @PostMapping(path = "/taquilla")
    public TaquillaModel postTaquilla(@RequestBody TaquillaModel taquillaModel){
        return taquillaService.insertTaquilla(taquillaModel);
    }

    @PostMapping(path = "/taquillas")
    public List<TaquillaModel> postTaquillas(@RequestBody List<TaquillaModel> taquillasModel){
        return taquillaService.postTaquillas(taquillasModel);
    }

    @GetMapping(path = "/taquillas")
    public List<TaquillaModel> getTaquillas(){
        return taquillaService.getTaquillas();
    }

    @GetMapping(path = "/taquilla/{id}")
    public TaquillaModel getTaquilla(@PathVariable(name = "id")Long id){
        Optional<TaquillaModel> result = taquillaService.getTaquilla(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @PutMapping(path = "/taquilla")
    public void putTaquilla(@RequestBody TaquillaModel taquillaModel){
        taquillaService.updateTaquilla(taquillaModel);
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
