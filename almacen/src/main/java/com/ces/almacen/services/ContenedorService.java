package com.ces.almacen.services;

import com.ces.almacen.converters.ContenedorConverter;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.ContenedorModel;
import com.ces.almacen.repositories.ContenedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContenedorService {
    @Autowired
    private ContenedorRepository contenedorRepository;

    @Autowired
    private ContenedorConverter contenedorConverter;

    public Contenedor insertContenedor(ContenedorModel contenedorModel) {
        Contenedor contenedor = contenedorConverter.modelToEntity(contenedorModel);
        return contenedorRepository.save(contenedor);
    }

    public Optional<ContenedorModel> deleteContenedor(Long id) {
        Optional<ContenedorModel> resultCm = Optional.empty();
        Optional<Contenedor> result = contenedorRepository.findById(id);
        if(result.isPresent()){
            Contenedor contenedor = result.get();
            ContenedorModel contenedorModel = contenedorConverter.entityToModel(contenedor);
            resultCm = Optional.of(contenedorModel);
            contenedorRepository.delete(contenedor);
        }
        return resultCm;
    }

    public Optional<ContenedorModel> getContenedor(Long id) {
        Optional<ContenedorModel> resultCm = Optional.empty();
        Optional<Contenedor> result = contenedorRepository.findById(id);
        if (result.isPresent()){
            Contenedor contenedor = result.get();
            ContenedorModel contenedorModel = contenedorConverter.entityToModel(contenedor);
            resultCm = Optional.of(contenedorModel);
        }
        return resultCm;
    }

    public List<ContenedorModel> getContenedorZona(String zona) {
        List<Contenedor> contenedores = contenedorRepository.findByZona(zona);
        List<ContenedorModel> contenedoresModel = listContenedorToListContenedorModel(contenedores);
        return contenedoresModel;
    }

    private List<ContenedorModel> listContenedorToListContenedorModel(List<Contenedor> contenedores) {
        List<ContenedorModel> contenedoresModel = new ArrayList<>();
        for (Contenedor contenedor: contenedores) {
            ContenedorModel contenedorModel = contenedorConverter.entityToModel(contenedor);
            contenedoresModel.add(contenedorModel);
        }
        return contenedoresModel;
    }

    public List<ContenedorModel> getContenedorDescripcion(String descripcion) {
        List<Contenedor> contenedores = contenedorRepository.findByDescripcion(descripcion);
        List<ContenedorModel> contenedoresModel = listContenedorToListContenedorModel(contenedores);
        return contenedoresModel;
    }

    public List<ContenedorModel> getContenedorNumero(Integer numero) {
        List<Contenedor> contenedores = contenedorRepository.findByNumero(numero);
        List<ContenedorModel> contenedoresModel = listContenedorToListContenedorModel(contenedores);
        return contenedoresModel;
    }

    public List<ContenedorModel> getContenedores() {
        List<Contenedor> contenedores = contenedorRepository.findAll();
        List<ContenedorModel> contenedoresModel = listContenedorToListContenedorModel(contenedores);
        return contenedoresModel;
    }

}
