package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaPedido;
import com.ces.almacen.models.LineaPedidoModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<LineaPedido> listLineaPedidoModelToListLineaPedido(List<LineaPedidoModel> lineasPedidoModel){
        List<LineaPedido> lineasPedido = new ArrayList<>();
        for (LineaPedidoModel lineaPedidoModel: lineasPedidoModel) {
            LineaPedido lineaPedido = this.modelToEntity(lineaPedidoModel);
            lineasPedido.add(lineaPedido);
        }
        return lineasPedido;
    }

    public List<LineaPedidoModel> listLineaPedidoToListLineaPedidoModel(List<LineaPedido> lineasPedido){
        List<LineaPedidoModel> lineasPedidoModel = new ArrayList<>();
        for (LineaPedido lineaPedido: lineasPedido) {
            LineaPedidoModel lineaPedidoModel = this.entityToModel(lineaPedido);
            lineasPedidoModel.add(lineaPedidoModel);
        }
        return lineasPedidoModel;
    }
}
