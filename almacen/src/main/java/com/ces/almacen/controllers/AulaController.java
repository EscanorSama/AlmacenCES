package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.AulaModel;
import com.ces.almacen.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AulaController {
    @Autowired
    AulaService aulaService;

    @PostMapping(path = "/aula")
    public void postAula(@RequestBody AulaModel aulaModel){
        aulaService.insertAula(aulaModel);
    }

    @GetMapping(path = "/aulas")
    public List<AulaModel> getAulas(){
        return aulaService.getAulas();
    }

    @GetMapping(path = "/aula/{id}")
    public AulaModel getAula(@PathVariable(name = "id")Long id){
        Optional<AulaModel> result = aulaService.getAula(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path = "/aula/{id}")
    public AulaModel deleteAula(@PathVariable(name = "id")Long id){
        Optional<AulaModel> result = aulaService.deleteAula(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

}
