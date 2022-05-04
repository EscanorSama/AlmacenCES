package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.AlmacenModel;
import com.ces.almacen.services.AlmacenService;
import com.ces.almacen.services.ContenedorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private ContenedorService contenedorService;

    @PostMapping(path = "/almacen")
    public AlmacenModel  postAlmacen(@RequestBody AlmacenModel almacenModel){
        return almacenService.insertAlmacen(almacenModel);
    }

    @PostMapping(path = "/almacenes")
    public List<AlmacenModel> postAlmacenes(@RequestBody List<AlmacenModel> almacenesModel){
        return almacenService.insertAlmacenes(almacenesModel);
    }

    @GetMapping(path = "/almacenes")
    public List<AlmacenModel> getAlmacenes(){
        return almacenService.getAlmacenes();

    }

    @PutMapping(path = "/almacen")
    public void putAlmacen(@RequestBody AlmacenModel almacenModel){
        log.info("******* almacén");
        almacenService.updateAlmacen(almacenModel);
    }

    @GetMapping(path = "/almacen/{id}")
    public AlmacenModel getAlmacen(@PathVariable(name = "id")Long id){
        Optional<AlmacenModel> result = almacenService.getAlmacen(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }


    @DeleteMapping(path = "/almacen/{id}")
    public AlmacenModel deleteAlmacen(@PathVariable(name = "id")Long id){
        Optional<AlmacenModel> result = almacenService.deleteAlmacen(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }


}
