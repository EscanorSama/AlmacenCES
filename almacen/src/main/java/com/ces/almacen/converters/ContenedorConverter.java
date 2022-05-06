package com.ces.almacen.converters;

import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.ContenedorModel;
import org.springframework.stereotype.Component;

@Component
public class ContenedorConverter {
    public ContenedorModel entityToModel(Contenedor contenedor){
        ContenedorModel contenedorModel = new ContenedorModel();
        contenedorModel.setContenedorId(contenedor.getId());
        contenedorModel.setZona(contenedor.getZona());
        contenedorModel.setDescripcion(contenedor.getDescripcion());
        contenedorModel.setNumero(contenedor.getNumero());
        contenedorModel.setTipo(contenedor.getTipo());
        return contenedorModel;
    }
    public Contenedor modelToEntity(ContenedorModel contenedorModel){
        Contenedor contenedor = new Contenedor();
        contenedor.setId(contenedorModel.getContenedorId());
        contenedor.setZona(contenedorModel.getZona());
        contenedor.setDescripcion(contenedorModel.getDescripcion());
        contenedor.setNumero(contenedorModel.getNumero());
        contenedor.setTipo(contenedorModel.getTipo());
        return contenedor;
    }
}
