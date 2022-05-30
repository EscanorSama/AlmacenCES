package com.ces.almacen.converters;

import com.ces.almacen.entities.Alumno;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.models.AlumnoModel;
import com.ces.almacen.models.TaquillaModel;
import com.ces.almacen.repositories.TaquillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlumnoConverter {
    @Autowired
    private TaquillaConverter taquillaConverter;

    @Autowired
    private TaquillaRepository taquillaRepository;

    public AlumnoModel entityToModel(Alumno alumno){
        AlumnoModel alumnoModel = new AlumnoModel();

        alumnoModel.setAlumnoId(alumno.getId());
        alumnoModel.setPersonaId(alumno.getPersona().getId());
        alumnoModel.setMail(alumno.getPersona().getMail());
        alumnoModel.setNombre(alumno.getPersona().getNombre());
        alumnoModel.setApellido(alumno.getPersona().getApellido());
        alumnoModel.setTipo(alumno.getPersona().getTipo());
        alumnoModel.setDni(alumno.getPersona().getDni());
        alumnoModel.setAlumnoId(alumno.getPersona().getId());
        alumnoModel.setDomicilio(alumno.getDomicilio());
        alumnoModel.setPoblacion(alumno.getPoblacion());
        alumnoModel.setProvincia(alumno.getProvincia());
        alumnoModel.setCodigoPostal(alumno.getCodigoPostal());
        alumnoModel.setTelefono(alumno.getTelefono());
        alumnoModel.setMovil(alumno.getMovil());
        alumnoModel.setNumExpediente(alumno.getNumExpediente());


        if (alumno.getTaquilla()!=null) {
            Taquilla taquilla;
            taquilla = alumno.getTaquilla();
            alumnoModel.setTaquilla(taquillaConverter.entityToModel(taquilla));
        }
        return alumnoModel;
    }

    public Alumno modelToEntity(AlumnoModel alumnoModel){
        Alumno alumno = new Alumno();
        alumno.setNumExpediente(alumnoModel.getNumExpediente());
        alumno.setId(alumnoModel.getAlumnoId());
        alumno.setDomicilio(alumnoModel.getDomicilio());
        alumno.setPoblacion(alumnoModel.getPoblacion());
        alumno.setProvincia(alumnoModel.getProvincia());
        alumno.setCodigoPostal(alumnoModel.getCodigoPostal());
        alumno.setTelefono(alumnoModel.getTelefono());
        alumno.setMovil(alumnoModel.getMovil());

        Persona persona = new Persona();
        persona.setId(alumnoModel.getPersonaId());
        persona.setMail(alumnoModel.getMail());
        persona.setNombre(alumnoModel.getNombre());
        persona.setApellido(alumnoModel.getApellido());
        persona.setDni(alumnoModel.getDni());
        persona.setTipo(alumnoModel.getTipo());
        alumno.setPersona(persona);

        return alumno;
    }
}
