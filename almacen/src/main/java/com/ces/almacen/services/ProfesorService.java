package com.ces.almacen.services;

import com.ces.almacen.converters.ArmarioConverter;
import com.ces.almacen.converters.ProfesorConverter;
import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ArmarioModel;
import com.ces.almacen.models.ProfesorModel;
import com.ces.almacen.repositories.ArmarioRepository;
import com.ces.almacen.repositories.PersonaRepository;
import com.ces.almacen.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorConverter profesorConverter;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ArmarioRepository armarioRepository;

    @Autowired
    private ArmarioConverter armarioConverter;


    public ProfesorModel insertProfesor(ProfesorModel profesorModel) {
        Persona persona = personaService.insertPersona(profesorModel);
        Profesor profesor = profesorConverter.modelToEntity(profesorModel);
        profesor.setPersona(persona);
        profesorModel.setProfesorId(profesorRepository.save(profesor).getId());
        return profesorModel;
    }


    public void insertArmario(List<Long> armarioId, Long profesorId){

        List<Armario> resultArmario = armarioRepository.findAllById(armarioId);

        Optional<Profesor> resultProfesor = profesorRepository.findById(profesorId);

        if (!resultArmario.isEmpty() &&  resultProfesor.isPresent()){

            Profesor profesor = resultProfesor.get();

            profesor.setArmarios(resultArmario);

            for (Armario armario:resultArmario) {
                armario.setProfesor(profesor);
                armarioRepository.save(armario);
            }

            profesorRepository.save(profesor);


        }

    }


    public Optional<ProfesorModel> deleteProfesor(Long id) {
        Optional<ProfesorModel> resultPm = Optional.empty();
        Optional<Profesor> result = profesorRepository.findById(id);
        if(result.isPresent()){
            Profesor profesor = result.get();
            ProfesorModel profesorModel = profesorConverter.entityToModel(profesor);
            resultPm = Optional.of(profesorModel);
            profesorRepository.delete(profesor);
        }
        return resultPm;
    }

    public Optional<ProfesorModel> getProfesor(long id) {
        Optional<ProfesorModel> resultPm = Optional.empty();
        Optional<Profesor> result = profesorRepository.findById(id);
        if(result.isPresent()){
            Profesor profesor = result.get();
            ProfesorModel profesorModel = profesorConverter.entityToModel(profesor);
            resultPm = Optional.of(profesorModel);
        }
        return resultPm;
    }

    public List<ProfesorModel> getProfesores() {
        List<Profesor>profesores = profesorRepository.findAll();
        List<ProfesorModel> profesoresModel = listProfesoresToListProfesoresModel(profesores);
        return profesoresModel;
    }

    public void updateProfesor(ProfesorModel profesorM){

        Optional<Profesor> result = profesorRepository.findById(profesorM.getProfesorId());
        if (result.isPresent()){
           Profesor profesorConvertido = profesorConverter.modelToEntity(profesorM);
           personaRepository.save(profesorConvertido.getPersona());
           profesorRepository.save(profesorConvertido);
        }
    }

    private List<ProfesorModel> listProfesoresToListProfesoresModel(List<Profesor> profesores) {
        List<ProfesorModel> profesoresModel = new ArrayList<>();
        for (Profesor profesor : profesores) {
            ProfesorModel profesorModel = profesorConverter.entityToModel(profesor);
            profesoresModel.add(profesorModel);
        }
        return profesoresModel;
    }

    public List<ProfesorModel> insertProfesores(List<ProfesorModel> profesoresModel) {
        for (ProfesorModel profesorModel: profesoresModel) {
            insertProfesor(profesorModel);
        }
        return profesoresModel;
    }

    public List<ProfesorModel> getProfesoresPag(int nPag, int tPag){
        Pageable pageable = PageRequest.of(nPag, tPag);
        Page<Profesor> profesoresPag = profesorRepository.findAll(pageable);
        List<Profesor> profesores = profesoresPag.getContent();
        List<ProfesorModel> profesoresModel = listProfesoresToListProfesoresModel(profesores);
        return profesoresModel;
    }

    public int getNumProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        return  profesores.size();
    }
}
