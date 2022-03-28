package com.ces.almacen.controllers;

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
    public void postProfesor(@RequestBody ProfesorModel profesorModel){
        profesorService.insertProfesor(profesorModel);
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
