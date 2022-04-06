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
        alumnoModel.setNombre(alumno.getPersona().getNombre());
        alumnoModel.setApellido(alumno.getPersona().getApellido());
        alumnoModel.setDni(alumno.getPersona().getDni());
        alumnoModel.setAlumnoId(alumno.getPersona().getId());
        alumnoModel.setDomicilio(alumno.getDomicilio());
        alumnoModel.setPoblacion(alumno.getPoblacion());
        alumnoModel.setProvincia(alumno.getProvincia());
        alumnoModel.setCodigoPostal(alumno.getCodigoPostal());
        alumnoModel.setTelefono(alumno.getTelefono());
        alumnoModel.setMovil(alumnoModel.getMovil());

        return alumnoModel;
    }

    public Alumno modelToEntity(AlumnoModel alumnoModel){
        Alumno alumno = new Alumno();
        alumno.setId(alumnoModel.getAlumnoId());
        alumno.setDomicilio(alumnoModel.getDomicilio());
        alumno.setPoblacion(alumnoModel.getPoblacion());
        alumno.setProvincia(alumnoModel.getProvincia());
        alumno.setCodigoPostal(alumnoModel.getCodigoPostal());
        alumno.setTelefono(alumnoModel.getTelefono());
        alumno.setMovil(alumnoModel.getMovil());
        return alumno;
    }
}
