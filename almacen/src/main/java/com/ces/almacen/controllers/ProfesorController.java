package com.ces.almacen.controllers;

import com.ces.almacen.errors.BadRequestException;
import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.ProfesorModel;
import com.ces.almacen.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;


    @PostMapping(path = "/profesor")
    public ProfesorModel postProfesor(@RequestBody ProfesorModel profesorModel){
        return profesorService.insertProfesor(profesorModel);
    }

    /*
    @PostMapping(path = "profesor")
    public ProfesorModel postProfesor(@RequestBody ProfesorModel profesorModel){
        Optional<ProfesorModel> result = profesorService.insertProfesor(profesor);
        if (result.isPresent()){
            return result.get();
        }
        throw new BadRequestException();
    }*/

    @GetMapping(path = "/profesor/{id}")
    public ProfesorModel getProfesor(@PathVariable(name = "id")Long id){
        Optional<ProfesorModel> result = profesorService.getProfesor(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path = "/profesor/{id}")
    public ProfesorModel deleteProfesor(@PathVariable(name = "id") Long id){
        Optional<ProfesorModel> result = profesorService.deleteProfesor(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
