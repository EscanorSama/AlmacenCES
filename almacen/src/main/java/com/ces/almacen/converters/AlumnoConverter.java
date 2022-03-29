package com.ces.almacen.converters;

import com.ces.almacen.entities.Alumno;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.models.AlumnoModel;
import org.springframework.stereotype.Component;

@Component
public class AlumnoConverter {
    public AlumnoModel entityToModel(Alumno alumno){
        AlumnoModel alumnoModel = new AlumnoModel();
        alumnoModel.setId(alumno.getId());
        alumnoModel.setPersona_id(alumno.getPersona().getId());
        return alumnoModel;
    }

    public Alumno modelToEntity(AlumnoModel alumnoModel){
        Alumno alumno = new Alumno();
        alumno.setId(alumnoModel.getId());

        Persona persona = new Persona();
        persona.setId(alumnoModel.getPersona_id());
        alumno.setPersona(persona);

        return alumno;
    }
}
