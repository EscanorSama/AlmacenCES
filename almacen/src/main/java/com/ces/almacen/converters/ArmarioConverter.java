package com.ces.almacen.converters;

import com.ces.almacen.entities.Armario;
import com.ces.almacen.models.ArmarioModel;
import org.springframework.stereotype.Component;

@Component
public class ArmarioConverter {
    public ArmarioModel entityToModel(Armario armario){
        ArmarioModel armarioModel= new ArmarioModel();
        armarioModel.setId(armario.getId());
        return armarioModel;
    }

    public Armario modelToEntity(ArmarioModel armarioModel){
        Armario armario = new Armario();
        armario.setId(armarioModel.getId());
        return armario;
    }
}
