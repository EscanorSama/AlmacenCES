package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.AlmacenModel;
import com.ces.almacen.services.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @PostMapping(path = "/almacen")
    public void  postAlmacen(@RequestBody AlmacenModel almacenModel){
        almacenService.insertAlmacen(almacenModel);
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
