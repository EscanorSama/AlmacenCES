package com.ces.almacen.services;

import com.ces.almacen.converters.LineaPedidoConverter;
import com.ces.almacen.entities.LineaPedido;
import com.ces.almacen.models.LineaPedidoModel;
import com.ces.almacen.repositories.LineaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineaPedidoService {
    @Autowired
    private LineaPedidoConverter lineaPedidoConverter;

    @Autowired
    private LineaPedidoRepository lineaPedidoRepository;

    public LineaPedido insertLineaPedido(LineaPedidoModel lineaPedidoModel){

        LineaPedido lineaPedido = lineaPedidoConverter.modelToEntity(lineaPedidoModel);

        return lineaPedidoRepository.save(lineaPedido);
    }
}
