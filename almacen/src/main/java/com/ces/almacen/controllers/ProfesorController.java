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
    public List<ProfesorModel> getProfesores(@RequestParam(name = "nPag", required = true)Integer nPag,
                                             @RequestParam(name = "tPag", required = true)Integer tPag){
        return profesorService.getProfesoresPag(nPag, tPag);
    }



    @GetMapping(path = "/profesor/{id}")
    public ProfesorModel getProfesor(@PathVariable(name = "id")Long id){
        Optional<ProfesorModel> result = profesorService.getProfesor(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @PutMapping(path = "/profesor")
    public void putProfesor(@RequestBody ProfesorModel profesorModel){
        profesorService.updateProfesor(profesorModel);
    }


    @PutMapping(path = "/profesor/{profesorId}/armarios")
    public void putProfesorArmarios(@PathVariable(name = "profesorId")Long profesorId,
                                @RequestBody List<Long> armariosId){
        profesorService.insertArmario(armariosId, profesorId);
    }

    @DeleteMapping(path = "/profesor/{id}")
    public ProfesorModel deleteProfesor(@PathVariable(name = "id") Long id){
        Optional<ProfesorModel> result = profesorService.deleteProfesor(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }



    @GetMapping(path = "/numProfesores")
    public int getNumProfesores(){
        return profesorService.getNumProfesores();
    }
}
