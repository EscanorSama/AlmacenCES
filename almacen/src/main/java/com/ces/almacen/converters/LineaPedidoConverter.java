package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaPedido;
import com.ces.almacen.models.LineaPedidoModel;
import org.springframework.stereotype.Component;

@Component
public class LineaPedidoConverter {
    public LineaPedidoModel entityToModel(LineaPedido lineaPedido){
        LineaPedidoModel lineaPedidoModel = new LineaPedidoModel();
        lineaPedidoModel.setId(lineaPedido.getId());
        lineaPedidoModel.setCantidad(lineaPedido.getCantidad());

        return lineaPedidoModel;
    }

    public LineaPedido modelToEntity(LineaPedidoModel lineaPedidoModel){
        LineaPedido lineaPedido = new LineaPedido();
        lineaPedido.setId(lineaPedidoModel.getId());
        lineaPedido.setCantidad(lineaPedidoModel.getCantidad());

        return lineaPedido;
    }
}
