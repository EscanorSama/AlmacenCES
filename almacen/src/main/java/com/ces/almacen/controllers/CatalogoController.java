package com.ces.almacen.controllers;

import com.ces.almacen.models.CatalogoModel;
import com.ces.almacen.services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

   @PostMapping(path = "/catalogo")
    public CatalogoModel postCatalogo(@RequestBody CatalogoModel catalogoModel){
        return catalogoService.insertCatalogo(catalogoModel);
    }



}
