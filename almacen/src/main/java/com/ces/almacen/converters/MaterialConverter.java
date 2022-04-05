package com.ces.almacen.converters;

import com.ces.almacen.entities.Material;
import com.ces.almacen.models.MaterialModel;
import org.springframework.stereotype.Component;

@Component
public class MaterialConverter {
    public MaterialModel entityToModel(Material material){
        MaterialModel materialModel = new MaterialModel();
        materialModel.setId(material.getId());
        materialModel.setNombre(material.getNombre());
        return materialModel;
    }
    public Material modelToEntity(MaterialModel materialModel){
        Material material = new Material();
        material.setId(material.getId());
        material.setNombre(materialModel.getNombre());
        return material;
    }
}
