package com.ces.almacen.converters;

import com.ces.almacen.entities.Categoria;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.CategoriaModel;
import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.models.MaterialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialConverter {

    @Autowired
    private CategoriaConverter categoriaConverter;

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    public MaterialModel entityToModel(Material material){
        MaterialModel materialModel = new MaterialModel();
        materialModel.setId(material.getId());
        materialModel.setNombre(material.getNombre());
        materialModel.setDescripcion(material.getDescripcion());
        materialModel.setMarca(material.getMarca());
        materialModel.setProveedor(material.getProveedor());
        materialModel.setMinimoStock(material.getMinimoStock());
        materialModel.setObservaciones(material.getObservaciones());
        materialModel.setPrecio(material.getPrecio());
        materialModel.setFungible(material.isFungible());
        materialModel.setFechaUso(material.getFechaUso());
        materialModel.setFechaFinUso(material.getFechaFinUso());

        List<LineaAlmacen> lineasAlmacen = material.getLineasAlmacen();
        List<LineaAlmacenModel> lineasAlmacenModel = lineaAlmacenConverter.listEntityToListModel(lineasAlmacen);
        materialModel.setLineasAlmacen(lineasAlmacenModel);

        List<CategoriaModel> categoriasModel = categoriaConverter.listEntityToListModel(material.getCategorias());
        materialModel.setCategorias(categoriasModel);
        return materialModel;
    }


    public Material modelToEntity(MaterialModel materialModel){
        Material material = new Material();
        material.setId(materialModel.getId());
        material.setNombre(materialModel.getNombre());
        material.setDescripcion(materialModel.getDescripcion());
        material.setMarca(materialModel.getMarca());
        material.setProveedor(materialModel.getProveedor());
        material.setMinimoStock(materialModel.getMinimoStock());
        material.setObservaciones(materialModel.getObservaciones());
        material.setPrecio(materialModel.getPrecio());
        material.setFungible(materialModel.isFungible());
        material.setFechaUso(materialModel.getFechaUso());
        material.setFechaFinUso(materialModel.getFechaFinUso());
        material.setLineasAlmacen(lineaAlmacenConverter.listModelToListEntity(materialModel.getLineasAlmacen()));


        List<Categoria> categorias = categoriaConverter.listModelToListEntity(materialModel.getCategorias());
        material.setCategorias(categorias);
        return material;
    }


    public List<MaterialModel> listEntityToListModel(List<Material> materiales){
        List<MaterialModel> materialesModel = new ArrayList<>();
        for (Material material: materiales) {
            MaterialModel materialModel = this.entityToModel(material);
            materialesModel.add(materialModel);
        }
        return materialesModel;
    }

    public List<MaterialModel> listEntityToListModelLineasAlmacen(List<Material> materiales){
        List<MaterialModel> materialesModel = new ArrayList<>();
        for (Material material: materiales) {

                MaterialModel materialModel = this.entityToModel(material);
                materialesModel.add(materialModel);



        }
        return materialesModel;
    }

    public List<Material> listModelToListEntity(List<MaterialModel> materialesModel){
        List<Material> materiales = new ArrayList<>();
        for (MaterialModel materialModel: materialesModel) {
            Material material = this.modelToEntity(materialModel);
            materiales.add(material);
        }
        return materiales;
    }
}
