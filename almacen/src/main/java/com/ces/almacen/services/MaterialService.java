package com.ces.almacen.services;

import com.ces.almacen.converters.MaterialConverter;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.MaterialModel;
import com.ces.almacen.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private MaterialConverter materialConverter;

    public void insertMaterial(MaterialModel materialModel) {
        Material material = materialConverter.modelToEntity(materialModel);
        materialRepository.save(material);
    }

    public Optional<MaterialModel> deleteMaterial(Long id) {
        Optional<MaterialModel> resultMm = Optional.empty();
        Optional<Material> result = materialRepository.findById(id);
        if(result.isPresent()){
            Material material = result.get();
            MaterialModel materialModel = materialConverter.entityToModel(material);
            resultMm = Optional.of(materialModel);
            materialRepository.delete(material);
        }
        return resultMm;
    }
}
