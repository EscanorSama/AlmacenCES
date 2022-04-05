package com.ces.almacen.models;

import com.ces.almacen.entities.Material;
import com.ces.almacen.entities.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LineaPedidoModel {
    private long id;
    private int cantidad;

}
