package com.ces.almacen.converters;

import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ArmarioModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArmarioConverter {
    public ArmarioModel entityToModel(Armario armario){
        ArmarioModel armarioModel= new ArmarioModel();
        armarioModel.setArmarioId(armario.getId());
        armarioModel.setDescripcion(armario.getContenedor().getDescripcion());
        armarioModel.setZona(armario.getContenedor().getZona());
        armarioModel.setNumero(armario.getContenedor().getNumero());
        //armarioModel.setProfesorId(armario.getProfesor().getId());

        return armarioModel;
    }

    public Armario modelToEntity(ArmarioModel armarioModel){
        Armario armario = new Armario();

        /*Profesor profesor = new Profesor();
        Long profesorId = armarioModel.getProfesorId();
        profesor.setId(profesorId);
        armario.setProfesor(profesor);*/

        return armario;
    }

    public List<ArmarioModel> listEntityToListModel(List<Armario> armarios){
        List<ArmarioModel> armariosModel = new ArrayList<>();
        for (Armario armario: armarios) {
            ArmarioModel armarioModel = this.entityToModel(armario);
            armariosModel.add(armarioModel);
        }
        return armariosModel;
    }

    public List<Armario> listModelToListEntity(List<ArmarioModel> armariosModel){
        List<Armario> armarios= new ArrayList<>();
        for (ArmarioModel armarioModel: armariosModel) {
            Armario armario = this.modelToEntity(armarioModel);
            armarios.add(armario);
        }
        return armarios;
    }
}
