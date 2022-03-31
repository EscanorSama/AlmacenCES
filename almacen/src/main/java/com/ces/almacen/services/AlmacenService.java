package com.ces.almacen.services;

import com.ces.almacen.converters.AlmacenConverter;
import com.ces.almacen.entities.Almacen;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.AlmacenModel;
import com.ces.almacen.repositories.AlmacenRepository;
import com.ces.almacen.repositories.ContenedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {
    @Autowired
    private AlmacenRepository almacenRepository;

    @Autowired
    private AlmacenConverter almacenConverter;

    @Autowired
    private ContenedorService contenedorService;

    @Autowired
    private ContenedorRepository contenedorRepository;



    public AlmacenModel insertAlmacen(AlmacenModel almacenModel) {
        Contenedor contenedor = contenedorService.insertContenedor(almacenModel);
        Almacen almacen = almacenConverter.modelToEntity(almacenModel);
        almacen.setContenedor(contenedor);
        almacenModel.setAlmacenId(almacenRepository.save(almacen).getId());
        return almacenModel;
    }



    /*
    public AlmacenModel deleteAlmacen(Long id) {
        Optional<Almacen> almacen = almacenRepository.findById(id);
        if (almacen.isPresent()){
            AlmacenModel almacenModel = almacenConverter.entityToModel(almacen.get());
            Long contenedorId = almacenModel.getContenedorId();
            almacenRepository.delete(almacen.get());
            Optional<Contenedor> contenedor = contenedorRepository.findById(contenedorId);
            contenedorRepository.delete(contenedor.get());
            return almacenConverter.entityToModel(almacen.get());
        }
        return null;

    }*/

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

    public List<AlmacenModel> getAlmacenes() {
        List<Almacen> almacenes = almacenRepository.findAll();
        List<AlmacenModel> almacenesModels = listAlmacenToListAlmacenModel(almacenes);
        return almacenesModels;
    }

    private List<AlmacenModel> listAlmacenToListAlmacenModel(List<Almacen> almacenes) {
        List<AlmacenModel> almacenesModel = new ArrayList<>();
        for (Almacen almacen: almacenes) {
            AlmacenModel almacenModel = almacenConverter.entityToModel(almacen);
            almacenesModel.add(almacenModel);
        }
        return almacenesModel;
    }



}
