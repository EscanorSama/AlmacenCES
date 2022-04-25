package com.ces.almacen.converters;

import com.ces.almacen.entities.Categoria;
import com.ces.almacen.entities.Material;
import com.ces.almacen.models.CategoriaModel;
import com.ces.almacen.models.MaterialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaConverter {


    public CategoriaModel entityToModel (Categoria categoria){
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(categoria.getId());
        categoriaModel.setNombre(categoria.getNombre());

        return categoriaModel;
    }

    public Categoria modelToEntity(CategoriaModel categoriaModel){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaModel.getId());
        categoria.setNombre(categoriaModel.getNombre());

        return categoria;
    }

    public List<CategoriaModel> listEntityToListModel(List<Categoria> categorias){
        List<CategoriaModel> categoriasModel = new ArrayList<>();
        for (Categoria categoria: categorias) {
            CategoriaModel categoriaModel = this.entityToModel(categoria);
            categoriasModel.add(categoriaModel);
        }
        return categoriasModel;
    }

    public List<Categoria> listModelToListEntity(List<CategoriaModel> categoriasModel){
        List<Categoria> categorias = new ArrayList<>();
        for (CategoriaModel categoriaModel: categoriasModel) {
            Categoria categoria = this.modelToEntity(categoriaModel);
            categorias.add(categoria);
        }
        return categorias;
    }

}
