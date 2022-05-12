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

    @GetMapping(path = "/alumno/{id}")
    public AlumnoModel getAlumno(@PathVariable(name = "id")Long id){
        Optional<AlumnoModel> result = alumnoService.getAlumno(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }



    @GetMapping(path = "/alumnos")
    public List<AlumnoModel> getAlumnos (@RequestParam(name = "npag", required = false)Integer npag,
                                         @RequestParam(name = "numExpediente", required = false)String numExpediente,
                                         @RequestParam(name = "codigoPostal", required = false)String codigoPostal){
        if(npag!= null && numExpediente==null && codigoPostal==null){
            return alumnoService.getAlumnosPag(npag);
        }else if(npag== null && numExpediente!=null && codigoPostal==null){
            return alumnoService.getAlumnoNumExpediente(numExpediente);
        }else if(npag== null && numExpediente==null && codigoPostal!=null){
            return alumnoService.getAlumnoCodigoPostal(codigoPostal);
        }else{
            return alumnoService.getAlumnos();
        }

    }

    @PutMapping(path = "/alumno/{alumnoId}/taquilla")
    public void insertTaquilla(@PathVariable(name = "alumnoId")Long alumnoId, @RequestBody Long taquillaId){
        alumnoService.insertTaquilla(alumnoId,taquillaId);
    }



    @DeleteMapping(path = "/alumno/{id}")
    public AlumnoModel deleteAlumno(@PathVariable(name = "id") Long id){
        Optional<AlumnoModel> result = alumnoService.deleteAlumno(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @PutMapping(path = "/alumno/mail")
    public void putAlumnoMail(@RequestBody AlumnoModel alumnoModel){
        alumnoService.updateAlumno(alumnoModel);
    }
}
