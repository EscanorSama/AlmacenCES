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

        return material;
    }
}
