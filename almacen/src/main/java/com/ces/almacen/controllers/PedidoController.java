package com.ces.almacen.controllers;

import com.ces.almacen.errors.NotFoundException;
import com.ces.almacen.models.PedidoModel;
import com.ces.almacen.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping(path = "/pedido")
    public void postPedido(@RequestBody PedidoModel pedidoModel){
        pedidoService.insertPedido(pedidoModel);
    }

    @DeleteMapping(path = "/pedido/{id}")
    public PedidoModel deletePedido(@PathVariable(name = "id")Long id){
        Optional<PedidoModel> result = pedidoService.deletePedido(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException();
    }
}
