package com.ces.almacen.converters;

import com.ces.almacen.entities.Categoria;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.CategoriaModel;
import com.ces.almacen.models.MaterialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialConverter {

    @Autowired
    private CategoriaConverter categoriaConverter;

    public MaterialModel entityToModel(Material material){
        MaterialModel materialModel = new MaterialModel();
        materialModel.setId(material.getId());
        materialModel.setNombre(material.getNombre());
        materialModel.setDescripcion(material.getDescripcion());
        materialModel.setMarca(material.getMarca());
        materialModel.setProveedor(material.getProveedor());
        materialModel.setNumUnidades(material.getNumUnidades());
        materialModel.setMinimoStock(material.getMinimoStock());
        materialModel.setObservaciones(material.getObservaciones());
        materialModel.setPrecio(material.getPrecio());

        List<CategoriaModel> categoriasModel = categoriaConverter.listEntityToListModel(material.getCategorias());
        materialModel.setCategorias(categoriasModel);
        return materialModel;
    }


    public Material modelToEntity(MaterialModel materialModel){
        Material material = new Material();
        material.setId(material.getId());
        material.setNombre(materialModel.getNombre());
        material.setDescripcion(materialModel.getDescripcion());
        material.setMarca(materialModel.getMarca());
        material.setProveedor(materialModel.getProveedor());
        material.setNumUnidades(materialModel.getNumUnidades());
        material.setMinimoStock(materialModel.getMinimoStock());
        material.setObservaciones(materialModel.getObservaciones());
        material.setPrecio(materialModel.getPrecio());

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

    public List<Material> listModelToListEntity(List<MaterialModel> materialesModel){
        List<Material> materiales = new ArrayList<>();
        for (MaterialModel materialModel: materialesModel) {
            Material material = this.modelToEntity(materialModel);
            materiales.add(material);
        }
        return materiales;
    }
}
