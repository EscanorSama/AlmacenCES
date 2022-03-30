package com.ces.almacen.services;

import com.ces.almacen.converters.CategoriaConverter;
import com.ces.almacen.entities.Categoria;
import com.ces.almacen.models.CategoriaModel;
import com.ces.almacen.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaConverter categoriaConverter;

    public void insertCategoria(CategoriaModel categoriaModel) {
        Categoria categoria = categoriaConverter.modelToEntity(categoriaModel);
        categoriaRepository.save(categoria);

    }

    public Optional<CategoriaModel> deleteCategoria(Long id) {
        Optional<CategoriaModel> resultCm = Optional.empty();
        Optional<Categoria> result = categoriaRepository.findById(id);
        if(result.isPresent()){
            Categoria categoria = result.get();
            CategoriaModel categoriaModel = categoriaConverter.entityToModel(categoria);
            resultCm = Optional.of(categoriaModel);
            categoriaRepository.delete(categoria);
        }
        return resultCm;
    }

    public Optional<CategoriaModel> getCategoria(Long id) {
        Optional<CategoriaModel> resultCm = Optional.empty();
        Optional<Categoria> result = categoriaRepository.findById(id);
        if (result.isPresent()){
            Categoria categoria = result.get();
            CategoriaModel categoriaModel = categoriaConverter.entityToModel(categoria);
            resultCm = Optional.of(categoriaModel);
        }
        return resultCm;
    }

    public List<CategoriaModel> getCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaModel> categoriaModels = listCategoriaToCategoriaModel(categorias);
        return categoriaModels;
    }

    private List<CategoriaModel> listCategoriaToCategoriaModel(List<Categoria> categorias) {
        List<CategoriaModel> categoriaModels = new ArrayList<>();
        for (Categoria categoria: categorias) {
            CategoriaModel categoriaModel = categoriaConverter.entityToModel(categoria);
            categoriaModels.add(categoriaModel);
        }
        return categoriaModels;
    }
}
