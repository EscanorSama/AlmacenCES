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
    public List<AlumnoModel> getAlumnos (@RequestParam(name = "nPag", required = true)Integer nPag,
                                         @RequestParam(name = "numExpediente", required = false)String numExpediente,
                                         @RequestParam(name = "codigoPostal", required = false)String codigoPostal,
                                         @RequestParam(name = "tPag", required = true)Integer tPag){
        if(nPag!= null && tPag!=null && numExpediente==null && codigoPostal==null){
            return alumnoService.getAlumnosPag(nPag, tPag);
        }else if(nPag== null && numExpediente!=null && codigoPostal==null){
            return alumnoService.getAlumnoNumExpediente(nPag, tPag, numExpediente);
        }else if(nPag== null && numExpediente==null && codigoPostal!=null){
            return alumnoService.getAlumnoCodigoPostal(nPag, tPag, codigoPostal);
        }else{
            return alumnoService.getAlumnos();
        }

    }

    @PutMapping(path = "/alumno/{alumnoId}/taquilla")
    public void insertTaquilla(@PathVariable(name = "alumnoId")Long alumnoId, @RequestBody Long taquillaId){
        alumnoService.insertTaquilla(alumnoId,taquillaId);
    }

    /*@PutMapping(path = "/alumno/mail")
    public void putAlumnoMail(@RequestBody AlumnoModel alumnoModel){
        alumnoService.updateAlumno(alumnoModel);
    }*/


    @PutMapping(path = "/alumno")
    public AlumnoModel putAlumno(@RequestBody AlumnoModel alumnoModel){
         return alumnoService.updateAlumno(alumnoModel);
    }



    @DeleteMapping(path = "/alumno/{id}")
    public AlumnoModel deleteAlumno(@PathVariable(name = "id") Long id){
        Optional<AlumnoModel> result = alumnoService.deleteAlumno(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }



    @GetMapping(path = "/numAlumnos")
    public int getNumAlumnos(){
        return alumnoService.getNumAlumnos();
    }
}
