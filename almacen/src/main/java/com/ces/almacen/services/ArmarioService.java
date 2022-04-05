package com.ces.almacen.services;

import com.ces.almacen.converters.ArmarioConverter;
import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ArmarioModel;
import com.ces.almacen.repositories.ArmarioRepository;
import com.ces.almacen.repositories.ContenedorRepository;
import com.ces.almacen.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArmarioService {
    @Autowired
    private ArmarioRepository armarioRepository;

    @Autowired
    private ArmarioConverter armarioConverter;

    @Autowired
    private ContenedorService contenedorService;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ContenedorRepository contenedorRepository;

    public ArmarioModel insertArmario(ArmarioModel armarioModel) {
        Contenedor contenedor = contenedorService.insertContenedor(armarioModel);
        Armario armario = armarioConverter.modelToEntity(armarioModel);
        armario.setContenedor(contenedor);

        if(armarioModel.getProfesorId()!=0){ //hay profesor asociado
            Optional<Profesor> profesor = profesorRepository.findById(armarioModel.getProfesorId());
            if(profesor.isPresent()){ //el profesor existe en la base de datos
                armario.setProfesor(profesor.get());
            }
        }
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

    public List<ArmarioModel> getArmarios() {
        List<Armario> armarios = armarioRepository.findAll();
        List<ArmarioModel> armariosModel = listArmarioToListArmarioModel(armarios);
        return armariosModel;
    }

    private List<ArmarioModel> listArmarioToListArmarioModel(List<Armario> armarios) {
        List<ArmarioModel> armariosModel = new ArrayList<>();
        for (Armario armario: armarios) {
            ArmarioModel armarioModel = armarioConverter.entityToModel(armario);
            armariosModel.add(armarioModel);
        }
        return armariosModel;
    }

    public void updateArmario(ArmarioModel armarioModel) {
        Optional<Armario> result = armarioRepository.findById(armarioModel.getArmarioId());
        if (result.isPresent()){
            Armario armario = result.get();
            Contenedor contenedor = armario.getContenedor();
            contenedor.setZona(armarioModel.getZona());
            contenedor.setDescripcion(armarioModel.getDescripcion());
            contenedor.setNumero(armarioModel.getNumero());
            contenedorRepository.save(contenedor);
            armarioRepository.save(armario);
        }
    }
}
