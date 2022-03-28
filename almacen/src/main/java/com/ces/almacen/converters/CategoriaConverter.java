package com.ces.almacen.converters;

import com.ces.almacen.entities.Categoria;
import com.ces.almacen.models.CategoriaModel;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConverter {
    public CategoriaModel entityToModel (Categoria categoria){
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(categoria.getId());
        return categoriaModel;
    }

    public Categoria modelToEntity(CategoriaModel categoriaModel){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaModel.getId());
        return categoria;
    }
}
