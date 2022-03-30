package com.ces.almacen.services;

import com.ces.almacen.converters.ArmarioConverter;
import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.models.ArmarioModel;
import com.ces.almacen.repositories.ArmarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArmarioService {
    @Autowired
    private ArmarioRepository armarioRepository;

    @Autowired
    private ArmarioConverter armarioConverter;

    @Autowired
    private ContenedorService contenedorService;

    public ArmarioModel insertArmario(ArmarioModel armarioModel) {
        Contenedor contenedor = contenedorService.insertContenedor(armarioModel);
        Armario armario = armarioConverter.modelToEntity(armarioModel);
        armario.setContenedor(contenedor);
        armarioModel.setArmarioId(armarioRepository.save(armario).getId());
        return armarioModel;
    }

    public Optional<ArmarioModel> deleteArmario(Long id) {
        Optional<ArmarioModel> resultAm = Optional.empty();
        Optional<Armario> result = armarioRepository.findById(id);
        if(result.isPresent()){
            Armario armario = result.get();
            ArmarioModel armarioModel = armarioConverter.entityToModel(armario);
            resultAm = Optional.of(armarioModel);
            armarioRepository.delete(armario);
        }
        return resultAm;
    }

    public Optional<ArmarioModel> getArmario(Long id) {
        Optional<ArmarioModel> resultAm = Optional.empty();
        Optional<Armario> result = armarioRepository.findById(id);
        if(result.isPresent()){
            Armario armario = result.get();
            ArmarioModel armarioModel = armarioConverter.entityToModel(armario);
            resultAm = Optional.of(armarioModel);
        }
        return resultAm;
    }
}
