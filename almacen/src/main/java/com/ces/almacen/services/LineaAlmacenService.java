package com.ces.almacen.services;

import com.ces.almacen.converters.LineaAlmacenConverter;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.repositories.ContenedorRepository;
import com.ces.almacen.repositories.LineaAlmacenRepository;
import com.ces.almacen.repositories.MaterialRepository;
import com.ces.almacen.utils.UtilsDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LineaAlmacenService {

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    @Autowired
    private LineaAlmacenRepository lineaAlmacenRepository;

    @Autowired
    private UtilsDate utilsDate;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ContenedorRepository contenedorRepository;


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

    public void updateLineaContenedor(Long id, Long contenedorId) {
        Optional<LineaAlmacen> result = lineaAlmacenRepository.findById(id);
        if (result.isPresent()){
            LineaAlmacen lineaAlmacen = result.get();



            Contenedor contenedor = lineaAlmacen.getContenedor();



            lineaAlmacenRepository.save(lineaAlmacen);

        }
    }
}
