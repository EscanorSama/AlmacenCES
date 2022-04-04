package com.ces.almacen.converters;

import com.ces.almacen.entities.Alumno;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.models.AlumnoModel;
import org.springframework.stereotype.Component;

@Component
public class AlumnoConverter {
    public AlumnoModel entityToModel(Alumno alumno){
        AlumnoModel alumnoModel = new AlumnoModel();
        alumnoModel.setAlumnoId(alumno.getId());
        alumnoModel.setMail(alumno.getPersona().getMail());
        alumnoModel.setMail(alumno.getPersona().getMail());
        alumnoModel.setNombre(alumno.getPersona().getNombre());
        alumnoModel.setApellido(alumno.getPersona().getApellido());
        alumnoModel.setDni(alumno.getPersona().getDni());
        alumnoModel.setId(alumno.getPersona().getId());
        return alumnoModel;
    }

    public Alumno modelToEntity(AlumnoModel alumnoModel){
        Alumno alumno = new Alumno();
        alumno.setId(alumnoModel.getAlumnoId());
        return alumno;
    }
}
