package com.ces.almacen.services;

import com.ces.almacen.converters.AulaConverter;
import com.ces.almacen.entities.Aula;
import com.ces.almacen.entities.Categoria;
import com.ces.almacen.models.AulaModel;
import com.ces.almacen.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    private AulaConverter aulaConverter;

    @Autowired
    private AulaRepository aulaRepository;

    public void insertAula(AulaModel aulaModel){
        Aula aula = aulaConverter.modelToEntity(aulaModel);
        aulaRepository.save(aula);
    }

    public List<AulaModel> getAulas() {
        List<Aula> aulas = aulaRepository.findAll();
        List<AulaModel> aulasModel = new ArrayList<>();
        for (Aula aula: aulas) {
            AulaModel aulaModel = aulaConverter.entityToModel(aula);
            aulasModel.add(aulaModel);
        }
        return aulasModel;
    }

    public Optional<AulaModel> deleteAula(Long id) {
        Optional<AulaModel> resultAm = Optional.empty();
        Optional<Aula> result = aulaRepository.findById(id);
        if(result.isPresent()){
            Aula aula = result.get();
            AulaModel aulaModel = aulaConverter.entityToModel(aula);
            resultAm = Optional.of(aulaModel);
            aulaRepository.delete(aula);
        }
        return resultAm;
    }

    public Optional<AulaModel> getAula(Long id) {
        Optional<AulaModel> resultAm = Optional.empty();
        Optional<Aula> result = aulaRepository.findById(id);
        if(result.isPresent()){
            Aula aula = result.get();
            AulaModel aulaModel = aulaConverter.entityToModel(aula);
            resultAm = Optional.of(aulaModel);
        }
        return resultAm;
    }
}
