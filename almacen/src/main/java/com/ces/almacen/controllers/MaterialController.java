package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.MaterialModel;
import com.ces.almacen.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping(path = "/material")
    public void postMaterial(@RequestBody MaterialModel materialModel){
        materialService.insertMaterial(materialModel);
    }

    @PostMapping(path = "/materiales")
    public List<MaterialModel> postMateriales(@RequestBody List<MaterialModel> materialesModel){
        return materialService.insertMateriales(materialesModel);
    }

    @GetMapping(path = "/materiales")
    public List<MaterialModel> getMateriales(@RequestParam(name = "npag", required = false)Integer npag,
                                             @RequestParam(name = "marca", required = false)String marca,
                                             @RequestParam(name = "proveedor", required = false)String proveedor){

        if(npag!= null && marca==null && proveedor==null){
            return materialService.getMaterialesPag(npag);
        } else if(npag== null && marca==null && proveedor==null){
            return materialService.getMateriales();
        } else if(npag== null && marca!=null && proveedor==null){
            return materialService.getMaterialMarca(marca);
        } else if (npag== null && marca==null && proveedor!=null){
            return materialService.getMaterialProveedor(proveedor);
        }

    }

    @GetMapping(path = "/material/{id}")
    public MaterialModel getMaterial(@PathVariable(name = "id")Long id){
        Optional<MaterialModel> result = materialService.getMaterial(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @PutMapping(path = "/material")
    public MaterialModel putMaterial(@RequestBody MaterialModel materialModel){
        return materialService.updateMaterial(materialModel);
    }

    @DeleteMapping(path = "/material/{id}")
    public MaterialModel deleteMaterial(@PathVariable(name = "id")Long id){
        Optional<MaterialModel> result = materialService.deleteMaterial(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path = "/materiales")
    public List<MaterialModel> deleteMateriales(@RequestBody  List<Long > ids){
        return materialService.deleteMateriales(ids);
    }
}
