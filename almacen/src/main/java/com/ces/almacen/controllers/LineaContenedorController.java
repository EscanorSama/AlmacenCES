package com.ces.almacen.controllers;

import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.services.LineaAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/lineaContenedor/{id}")
    public void putLineaContenedor(@PathVariable(name = "id") Long id, @RequestBody Long contenedorId){
        lineaAlmacenService.updateLineaContenedor(id, contenedorId);
    }


}
