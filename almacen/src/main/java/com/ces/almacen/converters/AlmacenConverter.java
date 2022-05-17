package com.ces.almacen.converters;

import com.ces.almacen.entities.Almacen;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.AlmacenModel;
import com.ces.almacen.models.LineaAlmacenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlmacenConverter {

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    public AlmacenModel entityToModel(Almacen almacen){
        AlmacenModel almacenModel = new AlmacenModel();
        almacenModel.setAlmacenId(almacen.getId());
        almacenModel.setDescripcion(almacen.getContenedor().getDescripcion());
        almacenModel.setZona(almacen.getContenedor().getZona());
        almacenModel.setNumero(almacen.getContenedor().getNumero());
        almacenModel.setTipo("Almacen");
        return almacenModel;
    }

    public Almacen modelToEntity(AlmacenModel almacenModel){
        Almacen almacen = new Almacen();
        almacen.setId(almacenModel.getAlmacenId());
        Contenedor contenedor = new Contenedor();
        contenedor.setZona(almacenModel.getZona());
        contenedor.setDescripcion(almacenModel.getDescripcion());
        contenedor.setTipo("Almacen");
        contenedor.setNumero(almacenModel.getNumero());
        List<LineaAlmacenModel> lineasAlmacenModel = almacenModel.getLineasAlmacen();
        contenedor.setLineasAlmacen(lineaAlmacenConverter.listModelToListEntity(lineasAlmacenModel));
        return almacen;
    }
}
