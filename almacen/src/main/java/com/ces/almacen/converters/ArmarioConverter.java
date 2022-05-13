package com.ces.almacen.converters;

import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ArmarioModel;
import com.ces.almacen.models.ContenedorModel;
import com.ces.almacen.models.LineaAlmacenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class ArmarioConverter {

    @Autowired
    private ContenedorConverter contenedorConverter;

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    public ArmarioModel entityToModel(Armario armario){
        ArmarioModel armarioModel= new ArmarioModel();
        armarioModel.setArmarioId(armario.getId());

    if(armario.getContenedor()!=null) {
        ContenedorModel contenedor = contenedorConverter.entityToModel(armario.getContenedor());
        armarioModel.setDescripcion(contenedor.getDescripcion());
        armarioModel.setZona(armario.getContenedor().getZona());
        armarioModel.setNumero(armario.getContenedor().getNumero());
        armarioModel.setTipo(armario.getContenedor().getTipo());
        //armarioModel.setProfesorId(armario.getProfesor().getId());
    }
        return armarioModel;
    }

    public Armario modelToEntity(ArmarioModel armarioModel){
        Armario armario = new Armario();
        armario.setId(armarioModel.getArmarioId());
        Contenedor contenedor = new Contenedor();
        contenedor.setId(armarioModel.getContenedorId());
        contenedor.setNumero(armarioModel.getNumero());
        contenedor.setDescripcion(armarioModel.getDescripcion());
        contenedor.setZona(armarioModel.getZona());
        contenedor.setTipo(armarioModel.getTipo());
        List<LineaAlmacenModel> lineasAlmacenModel = armarioModel.getLineasAlmacen();
        List<LineaAlmacen> lineasAlmacen =lineaAlmacenConverter.listModelToListEntity(lineasAlmacenModel);
        contenedor.setLineasAlmacen(lineasAlmacen);

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
