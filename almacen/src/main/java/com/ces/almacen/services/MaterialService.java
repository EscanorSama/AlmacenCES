package com.ces.almacen.services;

import com.ces.almacen.converters.LineaAlmacenConverter;
import com.ces.almacen.converters.MaterialConverter;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.models.MaterialModel;
import com.ces.almacen.repositories.LineaAlmacenRepository;
import com.ces.almacen.repositories.MaterialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private MaterialConverter materialConverter;
    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;
    @Autowired
    private LineaAlmacenRepository lineaAlmacenRepository;

    public void insertMaterial(MaterialModel materialModel) {
        Material material = materialConverter.modelToEntity(materialModel);
        material = materialRepository.save(material);
        Long materialId = material.getId();
        LineaAlmacenModel lineaAlmacenModel = materialModel.getLineasAlmacen().get(0);
        lineaAlmacenModel.setMaterialId(materialId);
        LineaAlmacen lineaAlmacen = lineaAlmacenConverter.modelToEntity(lineaAlmacenModel);
        lineaAlmacenRepository.save(lineaAlmacen);
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

    public Optional<MaterialModel> getMaterial(Long id) {
        Optional<MaterialModel> resultMm = Optional.empty();
        Optional<Material> result = materialRepository.findById(id);
        if(result.isPresent()){
            Material material = result.get();
            MaterialModel materialModel = materialConverter.entityToModel(material);
            resultMm = Optional.of(materialModel);
        }
        return resultMm;
    }

    public List<MaterialModel> getMaterialesPag(int nPag) {
        Pageable pageable = PageRequest.of(nPag, 3);
        Page<Material> materialesPag = materialRepository.findAll(pageable);
        List<Material> materiales = materialesPag.getContent();
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materiales);
        return materialesModel;
    }

    public List<MaterialModel> getMateriales(){
        List<Material> materiales = materialRepository.findAll();
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materiales);
        return materialesModel;
    }

    private List<MaterialModel> listMaterialesToMaterialesModel(List<Material> materiales) {
        List<MaterialModel> materialesModel = new ArrayList<>();
        for (Material material:materiales) {
            MaterialModel materialModel = materialConverter.entityToModel(material);
            materialesModel.add(materialModel);
        }
        return materialesModel;
    }

    public List<MaterialModel> insertMateriales(List<MaterialModel> materialesModel) {
        for (MaterialModel materialModel: materialesModel) {
            insertMaterial(materialModel);
        }
        return materialesModel;
    }


    public List<MaterialModel> deleteMateriales(List<Long> ids) {
        List<MaterialModel> materialesModel = new ArrayList<>();
        for (Long id: ids) {
            Optional<Material> result = materialRepository.findById(id);
            if (result.isPresent()){
                Material material = result.get();
                MaterialModel materialModel = materialConverter.entityToModel(material);
                materialesModel.add(materialModel);
                log.info("**********"+ id);
                materialRepository.delete(material);
            }

        }
        return materialesModel;
    }

    public MaterialModel updateMaterial(MaterialModel materialModel) {
        MaterialModel materialModelModificado = new MaterialModel();
        Optional<Material> result = materialRepository.findById(materialModel.getId());
        if (result.isPresent()){
            Material material = result.get();
            material.setNombre(materialModel.getNombre());
            material.setDescripcion(materialModel.getDescripcion());
            material.setMarca(materialModel.getMarca());
            material.setProveedor(materialModel.getProveedor());
            material.setNumUnidades(materialModel.getNumUnidades());
            material.setMinimoStock(materialModel.getMinimoStock());
            material.setObservaciones(materialModel.getObservaciones());
            material.setPrecio(materialModel.getPrecio());
            materialRepository.save(material);
            materialModelModificado = materialConverter.entityToModel(material);
        }
        return materialModelModificado;
    }

    public List<MaterialModel> getMaterialMarca(String marca){
        List<Material> materiales = materialRepository.findByMarca(marca);
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materiales);
        return materialesModel;
    }

    public List<MaterialModel> getMaterialProveedor(String proveedor){
        List<Material> materiales = materialRepository.findByProveedor(proveedor);
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materiales);
        return materialesModel;
    }

    public List<MaterialModel> getMaterialBetweenPrecio(int precio1, int precio2){
        List<Material> materiales = materialRepository.findByPrecioBetween(precio1, precio2);
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materiales);
        return materialesModel;
    }
}
