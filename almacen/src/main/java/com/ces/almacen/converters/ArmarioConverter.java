package com.ces.almacen.converters;

import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Lazy
@Component
public class ArmarioConverter {

    @Autowired
    private ContenedorConverter contenedorConverter;

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    @Lazy
    @Autowired
    private ProfesorConverter profesorConverter;


    public ArmarioModel entityToModel(Armario armario){
        ArmarioModel armarioModel= new ArmarioModel();
        armarioModel.setArmarioId(armario.getId());
        armarioModel.setContenedorId(armario.getContenedor().getId());
        armarioModel.setDescripcion(armario.getContenedor().getDescripcion());
        armarioModel.setZona(armario.getContenedor().getZona());
        armarioModel.setNumero(armario.getContenedor().getNumero());
        armarioModel.setTipo("Armario");
        List<LineaAlmacenModel> lineasAlmacen = lineaAlmacenConverter.listEntityToListModel(armario.getContenedor().getLineasAlmacen());
        armarioModel.setLineasAlmacen(lineasAlmacen);

        if(armario.getProfesor() != null)  {
            armario.getProfesor().setArmarios(null) ;
            ProfesorModel profesorModel = profesorConverter.entityToModel(armario.getProfesor());
            armarioModel.setProfesor(profesorModel);
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
        contenedor.setTipo("Armario");
        List<LineaAlmacenModel> lineasAlmacenModel = armarioModel.getLineasAlmacen();
        List<LineaAlmacen> lineasAlmacen =lineaAlmacenConverter.listModelToListEntity(lineasAlmacenModel);
        contenedor.setLineasAlmacen(lineasAlmacen);
        armario.setContenedor(contenedor);
        if(armarioModel.getProfesor()!=null){
        Profesor profesor = new Profesor();
        profesor.setId(armarioModel.getProfesor().getProfesorId());
        armario.setProfesor(profesor);}
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
