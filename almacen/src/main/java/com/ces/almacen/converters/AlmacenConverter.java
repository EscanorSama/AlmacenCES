package com.ces.almacen.converters;

import com.ces.almacen.entities.Almacen;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.AlmacenModel;
import org.springframework.stereotype.Component;

@Component
public class AlmacenConverter {
    public AlmacenModel entityToModel(Almacen almacen){
        AlmacenModel almacenModel = new AlmacenModel();
        almacenModel.setId(almacen.getId());
        almacenModel.setContenedor_id(almacen.getContenedor().getId());
        return almacenModel;
    }

    public Almacen modelToEntity(AlmacenModel almacenModel){
        Almacen almacen = new Almacen();
        almacen.setId(almacenModel.getId());
        Contenedor contenedor = new Contenedor();
        contenedor.setId(almacenModel.getContenedor_id());
        almacen.setContenedor(contenedor);
        return almacen;
    }
}
