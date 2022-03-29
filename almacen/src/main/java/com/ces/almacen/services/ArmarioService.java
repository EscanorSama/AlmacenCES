package com.ces.almacen.services;

import com.ces.almacen.converters.ArmarioConverter;
import com.ces.almacen.entities.Armario;
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

    public void insertArmario(ArmarioModel armarioModel) {
        Armario armario = armarioConverter.modelToEntity(armarioModel);
        armarioRepository.save(armario);
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
