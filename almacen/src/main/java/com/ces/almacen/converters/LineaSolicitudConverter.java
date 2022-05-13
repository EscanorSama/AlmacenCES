package com.ces.almacen.converters;

import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.LineaSolicitud;
import com.ces.almacen.entities.Material;
import com.ces.almacen.entities.Solicitud;
import com.ces.almacen.models.ArmarioModel;
import com.ces.almacen.models.LineaSolicitudModel;
import com.ces.almacen.models.MaterialModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class LineaSolicitudConverter {

    @Autowired
    private MaterialConverter materialConverter;

    @Autowired
    private ArmarioConverter armarioConverter;

    public LineaSolicitudModel entityToModel(LineaSolicitud lineaSolicitud){
        LineaSolicitudModel lineaSolicitudModel = new LineaSolicitudModel();
        lineaSolicitudModel.setId(lineaSolicitud.getId());
        lineaSolicitudModel.setEstado(lineaSolicitud.isEstado());
        lineaSolicitudModel.setCantidad(lineaSolicitud.getCantidad());

        if (lineaSolicitud.getMaterial()!=null) {
            MaterialModel materialModel = materialConverter.entityToModel(lineaSolicitud.getMaterial());
            lineaSolicitudModel.setMaterial(materialModel);
        }
        //lineaSolicitudModel.setMaterialId(lineaSolicitud.getMaterial().getId());
        lineaSolicitudModel.setSolicitudId(lineaSolicitud.getSolicitud().getId());
        if (lineaSolicitud.getArmario()!=null) {
            ArmarioModel armarioModel = armarioConverter.entityToModel(lineaSolicitud.getArmario());
            lineaSolicitudModel.setArmario(armarioModel);
        }
        return lineaSolicitudModel;
    }

    public LineaSolicitud modelToEntity(LineaSolicitudModel lineaSolicitudModel){
        LineaSolicitud lineaSolicitud = new LineaSolicitud();
        lineaSolicitud.setId(lineaSolicitudModel.getId());
        lineaSolicitud.setEstado(lineaSolicitudModel.isEstado());
        lineaSolicitud.setCantidad(lineaSolicitudModel.getCantidad());



        Solicitud solicitud = new Solicitud();
        solicitud.setId(lineaSolicitudModel.getSolicitudId());
        lineaSolicitud.setSolicitud(solicitud);

        /*Material material = new Material();
        material.setId(lineaSolicitudModel.getMaterial().getId());
        lineaSolicitud.setMaterial(material);*/

        MaterialModel materialModel =lineaSolicitudModel.getMaterial();
        lineaSolicitud.setMaterial(materialConverter.modelToEntity(materialModel));

        Armario armario = new Armario();
        armario.setId(lineaSolicitudModel.getArmario().getArmarioId());
        lineaSolicitud.setArmario(armario);

        return lineaSolicitud;
    }

    public List<LineaSolicitud> listLineaSolicitudModelToListLineaSolicitud(List<LineaSolicitudModel> lineasSolicitudModel){
        List<LineaSolicitud> lineasSolicitud = new ArrayList<>();
        for (LineaSolicitudModel lineaSolicitudModel: lineasSolicitudModel) {
            log.info("******* "+lineaSolicitudModel);
            LineaSolicitud lineaSolicitud = this.modelToEntity(lineaSolicitudModel);
            lineasSolicitud.add(lineaSolicitud);
        }
        return lineasSolicitud;
    }

    public List<LineaSolicitudModel> listLineaSolicitudToListLineaSolicitudModel(List<LineaSolicitud> lineasSolicitud){
        List<LineaSolicitudModel> lineasSolicitudModel = new ArrayList<>();
        if(lineasSolicitud!=null) {
            for (LineaSolicitud lineaSolicitud : lineasSolicitud) {
                LineaSolicitudModel lineaSolicitudModel = this.entityToModel(lineaSolicitud);
                lineasSolicitudModel.add(lineaSolicitudModel);
            }
        }
        return lineasSolicitudModel;
    }
}
