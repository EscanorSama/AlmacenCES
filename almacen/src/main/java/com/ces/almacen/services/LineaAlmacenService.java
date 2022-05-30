package com.ces.almacen.services;

import com.ces.almacen.converters.LineaAlmacenConverter;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.repositories.LineaAlmacenRepository;
import com.ces.almacen.utils.UtilsDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineaAlmacenService {

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    @Autowired
    private LineaAlmacenRepository lineaAlmacenRepository;

    @Autowired
    private UtilsDate utilsDate;


    public LineaAlmacen insertLineaAlmacen(LineaAlmacenModel lineaAlmacenModel) {
        lineaAlmacenModel.setFecha(utilsDate.getSqlSysDate());//fecha del sistema
        LineaAlmacen lineaAlmacen = lineaAlmacenConverter.modelToEntity(lineaAlmacenModel);
        lineaAlmacen = lineaAlmacenRepository.save(lineaAlmacen);
        return lineaAlmacen;
    }

    public List<LineaAlmacenModel> getLineasContenedor() {
        List<LineaAlmacen> lineasAlmacen = lineaAlmacenRepository.findAll();
        return lineaAlmacenConverter.listEntityToListModel(lineasAlmacen);

    }
}
