package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaPedido;
import com.ces.almacen.entities.Pedido;
import com.ces.almacen.models.LineaPedidoModel;
import com.ces.almacen.models.PedidoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoConverter {
    @Autowired
    LineaPedidoConverter lineaPedidoConverter;

    public PedidoModel entityToModel(Pedido pedido){
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setId(pedido.getId());
        pedidoModel.setFecha(pedido.getFecha());

        List<LineaPedidoModel> lineasPedidoModel = lineaPedidoConverter.listLineaPedidoToListLineaPedidoModel(pedido.getLineasPedidos());
        pedidoModel.setLineasPedido(lineasPedidoModel);

        return pedidoModel;
    }

    public Pedido modelToEntity(PedidoModel pedidoModel){
        Pedido pedido = new Pedido();
        pedido.setId(pedidoModel.getId());
        pedido.setFecha(pedidoModel.getFecha());

        List<LineaPedido> lineasPedido = lineaPedidoConverter.listLineaPedidoModelToListLineaPedido(pedidoModel.getLineasPedido());
        pedido.setLineasPedidos(lineasPedido);

        return pedido;
    }
}
