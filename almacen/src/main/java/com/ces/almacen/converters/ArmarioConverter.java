package com.ces.almacen.converters;

import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ArmarioModel;
import org.springframework.stereotype.Component;

@Component
public class ArmarioConverter {
    public ArmarioModel entityToModel(Armario armario){
        ArmarioModel armarioModel= new ArmarioModel();
        armarioModel.setId(armario.getId());
        armarioModel.setContenedor_id(armario.getContenedor().getId());
        armarioModel.setProfesor_id(armario.getProfesor().getId());
        return armarioModel;
    }

    public Armario modelToEntity(ArmarioModel armarioModel){
        Armario armario = new Armario();
        armario.setId(armarioModel.getId());

        Contenedor contenedor = new Contenedor();
        contenedor.setId(armarioModel.getContenedor_id());
        armario.setContenedor(contenedor);

        Profesor profesor = new Profesor();
        profesor.setId(armarioModel.getProfesor_id());
        armario.setProfesor(profesor);

        return armario;
    }
}
