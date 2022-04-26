package com.ces.almacen.converters;

import com.ces.almacen.entities.Aula;
import com.ces.almacen.models.AulaModel;
import org.springframework.stereotype.Component;

@Component
public class AulaConverter {

    public AulaModel entityToModel(Aula aula){
        AulaModel aulaModel = new AulaModel();
        aulaModel.setId(aulaModel.getId());
        return aulaModel;
    }

    public Aula modelToEntity(AulaModel aulaModel){
        Aula aula = new Aula();
        aula.setId(aulaModel.getId());
        return aula;
    }

}
