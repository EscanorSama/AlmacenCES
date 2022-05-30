package com.ces.almacen.controllers;

import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.services.LineaAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LineaContenedorController {

    @Autowired
    private LineaAlmacenService lineaAlmacenService;

    @PostMapping(path = "/lineaContenedor")
    public void insertLineaContenedor(@RequestBody LineaAlmacenModel lineaAlmacenModel){
        lineaAlmacenService.insertLineaAlmacen(lineaAlmacenModel);
    }

    @GetMapping(path = "/lineasContenedor")
    public List<LineaAlmacenModel> getLineasContenedor(){
        return lineaAlmacenService.getLineasContenedor();
    }
}
