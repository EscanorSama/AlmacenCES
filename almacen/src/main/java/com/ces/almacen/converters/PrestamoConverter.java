package com.ces.almacen.converters;

import com.ces.almacen.entities.Prestamo;
import com.ces.almacen.models.PrestamoModel;
import org.springframework.stereotype.Component;

@Component
public class PrestamoConverter {

    public PrestamoModel entityToModel(Prestamo prestamo){
        PrestamoModel prestamoModel = new PrestamoModel();
        prestamoModel.setId(prestamo.getId());
        return prestamoModel;
    }

    public Prestamo modelToEntity(PrestamoModel prestamoModel){
        Prestamo prestamo = new Prestamo();
        prestamo.setId(prestamoModel.getId());
        return prestamo;
    }
}
