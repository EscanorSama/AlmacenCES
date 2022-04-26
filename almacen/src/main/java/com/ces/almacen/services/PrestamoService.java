package com.ces.almacen.services;

import com.ces.almacen.converters.PrestamoConverter;
import com.ces.almacen.entities.Prestamo;
import com.ces.almacen.models.LineaPrestamoModel;
import com.ces.almacen.models.PrestamoModel;
import com.ces.almacen.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoConverter prestamoConverter;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LineaPrestamoService lineaPrestamoService;

    public void insertPrestamo(PrestamoModel prestamoModel) {
        List<LineaPrestamoModel> lineasPrestamoModel = prestamoModel.getLineasPrestamo();
        Prestamo prestamo = prestamoRepository.save(prestamoConverter.modelToEntity(prestamoModel));
        for (LineaPrestamoModel lineaPrestamoModel: lineasPrestamoModel) {
            lineaPrestamoModel.setPrestamoId(prestamo.getId());
            lineaPrestamoService.insertLineaPrestamo(lineaPrestamoModel);
        }
    }

    public List<PrestamoModel> getPrestamos() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        List<PrestamoModel> prestamosModel = new ArrayList<>();
        for (Prestamo prestamo: prestamos) {
            PrestamoModel prestamoModel = prestamoConverter.entityToModel(prestamo);
            prestamosModel.add(prestamoModel);
        }
        return prestamosModel;
    }

    public Optional<PrestamoModel> deletePrestamo(Long id) {
        Optional<PrestamoModel> resultPm = Optional.empty();
        Optional<Prestamo> result = prestamoRepository.findById(id);
        if (result.isPresent()){
            Prestamo prestamo = result.get();
            PrestamoModel prestamoModel = prestamoConverter.entityToModel(prestamo);
            resultPm = Optional.of(prestamoModel);
            prestamoRepository.delete(prestamo);
        }
        return resultPm;
    }

    public Optional<PrestamoModel> getPrestamo(Long id) {
        Optional<PrestamoModel> resultPm = Optional.empty();
        Optional<Prestamo> result = prestamoRepository.findById(id);
        if(result.isPresent()){
            Prestamo prestamo = result.get();
            PrestamoModel prestamoModel = prestamoConverter.entityToModel(prestamo);
            resultPm = Optional.of(prestamoModel);
        }
        return resultPm;
    }
}
