package com.ces.almacen.services;

import com.ces.almacen.converters.ProfesorConverter;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ProfesorModel;
import com.ces.almacen.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorConverter profesorConverter;


    public void insertProfesor(ProfesorModel profesorModel) {
        Profesor profesor = profesorConverter.modelToEntity(profesorModel);
        profesorRepository.save(profesor);
    }

    /*
    public Optional<ProfesorModel> insertProfesor (ProfesorModel profesorModel){
        Optional<ProfesorModel> result = Optional.empty();
        return result;

    }*/

    public Optional<ProfesorModel> deleteProfesor(Long id) {
        Optional<ProfesorModel> resultPm = Optional.empty();
        Optional<Profesor> result = profesorRepository.findById(id);
        if(result.isPresent()){
            Profesor profesor = result.get();
            ProfesorModel profesorModel = profesorConverter.entityToModel(profesor);
            resultPm = Optional.of(profesorModel);
            profesorRepository.delete(profesor);
        }
        return resultPm;
    }

    public Optional<ProfesorModel> getProfesor(Long id) {
        Optional<ProfesorModel> resultPm = Optional.empty();
        Optional<Profesor> result = profesorRepository.findById(id);
        if(result.isPresent()){
            Profesor profesor = result.get();
            ProfesorModel profesorModel = profesorConverter.entityToModel(profesor);
            resultPm = Optional.of(profesorModel);
        }
        return resultPm;
    }
}
