package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.MaterialModel;
import com.ces.almacen.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping(path = "/material")
    public void postMaterial(@RequestBody MaterialModel materialModel){
        materialService.insertMaterial(materialModel);
    }

    @GetMapping(path = "/material/{id}")
    public MaterialModel getMaterial(@PathVariable(name = "id")Long id){
        Optional<MaterialModel> result = materialService.getMaterial(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path = "/material/id")
    public MaterialModel deleteMaterial(@PathVariable(name = "id")Long id){
        Optional<MaterialModel> result = materialService.deleteMaterial(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
