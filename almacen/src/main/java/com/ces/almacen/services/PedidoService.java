package com.ces.almacen.services;

import com.ces.almacen.converters.PedidoConverter;
import com.ces.almacen.entities.Pedido;
import com.ces.almacen.models.PedidoModel;
import com.ces.almacen.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoConverter pedidoConverter;

    public void insertPedido(PedidoModel pedidoModel) {
        Pedido pedido = pedidoConverter.modelToEntity(pedidoModel);
        pedidoRepository.save(pedido);
    }

    public Optional<PedidoModel> deletePedido(Long id) {
        Optional<PedidoModel> resultPm = Optional.empty();
        Optional<Pedido> result = pedidoRepository.findById(id);
        if ( result.isPresent()){
            Pedido pedido = result.get();
            PedidoModel pedidoModel = pedidoConverter.entityToModel(pedido);
            resultPm = Optional.of(pedidoModel);
            pedidoRepository.delete(pedido);
        }
        return resultPm;
    }

    public Optional<PedidoModel> getPedido(Long id) {
        Optional<PedidoModel> resultPm = Optional.empty();
        Optional<Pedido> result = pedidoRepository.findById(id);
        if(result.isPresent()){
            Pedido pedido = result.get();
            PedidoModel pedidoModel = pedidoConverter.entityToModel(pedido);
            resultPm = Optional.of(pedidoModel);
        }
        return resultPm;
    }

    public List<PedidoModel> getPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoModel> pedidosModel = listPedidoToListPedidoModel(pedidos);
        return pedidosModel;
    }

    private List<PedidoModel> listPedidoToListPedidoModel(List<Pedido> pedidos) {
        List<PedidoModel> pedidosModel = new ArrayList<>();
        for (Pedido pedido: pedidos) {
            PedidoModel pedidoModel = pedidoConverter.entityToModel(pedido);
            pedidosModel.add(pedidoModel);
        }
        return pedidosModel;
    }


    public void insertPedidos(List<PedidoModel> pedidosModel) {
        for (PedidoModel pedidoModel: pedidosModel) {
            insertPedido(pedidoModel);
        }

    }
}
