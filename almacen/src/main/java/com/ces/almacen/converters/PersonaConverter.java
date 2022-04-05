package com.ces.almacen.converters;

import com.ces.almacen.entities.Persona;
import com.ces.almacen.models.PersonaModel;
import org.springframework.stereotype.Component;

@Component
public class PersonaConverter {
    public PersonaModel entityToModel(Persona persona){
        PersonaModel personaModel = new PersonaModel();
        personaModel.setPersonaId(persona.getId());
        personaModel.setMail(persona.getMail());
        personaModel.setNombre(persona.getNombre());
        personaModel.setApellido(persona.getApellido());
        personaModel.setDni(persona.getDni());
        return personaModel;
    }

    public Persona modelToEntity (PersonaModel personaModel){
        Persona persona = new Persona();
        persona.setId(personaModel.getPersonaId());
        persona.setMail(personaModel.getMail());
        persona.setNombre(personaModel.getNombre());
        persona.setApellido(personaModel.getApellido());
        persona.setDni(personaModel.getDni());
        return persona;
    }
}
