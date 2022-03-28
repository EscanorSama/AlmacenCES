package com.ces.almacen.services;

import com.ces.almacen.converters.ContenedorConverter;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.ContenedorModel;
import com.ces.almacen.repositories.ContenedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContenedorService {
    @Autowired
    private ContenedorRepository contenedorRepository;

    @Autowired
    private ContenedorConverter contenedorConverter;

    public void insertContenedor(ContenedorModel contenedorModel) {
        Contenedor contenedor = contenedorConverter.modelToEntity(contenedorModel);
        contenedorRepository.save(contenedor);
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
}
