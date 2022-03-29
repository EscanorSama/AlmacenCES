package com.ces.almacen.services;

import com.ces.almacen.converters.PersonaConverter;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.models.PersonaModel;
import com.ces.almacen.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaConverter personaConverter;
    @Autowired
    private PersonaRepository personaRepository;

    public void insertPersona(PersonaModel personaModel) {
        Persona persona = personaConverter.modelToEntity(personaModel);
        personaRepository.save(persona);
    }

    public Optional<PersonaModel> deletePersona(Long id) {
        Optional<PersonaModel> resultPm = Optional.empty();
        Optional<Persona> result = personaRepository.findById(id);
        if(result.isPresent()){
            Persona persona = result.get();
            PersonaModel personaModel = personaConverter.entityToModel(persona);
            resultPm = Optional.of(personaModel); //guardamos dentro de Optional el tipo de objeto que queramos
            personaRepository.delete(persona);
        }
        return resultPm;
    }

    public Optional<PersonaModel> getPersona(Long id) {
        Optional<PersonaModel> resultPm = Optional.empty();
        Optional<Persona> result = personaRepository.findById(id);
        if(result.isPresent()){
            Persona persona = result.get();
            PersonaModel personaModel = personaConverter.entityToModel(persona);
            resultPm = Optional.of(personaModel);
        }
        return resultPm;
    }
}
