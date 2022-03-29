package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.CategoriaModel;
import com.ces.almacen.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping(path = "/categoria")
    public void postCategoria(@RequestBody CategoriaModel categoriaModel){
        categoriaService.insertCategoria(categoriaModel);
    }

    @GetMapping(path = "/categoria/{id}")
    public CategoriaModel getCategoria(@PathVariable(name = "id")Long id){
        Optional<CategoriaModel> result = categoriaService.getCategoria(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }

    @DeleteMapping(path = "/categoria/{id}")
    public CategoriaModel deleteCategoria(@PathVariable(name = "id")Long id){
        Optional<CategoriaModel> result = categoriaService.deleteCategoria(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
