package com.ces.almacen.services;

import com.ces.almacen.converters.LineaPedidoConverter;
import com.ces.almacen.converters.MaterialConverter;
import com.ces.almacen.entities.LineaPedido;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.LineaPedidoModel;
import com.ces.almacen.models.MaterialModel;
import com.ces.almacen.repositories.LineaPedidoRepository;
import com.ces.almacen.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LineaPedidoService {
    @Autowired
    private LineaPedidoConverter lineaPedidoConverter;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private LineaPedidoRepository lineaPedidoRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MaterialConverter materialConverter;

    public LineaPedido insertLineaPedido(LineaPedidoModel lineaPedidoModel){
        LineaPedido lineaPedido = lineaPedidoConverter.modelToEntity(lineaPedidoModel);
        lineaPedido=lineaPedidoRepository.save(lineaPedido);
        return lineaPedido;  //guardas la linea de pedido con su id y el id del material
    }

}
