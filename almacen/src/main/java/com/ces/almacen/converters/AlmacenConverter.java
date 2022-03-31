package com.ces.almacen.converters;

import com.ces.almacen.entities.Almacen;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.AlmacenModel;
import org.springframework.stereotype.Component;

@Component
public class AlmacenConverter {
    public AlmacenModel entityToModel(Almacen almacen){
        AlmacenModel almacenModel = new AlmacenModel();
        almacenModel.setAlmacenId(almacen.getId());
        almacenModel.setDescripcion(almacen.getContenedor().getDescripcion());
        almacenModel.setZona(almacen.getContenedor().getZona());
        almacenModel.setNumero(almacen.getContenedor().getNumero());

        return almacenModel;
    }

    public Almacen modelToEntity(AlmacenModel almacenModel){
        Almacen almacen = new Almacen();
        almacen.setId(almacenModel.getAlmacenId());
        return almacen;
    }
}
