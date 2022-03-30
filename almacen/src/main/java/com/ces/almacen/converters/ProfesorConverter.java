package com.ces.almacen.converters;

import com.ces.almacen.entities.Persona;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ProfesorModel;
import org.springframework.stereotype.Component;

import java.util.prefs.PreferencesFactory;

@Component
public class ProfesorConverter {
    public ProfesorModel entityToModel(Profesor profesor){
        ProfesorModel profesorModel = new ProfesorModel();
        profesorModel.setProfesorId(profesor.getId());
        profesorModel.setNombre(profesor.getPersona().getNombre());
        profesorModel.setApellido(profesor.getPersona().getApellido());
        profesorModel.setDni(profesor.getPersona().getDni());
        profesorModel.setMail(profesor.getPersona().getMail());
        profesorModel.setNumSs(profesor.getNumSs());
        profesorModel.setSalario(profesor.getSalario());
        return profesorModel;
    }

    public Profesor modelToEntity (ProfesorModel profesorModel){
        Profesor profesor = new Profesor();
        profesor.setNumSs(profesorModel.getNumSs());
        profesor.setSalario(profesorModel.getSalario());
        return profesor;
    }


}
