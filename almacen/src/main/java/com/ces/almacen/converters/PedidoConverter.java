package com.ces.almacen.converters;

import com.ces.almacen.entities.Pedido;
import com.ces.almacen.models.PedidoModel;
import org.springframework.stereotype.Component;

@Component
public class PedidoConverter {
    public PedidoModel entityToModel(Pedido pedido){
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setId(pedido.getId());
        return pedidoModel;
    }

    public Pedido modelToEntity(PedidoModel pedidoModel){
        Pedido pedido = new Pedido();
        pedido.setId(pedidoModel.getId());
        return pedido;
    }
}
