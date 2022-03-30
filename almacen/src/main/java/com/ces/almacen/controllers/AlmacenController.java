package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.AlmacenModel;
import com.ces.almacen.services.AlmacenService;
import com.ces.almacen.services.ContenedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private ContenedorService contenedorService;

    @PostMapping(path = "/almacen")
    public AlmacenModel  postAlmacen(@RequestBody AlmacenModel almacenModel){
        return almacenService.insertAlmacen(almacenModel);
    }

    /*
    @GetMapping(path = "/libros")
    public List<AlmacenModel> getAlmacenes(){

    }*/

    @GetMapping(path = "/almacen/{id}")
    public AlmacenModel getAlmacen(@PathVariable(name = "id")Long id){
        Optional<AlmacenModel> result = almacenService.getAlmacen(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path="/almacen/{id}")
    public AlmacenModel deleteAlmacen(@PathVariable(name = "id")Long id){
        Optional<AlmacenModel> result = almacenService.deleteAlmacen(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

}
