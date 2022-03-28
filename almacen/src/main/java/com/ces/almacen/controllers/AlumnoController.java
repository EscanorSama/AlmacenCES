package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.AlumnoModel;
import com.ces.almacen.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping(path = "/alumno")
    public void postAlumno(@RequestBody AlumnoModel alumnoModel){
        alumnoService.insertAlumno(alumnoModel);
    }

    @DeleteMapping(path = "/alumno/{id}")
    public AlumnoModel deleteAlumno(@PathVariable(name = "id") Long id){
        Optional<AlumnoModel> result = alumnoService.deleteAlumno(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
