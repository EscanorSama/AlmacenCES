package com.ces.almacen.services;

import com.ces.almacen.converters.AlmacenConverter;
import com.ces.almacen.entities.Almacen;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.models.AlmacenModel;
import com.ces.almacen.repositories.AlmacenRepository;
import com.ces.almacen.repositories.ContenedorRepository;



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

    public List<AlmacenModel> getAlmacenesPag(int nPag, int tPag){
        Pageable pageable =  PageRequest.of(nPag, tPag);
        Page<Almacen> almacenesPag = almacenRepository.findAll(pageable);
        List<Almacen> almacenes = almacenesPag.getContent();
        List<AlmacenModel> almacenesModel = listAlmacenToListAlmacenModel(almacenes);
        return almacenesModel;
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

    public Optional<AlmacenModel> deleteAlmacen(Long id) {
        Optional<AlmacenModel> resultAm = Optional.empty();
        Optional<Almacen> result = almacenRepository.findById(id);
        if (result.isPresent()){
            Almacen almacen =  result.get();
            AlmacenModel almacenModel = almacenConverter.entityToModel(almacen);
            resultAm = Optional.of(almacenModel);
            almacenRepository.delete(almacen);
        }
        return resultAm;
    }

    public void updateAlmacen(AlmacenModel almacenModel) {
        Optional<Almacen> result = almacenRepository.findById(almacenModel.getAlmacenId());
        log.info("******* AlmacenService"+ almacenModel.getZona());
        if (result.isPresent()) {
            Almacen almacen = result.get();
            Contenedor contenedor = almacen.getContenedor();
            log.info("****** "+contenedor.getId());
            contenedor.setZona(almacenModel.getZona());
            contenedor.setNumero(almacenModel.getNumero());
            contenedor.setDescripcion(almacenModel.getDescripcion());
            contenedorRepository.save(contenedor);
            almacenRepository.save(almacen);
        }else{
            log.info("***** Almacén no encontrado");
        }
    }

    public List<AlmacenModel> insertAlmacenes(List<AlmacenModel> almacenesModel) {
        for (AlmacenModel almacenModel: almacenesModel) {
            insertAlmacen(almacenModel);
        }
        return almacenesModel;
    }

    public int getNumAlmacenes() {
        List<Almacen> almacenes = almacenRepository.findAll();
        return almacenes.size();
    }
}
