package com.ces.almacen.services;

import com.ces.almacen.converters.AlumnoConverter;
import com.ces.almacen.entities.Alumno;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.models.AlumnoModel;
import com.ces.almacen.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoConverter alumnoConverter;

    @Autowired
    private PersonaService personaService;

    public AlumnoModel insertAlumno(AlumnoModel alumnoModel) {
        Persona persona = personaService.insertPersona(alumnoModel);
        Alumno alumno = alumnoConverter.modelToEntity(alumnoModel);
        alumno.setPersona(persona);
        alumno.setId(alumnoRepository.save(alumno).getId());
        return alumnoModel;
    }

    public Optional<AlumnoModel> deleteAlumno(Long id) {
        Optional<AlumnoModel> resultAm = Optional.empty();
        Optional<Alumno> result = alumnoRepository.findById(id);
        if(result.isPresent()){
            Alumno alumno = result.get();
            AlumnoModel alumnoModel = alumnoConverter.entityToModel(alumno);
            resultAm = Optional.of(alumnoModel);
            alumnoRepository.delete(alumno);
        }
        return resultAm;
    }

    public Optional<AlumnoModel> getAlumno(Long id) {
        Optional<AlumnoModel> resultAm = Optional.empty();
        Optional<Alumno> result = alumnoRepository.findById(id);
        if(result.isPresent()){
            Alumno alumno = result.get();
            AlumnoModel alumnoModel = alumnoConverter.entityToModel(alumno);
            resultAm = Optional.of(alumnoModel);
        }
        return resultAm;
    }
}
