package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.AlumnoModel;
import com.ces.almacen.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping(path = "/alumno")
    public AlumnoModel postAlumno(@RequestBody AlumnoModel alumnoModel){
        return alumnoService.insertAlumno(alumnoModel);
    }

    @PostMapping(path = "/alumnos")
    public List<AlumnoModel> postAlumnos(@RequestBody List<AlumnoModel> alumnosModel){
        return alumnoService.postAlumnos(alumnosModel);
    }

    @GetMapping(path = "/alumno")
    public AlumnoModel getAlumno(@PathVariable(name = "id")Long id){
        Optional<AlumnoModel> result = alumnoService.getAlumno(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @PutMapping(path = "/alumno/mail")
    public boolean putAlumnoIdMail(@RequestParam(name = "id")Long id, @RequestParam(name = "mail")String mail){
        if(alumnoService.updateAlumnoIdMail(id, mail)){
            return true;
        }
        throw new NotFoundException();
    }

    @GetMapping(path = "/alumnos")
    public List<AlumnoModel> getAlumnos (){
        return alumnoService.getAlumnos();
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
