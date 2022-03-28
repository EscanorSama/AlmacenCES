package com.ces.almacen.converters;

import com.ces.almacen.entities.Almacen;
import com.ces.almacen.models.AlmacenModel;
import org.springframework.stereotype.Component;

@Component
public class AlmacenConverter {
    public AlmacenModel entityToModel(Almacen almacen){
        AlmacenModel almacenModel = new AlmacenModel();
        almacenModel.setId(almacen.getId());
        return almacenModel;
    }

    public Almacen modelToEntity(AlmacenModel almacenModel){
        Almacen almacen = new Almacen();
        almacen.setId(almacenModel.getId());
        return almacen;
    }
}
