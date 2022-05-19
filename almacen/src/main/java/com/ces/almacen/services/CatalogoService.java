package com.ces.almacen.services;

import com.ces.almacen.converters.CatalogoConverter;
import com.ces.almacen.entities.Catalogo;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.CatalogoModel;
import com.ces.almacen.repositories.CatalogoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatalogoService {

    @Autowired
    private ContenedorService contenedorService;

    @Autowired
    private CatalogoConverter catalogoConverter;

    @Autowired
    private CatalogoRepository catalogoRepository;


    public CatalogoModel insertCatalogo(CatalogoModel catalogoModel) {
        Catalogo catalogo = catalogoConverter.modelToEntity(catalogoModel);
        Contenedor contenedor = contenedorService.insertContenedor(catalogoModel,"Catalogo");
        catalogo.setContenedor(contenedor);
        catalogoModel.setCatalogoId(catalogoRepository.save(catalogo).getCatalogoId());
        return catalogoModel;
    }
}
