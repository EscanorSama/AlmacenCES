package com.ces.almacen.controllers;

import com.ces.almacen.converters.MaterialConverter;
import com.ces.almacen.entities.Material;
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
    private MaterialConverter materialConverter;

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
                                             @RequestParam(name = "tPag", required = false)Integer tPag,
                                             @RequestParam(name = "marca", required = false)String marca,
                                             @RequestParam(name = "proveedor", required = false)String proveedor,
                                             @RequestParam(name = "numMateriales", required = false)Integer numMateriales){

        if(npag!= null && marca==null && proveedor==null){
            return materialService.getMaterialesPag(npag, tPag, numMateriales);
        }  else if(npag!= null && marca!=null && proveedor==null){
            return materialService.getMaterialMarca(npag, marca, tPag);
        } else {
            return materialService.getMaterialProveedor(npag, proveedor, tPag);
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
    public void putMaterial(@RequestBody MaterialModel materialModel){
         materialService.updateMaterial(materialModel);
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
    public void deleteMateriales(@RequestBody  List<MaterialModel> materialesModel){
        for (MaterialModel materialModel: materialesModel) {

            materialService.deleteMateriales(materialModel.getId());

        }

    }

    @GetMapping(path="/numMateriales")
    public int getNumMateriales(){
        return materialService.getNumMateriales();
    }
}
