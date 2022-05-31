package com.ces.almacen.converters;

import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.ContenedorModel;
import com.ces.almacen.models.LineaAlmacenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LineaAlmacenConverter {

    @Autowired
    private ContenedorConverter contenedorConverter;


    public LineaAlmacenModel entityToModel(LineaAlmacen lineaAlmacen){
        LineaAlmacenModel lineaAlmacenModel = new LineaAlmacenModel();
        lineaAlmacenModel.setId(lineaAlmacen.getId());
        lineaAlmacenModel.setCantidad(lineaAlmacen.getCantidad());
        lineaAlmacenModel.setFecha(lineaAlmacen.getFecha());
        //lineaAlmacenModel.setContenedorId(lineaAlmacen.getContenedor().getId());
        Contenedor contenedor = lineaAlmacen.getContenedor();
        lineaAlmacenModel.setContenedor(contenedorConverter.entityToModel(contenedor));
        lineaAlmacenModel.setMaterialId(lineaAlmacen.getMaterial().getId());
        return lineaAlmacenModel;
    }

    public LineaAlmacen modelToEntity(LineaAlmacenModel lineaAlmacenModel){
        LineaAlmacen lineaAlmacen = new LineaAlmacen();
        lineaAlmacen.setId(lineaAlmacenModel.getId());
        lineaAlmacen.setCantidad(lineaAlmacenModel.getCantidad());
        lineaAlmacen.setFecha(lineaAlmacenModel.getFecha());



        Material material = new Material();
        material.setId(lineaAlmacenModel.getMaterialId());
        lineaAlmacen.setMaterial(material);


        Contenedor contenedor = new Contenedor();
        contenedor.setId(lineaAlmacenModel.getContenedor().getContenedorId());
        lineaAlmacen.setContenedor(contenedor);

        /*if (contenedor.getTipo().equals("Catalogo")){
            lineaAlmacen.setCantidad(0);
        }*/

        return lineaAlmacen;
    }

    public List<LineaAlmacenModel> listEntityToListModel(List<LineaAlmacen> lineasAlmacen){
        List<LineaAlmacenModel> lineasAlmacenModel = new ArrayList<>();
        if(lineasAlmacen!=null) {
            for (LineaAlmacen lineaAlmacen : lineasAlmacen) {
                LineaAlmacenModel lineaAlmacenModel = this.entityToModel(lineaAlmacen);
                lineasAlmacenModel.add(lineaAlmacenModel);
            }
        }
        return lineasAlmacenModel;
    }

    public List<LineaAlmacen> listModelToListEntity(List<LineaAlmacenModel> lineasAlmacenModel){
        List<LineaAlmacen> lineasAlmacen = new ArrayList<>();
        for (LineaAlmacenModel lineaAlmacenModel: lineasAlmacenModel) {
            LineaAlmacen lineaAlmacen = this.modelToEntity(lineaAlmacenModel);
            lineasAlmacen.add(lineaAlmacen);
        }
        return lineasAlmacen;
    }

}
