package com.ces.almacen.controllers;

import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.services.LineaAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineaContenedorController {

    @Autowired
    private LineaAlmacenService lineaAlmacenService;

    @PostMapping(path = "/lineaContenedor")
    public void insertLineaContenedor(@RequestBody LineaAlmacenModel lineaAlmacenModel){
        lineaAlmacenService.insertLineaAlmacen(lineaAlmacenModel);
    }
}
