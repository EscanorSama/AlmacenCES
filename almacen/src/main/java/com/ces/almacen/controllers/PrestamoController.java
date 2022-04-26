package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.PrestamoModel;
import com.ces.almacen.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping(path = "/prestamo")
    public void postPrestamo(@RequestBody PrestamoModel prestamoModel){
        prestamoService.insertPrestamo(prestamoModel);
    }

    @GetMapping(path = "/prestamo/{id}")
    public PrestamoModel getPrestamo(@PathVariable(name = "id")Long id){
        Optional<PrestamoModel> result = prestamoService.getPrestamo(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }


    @GetMapping(path = "/prestamos")
    public List<PrestamoModel> getPrestamos(){
        return prestamoService.getPrestamos();
    }

    @DeleteMapping(path = "/prestamo/{id}")
    public PrestamoModel deletePrestamo(@PathVariable(name = "id")Long id){
        Optional<PrestamoModel> result = prestamoService.deletePrestamo(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
