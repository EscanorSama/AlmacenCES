package com.ces.almacen.converters;

import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ProfesorModel;
import org.springframework.stereotype.Component;

import java.util.prefs.PreferencesFactory;

@Component
public class ProfesorConverter {
    public ProfesorModel entityToModel(Profesor profesor){
        ProfesorModel profesorModel = new ProfesorModel();
        profesorModel.setId(profesor.getId());
        profesorModel.setNumSs(profesor.getNumSs());
        profesorModel.setSalario(profesor.getSalario());
        return profesorModel;
    }

    public Profesor modelToEntity (ProfesorModel profesorModel){
        Profesor profesor = new Profesor();
        profesor.setId(profesorModel.getId());
        profesor.setNumSs(profesorModel.getNumSs());
        profesor.setSalario(profesorModel.getSalario());
        return profesor;
    }


}
