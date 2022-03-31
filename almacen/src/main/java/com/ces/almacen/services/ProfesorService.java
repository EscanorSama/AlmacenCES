package com.ces.almacen.services;

import com.ces.almacen.converters.ProfesorConverter;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ProfesorModel;
import com.ces.almacen.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorConverter profesorConverter;

    @Autowired
    private PersonaService personaService;


    public ProfesorModel insertProfesor(ProfesorModel profesorModel) {
        Persona persona = personaService.insertPersona(profesorModel);
        Profesor profesor = profesorConverter.modelToEntity(profesorModel);
        profesor.setPersona(persona);
        profesorModel.setId(profesorRepository.save(profesor).getId());
        return profesorModel;
    }



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

    public List<ProfesorModel> getProfesores() {
        List<Profesor>profesores = profesorRepository.findAll();
        List<ProfesorModel> profesoresModel = listProfesoresToListProfesoresModel(profesores);
        return profesoresModel;
    }

    private List<ProfesorModel> listProfesoresToListProfesoresModel(List<Profesor> profesores) {
        List<ProfesorModel> profesoresModel = new ArrayList<>();
        for (Profesor profesor : profesores) {
            ProfesorModel profesorModel = profesorConverter.entityToModel(profesor);
            profesoresModel.add(profesorModel);
        }
        return profesoresModel;
    }

    public List<ProfesorModel> insertProfesores(List<ProfesorModel> profesoresModel) {
        for (ProfesorModel profesorModel: profesoresModel) {
            insertProfesor(profesorModel);
        }
        return profesoresModel;
    }
}
