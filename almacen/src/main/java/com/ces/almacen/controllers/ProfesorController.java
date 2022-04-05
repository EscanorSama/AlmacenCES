package com.ces.almacen.controllers;

import com.ces.almacen.errors.BadRequestException;
import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.ProfesorModel;
import com.ces.almacen.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;


    @PostMapping(path = "/profesor")
    public ProfesorModel postProfesor(@RequestBody ProfesorModel profesorModel){
        return profesorService.insertProfesor(profesorModel);
    }

    @PostMapping(path = "/profesores")
    public List<ProfesorModel> postProfesores(@RequestBody List<ProfesorModel> profesoresModel){
        return profesorService.insertProfesores(profesoresModel);
    }

    @GetMapping(path = "/profesores")
    public List<ProfesorModel> getProfesores(){
        return profesorService.getProfesores();
    }



    @GetMapping(path = "/profesor/{id}")
    public ProfesorModel getProfesor(@PathVariable(name = "id")Long id){
        Optional<ProfesorModel> result = profesorService.getProfesor(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @PutMapping(path = "/profesor/mail")
    public void putProfesorMail(ProfesorModel profesorModel){
        profesorService.updateProfesor(profesorModel);
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
