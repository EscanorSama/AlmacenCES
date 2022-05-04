package com.ces.almacen.converters;

import com.ces.almacen.entities.LineaPedido;
import com.ces.almacen.entities.Material;
import com.ces.almacen.entities.Pedido;
import com.ces.almacen.models.LineaPedidoModel;
import com.ces.almacen.models.MaterialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LineaPedidoConverter {

    @Autowired
    private MaterialConverter materialConverter;

    public LineaPedidoModel entityToModel(LineaPedido lineaPedido){
        LineaPedidoModel lineaPedidoModel = new LineaPedidoModel();
        lineaPedidoModel.setId(lineaPedido.getId());
        lineaPedidoModel.setCantidad(lineaPedido.getCantidad());
        lineaPedidoModel.setMaterialId(lineaPedido.getMaterial().getId());

        return lineaPedidoModel;
    }

    public LineaPedido modelToEntity(LineaPedidoModel lineaPedidoModel){
        LineaPedido lineaPedido = new LineaPedido();
        lineaPedido.setId(lineaPedidoModel.getId());
        lineaPedido.setCantidad(lineaPedidoModel.getCantidad());
        Pedido pedido = new Pedido ();
        pedido.setId(lineaPedidoModel.getIdPedido());
        lineaPedido.setPedido(pedido);

        Material material = new Material();
        material.setId(lineaPedidoModel.getMaterialId());
        lineaPedido.setMaterial(material);
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
