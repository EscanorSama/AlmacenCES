package com.ces.almacen.converters;

import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.models.ContenedorModel;
import com.ces.almacen.models.LineaAlmacenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContenedorConverter {



    public ContenedorModel entityToModel(Contenedor contenedor){
        ContenedorModel contenedorModel = new ContenedorModel();
        contenedorModel.setContenedorId(contenedor.getId());
        contenedorModel.setZona(contenedor.getZona());
        contenedorModel.setDescripcion(contenedor.getDescripcion());
        contenedorModel.setNumero(contenedor.getNumero());
        contenedorModel.setTipo(contenedor.getTipo());
        /*List<LineaAlmacen> lineasAlmacen = contenedor.getLineasAlmacen();
        List<LineaAlmacenModel> lineasAlmacenModel = lineaAlmacenConverter.listEntityToListModel(lineasAlmacen);
        contenedorModel.setLineasAlmacen(lineasAlmacenModel);*/

        return contenedorModel;
    }
    public Contenedor modelToEntity(ContenedorModel contenedorModel,String tipo){
        Contenedor contenedor = new Contenedor();
        contenedor.setId(contenedorModel.getContenedorId());
        contenedor.setZona(contenedorModel.getZona());
        contenedor.setDescripcion(contenedorModel.getDescripcion());
        contenedor.setNumero(contenedorModel.getNumero());
        contenedor.setTipo(tipo);
        /*List<LineaAlmacenModel> lineasAlmacenModel = contenedorModel.getLineasAlmacen();
        List<LineaAlmacen> lineasAlmacen = lineaAlmacenConverter.listModelToListEntity(lineasAlmacenModel);
        contenedor.setLineasAlmacen(lineasAlmacen);*/
        return contenedor;
    }
}
