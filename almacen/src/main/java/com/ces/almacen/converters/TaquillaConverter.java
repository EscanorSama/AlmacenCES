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
        taquillaModel.setTaquillaId(taquilla.getId());
        taquillaModel.setDescripcion(taquilla.getContenedor().getDescripcion());
        taquillaModel.setZona(taquilla.getContenedor().getZona());
        taquillaModel.setNumero(taquilla.getContenedor().getNumero());

        return taquillaModel;
    }

    public Taquilla modelToEntity(TaquillaModel taquillaModel){
        Taquilla taquilla = new Taquilla();
        return taquilla;
    }
}
