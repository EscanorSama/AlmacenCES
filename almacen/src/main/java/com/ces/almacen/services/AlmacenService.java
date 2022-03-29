package com.ces.almacen.services;

import com.ces.almacen.converters.AlmacenConverter;
import com.ces.almacen.entities.Almacen;
import com.ces.almacen.models.AlmacenModel;
import com.ces.almacen.repositories.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {
    @Autowired
    private AlmacenRepository almacenRepository;

    @Autowired
    private AlmacenConverter almacenConverter;




    public void insertAlmacen(AlmacenModel almacenModel) {
        Almacen almacen = almacenConverter.modelToEntity(almacenModel);
        almacenRepository.save(almacen);
    }

    public Optional<AlmacenModel> deleteAlmacen(Long id) {
        Optional<AlmacenModel> resultAm = Optional.empty();
        Optional<Almacen>result = almacenRepository.findById(id);
        if(result.isPresent()){
            Almacen almacen = result.get();
            AlmacenModel almacenModel = almacenConverter.entityToModel(almacen);
            resultAm = Optional.of(almacenModel);
            resultAm = Optional.of(almacenModel);
            almacenRepository.delete(almacen);
        }
        return resultAm;
    }

    public Optional<AlmacenModel> getAlmacen(Long id) {
        Optional<AlmacenModel> resultAm = Optional.empty();
        Optional<Almacen> result = almacenRepository.findById(id);
        if (result.isPresent()){
            Almacen almacen = result.get();
            AlmacenModel almacenModel = almacenConverter.entityToModel(almacen);
            resultAm = Optional.of(almacenModel);
        }
        return resultAm;
    }
}
