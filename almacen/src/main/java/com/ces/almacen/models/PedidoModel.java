package com.ces.almacen.models;

import com.ces.almacen.entities.LineaPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PedidoModel {
    private long id;
    private Date fecha;
    List<LineaPedidoModel> lineasPedido;
}
