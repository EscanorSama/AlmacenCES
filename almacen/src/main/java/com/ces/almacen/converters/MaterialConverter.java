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
        materialModel.setDescripcion(material.getDescripcion());
        materialModel.setMarca(material.getMarca());
        materialModel.setModelo(material.getModelo());
        materialModel.setNumSerie(material.getNumSerie());
        materialModel.setEstado(material.getEstado());
        return materialModel;
    }
    public Material modelToEntity(MaterialModel materialModel){
        Material material = new Material();
        material.setId(material.getId());
        material.setNombre(materialModel.getNombre());
        material.setDescripcion(materialModel.getDescripcion());
        material.setMarca(materialModel.getMarca());
        material.setModelo(materialModel.getModelo());
        material.setNumSerie(materialModel.getNumSerie());
        material.setEstado(materialModel.getEstado());
        return material;
    }
}
