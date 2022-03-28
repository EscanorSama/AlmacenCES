package com.ces.almacen.converters;

import com.ces.almacen.entities.Alumno;
import com.ces.almacen.models.AlumnoModel;
import org.springframework.stereotype.Component;

@Component
public class AlumnoConverter {
    public AlumnoModel entityToModel(Alumno alumno){
        AlumnoModel alumnoModel = new AlumnoModel();
        alumnoModel.setId(alumno.getId());
        return alumnoModel;
    }

    public Alumno modelToEntity(AlumnoModel alumnoModel){
        Alumno alumno = new Alumno();
        alumno.setId(alumnoModel.getId());
        return alumno;
    }
}
