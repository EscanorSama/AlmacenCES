package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.ArmarioModel;
import com.ces.almacen.services.ArmarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArmarioController {
    @Autowired
    private ArmarioService armarioService;

    @PostMapping(path = "/armario")
    public ArmarioModel postArmario(@RequestBody ArmarioModel armarioModel){
        return armarioService.insertArmario(armarioModel);
    }

    @GetMapping(path = "/armario/{id}")
    public ArmarioModel getArmario(@PathVariable(name = "id")Long id){
        Optional<ArmarioModel> result = armarioService.getArmario(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @GetMapping(path = "armarios")
    public List<ArmarioModel> getArmarios(){
        return armarioService.getArmarios();
    }

    @DeleteMapping(path = "/armario/{id}")
    public ArmarioModel deleteArmario(@PathVariable(name="id")Long id){
        Optional<ArmarioModel> result = armarioService.deleteArmario(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

}
