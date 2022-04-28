package com.ces.almacen.services;

import com.ces.almacen.converters.LineaAlmacenConverter;
import com.ces.almacen.entities.LineaAlmacen;
import com.ces.almacen.models.LineaAlmacenModel;
import com.ces.almacen.repositories.LineaAlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineaAlmacenService {

    @Autowired
    private LineaAlmacenConverter lineaAlmacenConverter;

    @Autowired
    private LineaAlmacenRepository lineaAlmacenRepository;

    public LineaAlmacen insertLineaAlmacen(LineaAlmacenModel lineaAlmacenModel) {
        LineaAlmacen lineaAlmacen = lineaAlmacenConverter.modelToEntity(lineaAlmacenModel);
        lineaAlmacen = lineaAlmacenRepository.save(lineaAlmacen);
        return lineaAlmacen;
    }
}
