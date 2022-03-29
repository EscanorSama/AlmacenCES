package com.ces.almacen.converters;

import com.ces.almacen.entities.Alumno;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.models.TaquillaModel;
import org.springframework.stereotype.Component;

@Component
public class TaquillaConverter {
    public TaquillaModel entityToModel (Taquilla taquilla){
        TaquillaModel taquillaModel = new TaquillaModel();
        taquillaModel.setId(taquilla.getId());
        taquillaModel.setContenedor_id(taquilla.getContenedor().getId());
        taquillaModel.setAlumno_id(taquilla.getAlumno().getId());
        return taquillaModel;
    }

    public Taquilla modelToEntity(TaquillaModel taquillaModel){
        Taquilla taquilla = new Taquilla();
        taquilla.setId(taquillaModel.getId());

        Contenedor contenedor = new Contenedor();
        contenedor.setId(taquillaModel.getContenedor_id());
        taquilla.setContenedor(contenedor);

        Alumno alumno = new Alumno();
        alumno.setId(taquillaModel.getId());
        taquilla.setAlumno(alumno);

        return taquilla;
    }
}
