package com.ces.almacen.converters;

import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.models.TaquillaModel;
import org.springframework.stereotype.Component;

@Component
public class TaquillaConverter {
    public TaquillaModel entityToModel (Taquilla taquilla){
        TaquillaModel taquillaModel = new TaquillaModel();
        taquillaModel.setId(taquilla.getId());
        return taquillaModel;
    }

    public Taquilla modelToEntity(TaquillaModel taquillaModel){
        Taquilla taquilla = new Taquilla();
        taquilla.setId(taquillaModel.getId());
        return taquilla;
    }
}
