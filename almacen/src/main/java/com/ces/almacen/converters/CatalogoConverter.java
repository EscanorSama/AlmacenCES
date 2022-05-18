package com.ces.almacen.converters;

import com.ces.almacen.entities.Catalogo;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.CatalogoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogoConverter {

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    public CatalogoModel entityToModel(Catalogo catalogo){
        CatalogoModel catalogoModel = new CatalogoModel();
        catalogoModel.setCatalogoId(catalogo.getCatalogoId());
        catalogoModel.setContenedorId(catalogo.getContenedor().getId());
        catalogoModel.setDescripcion("");
        catalogoModel.setNumero(0);
        catalogoModel.setZona("");
        catalogoModel.setTipo("Catalogo");
        catalogoModel.setLineasAlmacen(lineaAlmacenConverter.listEntityToListModel(catalogo.getContenedor().getLineasAlmacen()));
        return catalogoModel;
    }

    public Catalogo modelToEntity(CatalogoModel catalogoModel){
        Catalogo catalogo = new Catalogo();
        catalogo.setCatalogoId(catalogoModel.getCatalogoId());
        catalogoModel.setTipo("");
        catalogoModel.setZona("");
        catalogoModel.setTipo("Catalogo");
        catalogoModel.setNumero(0);
        catalogoModel.setDescripcion("");

        Contenedor contenedor = new Contenedor();
        contenedor.setId(catalogoModel.getContenedorId());
        contenedor.setDescripcion(catalogoModel.getDescripcion());
        contenedor.setZona(catalogoModel.getZona());
        contenedor.setNumero(catalogoModel.getNumero());
        contenedor.setTipo("Catalogo");
        contenedor.setLineasAlmacen(lineaAlmacenConverter.listModelToListEntity(catalogoModel.getLineasAlmacen()));

        return catalogo;
    }
}
