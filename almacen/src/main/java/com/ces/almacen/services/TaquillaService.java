package com.ces.almacen.services;

import com.ces.almacen.converters.TaquillaConverter;
import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.models.TaquillaModel;
import com.ces.almacen.repositories.TaquillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaquillaService {
    @Autowired
    private TaquillaRepository taquillaRepository;
    @Autowired
    private TaquillaConverter taquillaConverter;

    public void insertTaquilla(TaquillaModel taquillaModel) {
        Taquilla taquilla = taquillaConverter.modelToEntity(taquillaModel);
        taquillaRepository.save(taquilla);
    }

    public Optional<TaquillaModel> deleteTaquilla(Long id) {
        Optional<TaquillaModel> resultTm = Optional.empty();
        Optional<Taquilla> result = taquillaRepository.findById(id);
        if(result.isPresent()){
            Taquilla taquilla = result.get();
            TaquillaModel taquillaModel = taquillaConverter.entityToModel(taquilla);
            resultTm = Optional.of(taquillaModel);
            taquillaRepository.delete(taquilla);
        }
        return resultTm;
    }
}
