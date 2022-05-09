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

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        lineaAlmacenModel.setCantidad(materialModel.getNumUnidades());
        lineaAlmacenModel.setFecha(new java.sql.Date(new Date().getTime()));
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

    public List<MaterialModel> getMaterialesPag(int nPag , int tPag) {
        Pageable pageable = PageRequest.of(nPag, tPag);
        Page<Material> materialesPag = materialRepository.findAll(pageable);
        List<Material> materiales = materialesPag.getContent();
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materiales);
        return materialesModel;
    }
    public List<MaterialModel> getMaterialMarca(int nPag, String marca, int tPag){
        Pageable pageable = PageRequest.of(nPag,tPag);
        Page<Material> materialesMarcaPag = materialRepository.findByMarca(marca, pageable);
        List<Material> materialesMarca= materialesMarcaPag.getContent();
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materialesMarca);
        return materialesModel;
    }

    public List<MaterialModel> getMaterialProveedor(int nPag, String proveedor, int tPag){
        Pageable pageable = PageRequest.of(nPag, tPag);
        Page<Material> materialesProveedorPag = materialRepository.findByProveedor(proveedor, pageable);
        List<Material> materialesProveedor = materialesProveedorPag.getContent();
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materialesProveedor);
        return materialesModel;
    }



    /*public List<MaterialModel> getMateriales(){
        List<Material> materiales = materialRepository.findAll();
        List<MaterialModel> materialesModel = listMaterialesToMaterialesModel(materiales);
        return materialesModel;
    }*/

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


    public List<MaterialModel> deleteMateriales(List<MaterialModel> materialesModel) {
        List<MaterialModel> materialesModelFinales = new ArrayList<>();
        for (MaterialModel materialModel: materialesModel) {
            Material materialConvertido = materialConverter.modelToEntity(materialModel);
            Optional<Material> result = materialRepository.findById(materialConvertido.getId());
            if (result.isPresent()){
                Material material = result.get();
                MaterialModel materialModelConvertido = materialConverter.entityToModel(material);
                materialesModelFinales.add(materialModelConvertido);
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
            material.setFungible(materialModel.isFungible());
            material.setFechaUso(materialModel.getFechaUso());
            material.setFechaFinUso(materialModel.getFechaFinUso());
            List<LineaAlmacenModel> lineasAlmacenModel = materialModel.getLineasAlmacen();
            List<LineaAlmacen> lineasAlmacen = lineaAlmacenConverter.listModelToListEntity(lineasAlmacenModel);
            material.setLineasAlmacen(lineasAlmacen);
            materialRepository.save(material);
            materialModelModificado = materialConverter.entityToModel(material);
        }
        return materialModelModificado;
    }



    public int getNumMateriales() {
        int numMateriales = 0;
        List<Material> materiales = materialRepository.findAll();
        for (Material material : materiales) {
            numMateriales = materiales.size();
        }
        return numMateriales;
    }
}
